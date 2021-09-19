package searching_and_Sorting_10;
import java.util.*;
import java.io.*;

public class Find_The_Element_That_Appears_Once_In_Sorted_Array_33 {

  public static int findSingleElement(int[]arr) {
	  int n = arr.length;
	  if(arr.length % 2 == 0) {
		  return -1;
	  }
	  if(arr[0] != arr[1]) {
		  return arr[0];
	  }
	  if(arr[n - 1] != arr[n - 2]) {
		  return arr[n - 1];
	  }
	  
	  
	  int lo = 0;
	  int hi = arr.length - 1;
	  
	  while(lo <= hi) {
		  int mid = lo + (hi - lo) / 2;
		  
		  if(arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1]) {
			  return arr[mid];
		  }else if(arr[mid] == arr[mid - 1]){
			  // lo to mid elements count
			  int lc = mid - lo + 1;// left count
			  if(lc % 2 == 0) {
				  lo = mid + 1;
			  }else {
				  hi = mid - 2;
			  }
		  }else if(arr[mid] == arr[mid + 1]) {
			  // mid to hi elements count
			  int rc = hi - mid + 1;// right count

			  if(rc % 2 == 0) {
				  hi = mid - 1;
			  }else {
				  lo = mid + 1;
			  }
		  }
	  }
    //write your code here
    return -1;
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[]arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    int ans = findSingleElement(arr);
    System.out.println(ans);
  }
}