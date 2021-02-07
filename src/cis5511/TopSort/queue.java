package cis5511.TopSort;


class Queue {
    private LinkedList q;
    private LinkedList.Node end;
    //Only track for the very last value
    private int length;


    Queue() {
        q = new LinkedList();
        end = q.head;
        int length;

    }
    int getLength(){
        this.length = length;
        return length;
    }
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
            return ret.data;
        }
        return -1;
    }

    void remove(){
        //make [1][2]
        //to [1]
        if (end.prev == q.head){
            end = q.head;
            q.head.next = null;
        } else {
            end = end.prev;
            end.next = null;
        }
        length--;
    }
    void push(int val) {
        q.add(val, end);
        end = end.next;
        length++;
    }
}
