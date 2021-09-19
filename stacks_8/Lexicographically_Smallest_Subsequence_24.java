package stacks_8;
import java.io.*;
import java.util.*;

public class Lexicographically_Smallest_Subsequence_24 {
  public static int[] smallest(int[] nums, int k) {
	  int n = nums.length;
	  Stack<Integer> st = new Stack<>();
	  for(int i =0; i < nums.length; i++) {
		  while(st.size() > 0 && nums[i] < st.peek() && n-i-1 >= k - st.size()) {
			  st.pop();
		  }
		  if(st.size() < k) {
			  st.push(nums[i]);
		  }
	  }
	  int i = k - 1;
	  int[] ans = new int[k];
	  while(i >= 0)ans[i--] = st.pop();
    return ans;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(read.readLine());
    int arr[] = new int[n];
    for (int i = 0; i < n; i++)arr[i] = Integer.parseInt(read.readLine());
    int k = Integer.parseInt(read.readLine());
    int ans[] = smallest(arr, k);
    System.out.println(ans.length);

    for (int e : ans) {
      System.out.println(e);
    }

  }
}
