package stacks_8;
import java.io.*;

public class Trapping_Rain_Water_19 {
    public static int trap(int[] height) {
    	int n = height.length;
    	
    	int[] left = new int[n];
    	left[0] = height[0];
    	for(int i = 1; i < n; i++) {
    		left[i] = Math.max(left[i - 1], height[i]);
    	}
    	
    	int[] right = new int[n];
    	right[n - 1] = height[n - 1];
    	for(int i = n - 2; i >= 0; i--) {
    		right[i] = Math.max(right[i + 1], height[i]);
    	}
    	
    	int ans = 0;
    	for(int i = 0; i < n; i++) {
    		ans += Math.min(left[i], right[i]) - height[i];
    	}
        return ans;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(read.readLine());
        int arr[] = new int[n];
        for(int i=0;i<n;i++)arr[i] = Integer.parseInt(read.readLine());
        int result = trap(arr);
        System.out.println(result);
        
    }
}
