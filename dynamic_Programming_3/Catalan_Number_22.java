package dynamic_Programming_3;

import java.util.Scanner;

public class Catalan_Number_22 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			int[] dp = new int[n + 1];
			
			dp[0] = 1;
			dp[1] = 1;
				
			for (int i = 2; i < dp.length; i++) {
				for (int j = 0; j < i; j++) {
					dp[i] += dp[j] * dp[i - j - 1];
				}
				
				/*int l = 0;
			    int r = i - 1;
			    while(l <= i - 1) {
				    dp[i] += dp[l] * dp[r];
				    l++;
			    	r--;
			    }*/
			}
			System.out.println(dp[n]);
		}
		
		
		
	}

}

