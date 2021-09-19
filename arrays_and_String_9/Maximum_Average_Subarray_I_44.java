package arrays_and_String_9;
import java.util.Scanner;

public class Maximum_Average_Subarray_I_44 {
  public static double solution(int nums[], int k) {
    // write your code here
	  int sum = 0;
	  for(int i = 0; i < k; i++) {
		  sum += nums[i];
	  }
	  
	  int max = sum;
	  for(int i = k; i<nums.length; i++) {
		  sum = sum + nums[i];
		  sum = sum - nums[i - k];
		  
		  max = Math.max(max, sum);
	  }
	  return max;
  }
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int nums[] = new int[n];
    for (int i = 0 ; i < n ; i++) {
      nums[i] = scn.nextInt();
    }
    int k = scn.nextInt();

    System.out.println(solution(nums, k));
  }
}