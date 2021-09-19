package searching_and_Sorting_10;
import java.util.*;
import java.io.*;

public class Median_Of_Two_Sorted_Arrays_16 {

    public static double find(int[]a1,int[]a2) {
        //write your code here
        return 0;
    }

    public static void main(String[]args) {
        Scanner scn = new Scanner(System.in);

        //input work
        int n1 = scn.nextInt();
        int[]a = new int[n1];

        for(int i=0;i < n1;i++){
            a[i] = scn.nextInt();
        }

        int n2 = scn.nextInt();
        int[]b = new int[n2];

        for(int i=0; i < n2;i++) {
            b[i] = scn.nextInt();
        }

        double median = find(a,b);
        System.out.println(median);
    }
}