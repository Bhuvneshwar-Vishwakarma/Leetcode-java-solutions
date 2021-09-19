package searching_and_Sorting_10;
import java.util.*;
import java.io.*;

public class Distinct_Absolute_Array_Elements_29 {

  public static int count(int[]arr) {// array is already sorted
	  int count = 0;
	  int i = 0;
	  int j = arr.length - 1;
	  int prev = Integer.MIN_VALUE;// for left
	  int next = Integer.MAX_VALUE; // for right;
	  
	  while(i <= j) {
		  int left = Math.abs(arr[i]);
		  int right = Math.abs(arr[j]);
		  if(left == right) {
			  if(left != prev && right != next) {
				  count++;
			  }
			  prev = left;
			  next = right;
			  i++;
			  j--;
		  }else if(left < right) {
			  if(right != next) {
				  count++;
			  }
			  next = right;
			  j--;
		  }else if(left > right) {
			  if(left != prev) {
				  count++;
			  }
			  prev = left;
			  i++;
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

    System.out.println(count(arr));
  }
}