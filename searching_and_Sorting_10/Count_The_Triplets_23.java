package searching_and_Sorting_10;

import java.util.*;
import java.io.*;

public class Count_The_Triplets_23 {

  public static int countTriplets(int[]arr) {
    int count = 0;
    Arrays.sort(arr);
    
    for(int i = arr.length - 1; i >= 0; i--) {
    	int l = 0;
    	int r = i - 1;
    	
    	while(l < r) {
    		if(arr[l] + arr[r] == arr[i]) {
    			count++;
    			l++;
    			r--;
    		}else if(arr[l] + arr[r] < arr[i]) {
    			l++;
    		}else {
    			r--;
    		}
    	}
    }
    
    return count;
	  
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int[]arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    System.out.println(countTriplets(arr));
  }
}