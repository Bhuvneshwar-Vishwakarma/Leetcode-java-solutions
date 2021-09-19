 package stacks_8;
import java.io.*;
import java.util.*;

public class Next_Greater_Element_ii_3 {// Circular array
    public static int[] nextGreaterElementII(int[] nums) {
    	int n = nums.length;
    	Stack<Integer> st = new Stack<>();
    	for(int i = n - 2; i >= 0; i--) {
    		while(st.size() != 0 && nums[i] >= st.peek()) {
    			st.pop();
    		}
    		st.push(nums[i]);
    	}
    	int[] ans = new int[nums.length];
    	
    	for(int i = n - 1; i >= 0; i--) {
    		while(st.size() != 0 && nums[i] >= st.peek()) {
    			st.pop();
    		}
    		ans[i] = st.size() == 0 ? -1: st.peek();
    		
    		st.push(nums[i]);
    	}
        return ans;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(read.readLine());
        int nums[] = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = Integer.parseInt(read.readLine());
        }
        
        int ans[] = nextGreaterElementII(nums);

        n = ans.length;

        System.out.println(n);
        for(int e: ans){
            System.out.println(e);
        }
        
    }
}