package searching_and_Sorting_10;

import java.util.*;
import java.io.*;

public class Counting_Elements_In_Two_Arrays_26 {

  public static int[] find(int[]arr1, int[]arr2) {
    int max1 = 0;
    for(int val: arr1) {
    	max1 = Math.max(val, max1);
    }
    int max2 = 0;
    for(int val: arr2) {
    	max2 = Math.max(val, max2);
    }
    int omax = Math.max(max1, max2);
    
    // pre-processing
    int[] farr = new int[100000];
    for(int i = 0; i < arr2.length; i++) {
    	farr[arr2[i]]++;
    }
    
    int[] psa = new int[100000];// prefix sum array
    psa[0] = farr[0];
    for(int i = 1; i <= omax; i++) {
    	psa[i] = psa[i - 1] + farr[i];
    }
    
    int[] ans = new int[arr1.length];
    
    for(int i = 0; i < arr1.length; i++) {
    	int key = arr1[i];
    	ans[i] = psa[key];
    }
    return ans;
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);

    int n1 = scn.nextInt();
    int[]a = new int[n1];

    for (int i = 0; i < n1; i++) {
      a[i] = scn.nextInt();
    }

    int n2 = scn.nextInt();
    int[]b = new int[n2];

    for (int i = 0; i < n2; i++) {
      b[i] = scn.nextInt();
    }

    int[]ans = find(a, b);

    for (int val : ans) {
      System.out.print(val + " ");
    }
  }
}