package searching_and_Sorting_10;

import java.util.*;
import java.io.*;

public class Allocate_Minimum_Number_Of_Pages_20 {

  public static int minPages(int[]arr, int m) {
	  int ans = 0;
	  int sum = 0;
	  int max = 0;
	  for(int val: arr) {
		  sum += val;
		  max = Math.max(val, max);
	  }
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
	  int st = 1;
	  int sum = 0;
	  for(int val: arr) {
		  sum += val;
		  if(sum > mid) {
			  st++;
			  sum = val;
		  }
	  }
	  
	  
	  return st <= m;
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

    int ans = minPages(arr, m);
    System.out.println(ans);
  }
}