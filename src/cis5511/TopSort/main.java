package cis5511.TopSort;
import java.io.*;

import java.util.Scanner;



public class main {
    static int n;
    //Initialization queue,linkedlist

    static Queue bag = null;
    static LinkedList[] successor = null;
    private static int index;
    private static int reversecount;
    static int counter;


    static int [] pred = null;
    static int [] output = null;
    String str = null;
    static String numbers = null;

    public static void main(String[] args){
        try{
            //read file
            File file = new File("test.txt");
            Scanner sc = new Scanner(file);
            //Line with two number
            //Read line and seperate each num using spilt
            String str = sc.nextLine();
            //Convert str to int
            //Store n into
            n = Integer.parseInt(str);
            //Create queue[n],Linkedlist[n],output array/counter array
            bag = new Queue();

            successor = new LinkedList[n];
            output = new int[n];
            pred = new int[n];
            //Keep readline
            while((numbers = sc.nextLine())!= null) {
                //seperate two number
                String[] tok = numbers.split(" ");
                int first = Integer.parseInt(tok[0]);
                int second = Integer.parseInt(tok[1]);
                //System.out.println(first + " " + second);
                if (first == 0 && second == 0) {
                    break;

                }
                //Add item to successor and pred linklist
                //succ will locate the succ of a specific node
                //if 5 connect to 4 and 3 then in index 5 will next with 4,3 node
                //pred will count the number of pred if pred is 0 then will add to bag to do the topsort
                if (successor[first - 1] == null) {
                    successor[first - 1] = new LinkedList();
                    successor[first - 1].add(second);
                } else {
                    successor[first - 1].add(second);
                }
                pred[second - 1]++;

            }
            /*for (int i = 0; i < n; i++) {
                System.out.println(successor[i]);


            }

            for (int i = 0; i < n; i++) {

                System.out.println(pred[i]);

            }
            */










        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //push if a node dont have any pred
        for (int i = 0; i < n; i++){
            if(pred[i] == 0){
                bag.push(i+1);
                //check bag with index 2/3/5
                //System.out.println(i+1);

            }
        }
        topsort();



    }

    private static void topsort() {
        int length = bag.length;


        while (length > 0) {
            //pop the last one of the bag
            //         a. remove an object from the bag and output it in the output ranking;
            //         b. for each successor of the output object, decrease its predecessor count by 1
            //         if the predecessor count becomes zero, add the successor to the bag.
            int predint = bag.pop();
            //should print 2 3 5 as the front of the queue
            //System.out.println(pred);
            length--;
            //add pred to the bag then we need to remove the connection between pred and successor
            //Ranking 5
            //System.out.println(predint);
            output[index++] = predint;

            //address the success
            //3,4/  4,1/  5,4/  3,1/
            //successor[] =1[]  2[]  3[4,1]  4[1] 5[4]
            //0 0 1,4 1 4
            //pred[] = 1[2(4,3)]  2[0] 3[0] 4[2(5,3)] 5[0]
            //2 0 0 2 0
            //go to each successor of this pred cancel connection
            //go to this pred in this case to find the successor of 2
            //go to its
            if (successor[predint - 1] != null) {
                //successor[pred -1].head is the first element of successor set of pred
                while (successor[predint - 1].head.next != null) {
                    int s = successor[predint - 1].head.next.val;
                    System.out.println(s);
                    pred[s - 1]--;
                    if (pred[s - 1] == 0) {
                        //push back successor of 2
                        bag.push(s);
                        System.out.println(s);
                        reversecount++;


                    }
                    //go to the next pred
                    successor[predint - 1].head.next = successor[predint - 1].head.next.next;
                }

            }
            topsort();
            for (int i = 0; i < reversecount; i++) {
                bag.remove_end();
            }
            bag.push(predint);

            if (successor[predint - 1] != null) {
                //successor[pred -1].head is the first element of successor set of pred
                while (successor[predint - 1].head.next != null) {
                    int s = successor[predint - 1].head.next.val;
                    pred[s - 1]++;
                    System.out.println(s);
                    successor[predint - 1].head.next = successor[predint - 1].head.next.next;
                }

            }
            counter--;


        }




    }


}
