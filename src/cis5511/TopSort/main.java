package cis5511.TopSort;
import java.io.*;
import java.util.Queue;
import java.util.Scanner;



public class main {
    static int n;
    //Initialization queue,linkedlist

    static Queue[] bag = null;
    static LinkedList[] succ = null;
    int succcounter = 0;
    int predcounter = 0;
    int index = 0;
    static int [] counter = null;
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
            bag = new Queue[n];

            succ = new LinkedList[n];
            output = new int[n];
            counter = new int[n];
            //Keep readline
            while((numbers = sc.nextLine())!= null) {
                //seperate two number
                String[] tok = numbers.split(" ");
                int first = Integer.parseInt(tok[0]);
                int second = Integer.parseInt(tok[1]);
                System.out.println(first + " " + second);
                if (first == 0 && second == 0) {
                    break;

                }
                if (succ[first - 1] == null) {
                    succ[first - 1] = new LinkedList();
                    succ[first - 1].add(second);
                } else {//Otherwise, just add the successor to the successors list.
                    succ[first - 1].add(second);
                }
                counter[second - 1]++;

            }
            for (int i = 0; i < n; i++) {
                System.out.println(succ.toString());

            }








        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException io) {
            System.out.println("IO Error.");
            System.exit(9);
        }

    }


}
