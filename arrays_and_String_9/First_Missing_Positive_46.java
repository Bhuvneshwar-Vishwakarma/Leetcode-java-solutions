package arrays_and_String_9;
import java.util.*;

public class First_Missing_Positive_46 {


  //~~~~~~~~~~~~~~~User's Section~~~~~~~~~~~~~~~~~
  public static int firstMissingPositive(int[] arr) {
    // step 1. mark element which are out of range and manage presence of one
	  boolean one = false;
	  int n = arr.length;
	  for(int i = 0; i < n; i++) {
		  if(arr[i] == 1) {
			  one = true;
		  }
		  
		  if(arr[i] < 1 || n < arr[i]) {
			  arr[i] = 1;
		  }
	  }
	  if(one == false) return 1;
	  
	  // step 2. Map elements with index
	  for(int i = 0; i < arr.length; i++) {
		  int idx = Math.abs(arr[i]);
		  arr[idx - 1] = -Math.abs(arr[idx - 1]);
	  }
	  
	  // step 3. find out missing integer
	  for(int i = 0; i < n; i++) {
		  if(arr[i] > 0) return i + 1;
	  }
	  
	  return n + 1;
  }

  //~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    int res = firstMissingPositive(arr);
    System.out.println(res);
  }
}