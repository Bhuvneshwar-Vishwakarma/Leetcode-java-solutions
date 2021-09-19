package searching_and_Sorting_10;

import java.util.*;
import java.io.*;

public class Capacity_To_Ship_Packages_Within_D_Days_22 {

  public static int shipWithinDays(int[]arr, int days) {
	  int max = 0;
	  int sum = 0;
	  for (int i : arr) {
		sum += i;
		max = Math.max(max, i);
	  }
	  if(arr.length == days) {
		  return max;
	  }
	  int ans = 0;
	  int lo = max;
	  int hi = sum;
	  
	  while(lo <= hi) {
		  int mid = lo + (hi - lo) / 2;
		  if(isPossible(arr, mid, days)) {
			  ans = mid;
			  hi = mid - 1;
		  }else {
			  lo = mid + 1;
		  }
	  }
	  
	  return ans;
  }
  public static boolean isPossible(int[] arr, int mid, int days) {
	  int d = 0;
	  int sum = 0;
	  for(int val: arr) {
		  sum += val;
		  if(sum > mid) {
			  d++;
			  sum = val;
		  }
	  }
	  
	  return d <= days;
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int[]arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    int days = scn.nextInt();

    int ans = shipWithinDays(arr, days);
    System.out.println(ans);
  }
}