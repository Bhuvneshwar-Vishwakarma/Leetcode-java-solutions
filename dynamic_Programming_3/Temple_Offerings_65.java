package dynamic_Programming_3;
import java.util.*;

public class Temple_Offerings_65 {
	
	public static int totaloffering(int[] height) {
		int[] larr = new int[height.length];
		larr[0] = 1;
		for(int i = 1; i < larr.length; i++) {
			if(height[i] > height[i - 1]) {
				larr[i] = larr[i - 1] + 1;
			}else {
				larr[i] = 1;
			}
		}
		int[] rarr = new int[height.length];
		rarr[rarr.length - 1] = 1;
		for(int i = rarr.length - 2; i >= 0; i--) {
			if(height[i] > height[i + 1]) {
				rarr[i] = rarr[i + 1] + 1;
			}else {
				rarr[i] = 1;
			}
		}
		int ans = 0;
		for(int i = 0; i < height.length; i++) {
			ans += Math.max(larr[i], rarr[i]);
		}
		
		return ans;
	}

	public static void main(String[] args) {
		try (Scanner scn = new Scanner(System.in)) {
			int n = scn.nextInt();
			int height[] = new int[n];
			for (int i = 0; i < n; i++) {
				height[i] = scn.nextInt();
			}
			System.out.println(totaloffering(height));
		}
	}

}