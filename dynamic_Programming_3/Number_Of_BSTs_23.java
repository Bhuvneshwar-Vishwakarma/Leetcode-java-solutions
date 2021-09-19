package dynamic_Programming_3;

import java.util.Scanner;

public class Number_Of_BSTs_23 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			int[] dp = new int[n + 1];
			
			dp[0] = 1;
			dp[1] = 1;
				
			for (int i = 2; i < dp.length; i++) {	
				
				int r = i - 1;
				int l = 0;
			    while(l <= i - 1) {
				    dp[i] += dp[l] * dp[r];
				    l++;
			    	r--;
			    }
			}
			System.out.println(dp[n]);
		}
		
		
	}

}

