package dynamic_Programming_3;

import java.util.Scanner;

public class Count_Valleys_and_Mountains_24 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			int[] dp = new int[n + 1];
			
			dp[0] = 1;
			dp[1] = 1;
				
			for (int i = 2; i < dp.length; i++) {
			    int inside = i - 1;
			    int outside = 0;
			    while(inside >= 0) {
				    dp[i] += dp[outside] * dp[inside];
				    
				    inside--;
			    	outside++;
			    }
			}
			System.out.println(dp[n]);
		}
		
		
		
	}

}

