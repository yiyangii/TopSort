package cis5511.TopSort;


class Queue {
    LinkedList q;
    LinkedList.Node end;
    int length;

    Queue() {//Our "queue" is a doubly linked list that also keeps track of the end (that's how the queue part works) and also keeps track of the length.
        q = new LinkedList();
        end = q.head;
        length = 0;

    }
    //Remove an element from the front. Takes constant time.
    int pop() {
        if (q.head.next != null) {
            LinkedList.Node ret = q.head.next;
            if (ret.next != null) {
                q.head.next = ret.next;
            } else {
                q.head.next = null;
                end = q.head;
            }
            length--;
            return ret.val;
        }
        return -1;
    }
    //remove an element from the end. Takes constant time.
    void remove_end(){
        if (end.prev == q.head){
            end = q.head;
            q.head.next = null;
        } else {
            end = end.prev;
            end.next = null;
        }
        length--;
    }
    //Push an item to the end. Takes constant time.
    void push(int val) {
        q.add(val, end);
        end = end.next;
        length++;
    }
    //Look at the first item in the list, or if the list is empty, return -1.
    int peek() {
        if (q.length() > 0) {
            return q.head.next.val;
        }
        return -1;
    }

    public String toString() {
        String ret = "";
        if (q.head.next != null) {
            LinkedList.Node tmp = q.head.next;
            ret += tmp.val;
            while (tmp.next != null) {
                tmp = tmp.next;
                ret += " " + tmp.val;
            }
        }
        return ret;
    }
}
