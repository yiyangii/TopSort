package cis5511.TopSort;

class LinkedList {

    Node head;
    LinkedList(){
        head = new Node();
    }
    class Node {
        int val;
        Node next;
        Node prev;

        Node() {
            next = null;
            prev = null;
        }
        Node(int val, Node next) {
            if (head.next == null){
                this.prev = head;
            }else{
                next.prev = this;
            }
            this.val = val;
            this.next = next;
        }
        Node(int val, Node next, Node prev){
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }
    //Given an integer, insert a Node with that integer value to the list.
    void add(int val){//Adding a node takes constant time.
        //Create a new node with head.next as the next connection.
        //Then make head.next be the new node.
        Node ret = new Node(val, head.next);
        head.next = ret;
    }
    //Given an integer and a Node, insert a Node with that integer value after the Node given.
    void add(int val, Node n){//Again, adding takes constant time.
        Node ret = new Node();
        ret.val = val;
        n.next = ret;
        ret.prev = n;
    }
    void add(int val, Node next, Node prev){
        Node ret= new Node();
        ret.val = val;
        ret.next = next;
        ret.prev = prev;
    }
    //Removes the first item in the list
    int remove(){//Removing takes constant time.
        if (head.next == null){
            System.out.println("Tried to remove with nothing here!");
            return -1;
        }
        Node ret = head.next;
        if (ret.next != null) {
            head.next = ret.next;
            ret.next.prev = head;
        } else{
            head.next = null;
        }
        return ret.val;
    }//Function to return length of the LL
    int length(){//Finding the length takes worst-case O(n) time.
        int count = 0;
        Node tmp = head;
        while(tmp.next != null){
            count++;
            tmp = tmp.next;
        }
        return count;
    }
    @Override
    public String toString(){
        Node tmp = head;
        String ret = "";
        while (tmp.next != null){
            ret += tmp.next.val + " ";
            tmp = tmp.next;
        }
        return ret;
    }
}
