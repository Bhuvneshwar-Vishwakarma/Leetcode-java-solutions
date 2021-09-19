package arrays_and_String_9;
import java.util.Scanner;

public class Minimum_Size_Subarray_Sum_43 {

  public static int solution(int nums[], int target) {
    // write your code here
	  
	  return 0;
  }
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int nums[] = new int[n];
    for (int i = 0 ; i < n ; i++) {
      nums[i] = scn.nextInt();
    }
    int target = scn.nextInt();

    System.out.println(solution(nums, target));
  }
}
