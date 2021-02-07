package cis5511.TopSort;

class LinkedList {
    Node head;
    LinkedList(){
        head = new Node();
    }
    class Node {
        int data;
        Node next;
        Node prev;

        Node() {
            next = null;
            prev = null;
        }
    }
    void add(int val){
        Node ret = new Node();
        Node next;
        next = head.next;
        if(head.next == null){
            ret.prev = head;

        }else{
            next.prev = ret;
        }
        ret.data = val;
        ret.next = next;
        head.next = ret;
    }

    void add(int val, Node n){
        Node ret = new Node();
        ret.data = val;
        n.next = ret;
        ret.prev = n;
    }
}
