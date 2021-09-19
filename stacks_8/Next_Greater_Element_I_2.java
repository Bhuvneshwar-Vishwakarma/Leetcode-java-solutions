package stacks_8;
import java.io.*;
import java.util.*;

public class Next_Greater_Element_I_2 {
    public static int[] nextGreaterElement(int[] nums) {
        Stack<Integer> st = new Stack<>();
        st.push(nums[nums.length - 1]);
        int[] nge = new int[nums.length];
        nge[nums.length - 1] = -1;
        
        for(int i = nums.length - 2; i >= 0; i--) {
        	while(st.size() > 0 && nums[i] > st.peek()) {
        		st.pop();
        	}
        	if(st.size() == 0) {
        		nge[i] = -1;
        	}else {
        		nge[i] = st.peek();
        	}
        	st.push(nums[i]);
        }
        
        return nge;
    }
    public static int[] nextGreaterElement(int[] nums, int[] query) {
    	int[] nge = nextGreaterElement(nums);
    	int[] ans = new int[query.length];
    	HashMap<Integer, Integer> map = new HashMap<>();
    	for(int i = 0; i < nums.length; i++) {
    		map.put(nums[i], nge[i]);
    	}
    	for(int i = 0; i < query.length; i++) {
    		ans[i] = map.get(query[i]);
    	}
    	return ans;
    }

    public static int[] getArr(String s){
        String nums[] = s.split(" ");
        int n = nums.length;
        int ar[] = new int[n];
        for(int i=0;i<n;i++){
            ar[i] = Integer.parseInt(nums[i]);
        }
        return ar;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int query[] = getArr(read.readLine());
        int nums[] = getArr(read.readLine());
        
        int ans[] = nextGreaterElement(nums, query);

        int n = ans.length;

        System.out.println(n);
        for(int e: ans){
            System.out.println(e);
        }
        
    }
}
