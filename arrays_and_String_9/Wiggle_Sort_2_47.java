package arrays_and_String_9;
import java.util.*;

public class Wiggle_Sort_2_47 {

  // ~~~~~~~~~~~~~User's Section~~~~~~~~~~~~
  public static void wiggleSort2(int[] nums) {
	  // 1. Sort array
	  Arrays.sort(nums);
	  
	  // 2. make an extra array and manage equility in it
	  int n = nums.length;
	  int[] res = new int[n];
	  int i = 1;
	  int j = n - 1;
	  
	  while(i < n) {
		  res[i] = nums[j];
		  i += 2;
		  j--;
	  }
	  i = 0;
	  while(i < n) {
		  res[i] = nums[j];
		  i += 2;
		  j--;
	  }
	  //3 fill output array
	  for(i = 0; i< n; i++) {
		  nums[i] = res[i];
	  }
	  
	  
	  
  }

  // ~~~~~~~~~~~Input Management~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    wiggleSort2(arr);
    /*
    -if index is even then smaller than next,
    -if index is odd then greater than next element,
    -to check any correct order, we will not print array, we will check inequality
    -if print false, that means wrong answer, if true than correct answer.
    */
    for (int i = 0; i < n - 1; i++) {
      if (i % 2 == 0 && arr[i] >= arr[i + 1]) {
        System.out.println(false);
        return;
      } else if (i % 2 == 1 && arr[i] <= arr[i + 1]) {
        System.out.println(false);
        return;
      }
    }
    System.out.println(true);
  }
}