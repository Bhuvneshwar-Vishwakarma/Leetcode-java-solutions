package searching_and_Sorting_10;

import java.util.*;
import java.io.*;

public class Split_Array_Largest_Sum_21 {

  public static int splitArray(int[]arr, int m) {
    int max = 0;
    int sum = 0;
    for(int val: arr) {
    	max = Math.max(max, val);
    	sum += val;
    }
    if(arr.length == m) {
    	return max;
    }
    int ans = 0;
    int lo = max;
    int hi = sum;
    
    while(lo <= hi) {
    	int mid = lo + (hi - lo) / 2;
    	if(isPossible(arr, mid, m)) {
    		ans = mid;
    		hi = mid - 1;
    	}else {
    		lo = mid + 1;
    	}
    }
    return ans;
  }

  public static boolean isPossible(int[] arr, int mid, int m) {
	  int sa = 1; // subArray
	  int sum = 0;
	  for(int val: arr) {
		  sum += val;
		  if(sum > mid) {
			  sa++;
			  sum = val;
		  }
	  }
	  return sa <= m;
  }
  
  
  
  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int[]arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    int m = scn.nextInt();

    int ans = splitArray(arr, m);
    System.out.println(ans);
  }
}