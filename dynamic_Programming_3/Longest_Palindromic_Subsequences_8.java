package dynamic_Programming_3;

import java.util.Scanner;

public class Longest_Palindromic_Subsequences_8 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			String str = sc.next();
			
			int[][] dp = new int[str.length()][str.length()];
			for(int g = 0; g < str.length(); g++) {
				for(int i = 0, j = g; j < dp.length; i++, j++) {
					
					if(g == 0) {
						dp[i][j] = 1;
					}else if(g == 1) {
						dp[i][j] = str.charAt(i) == str.charAt(j) ? 2: 1;
					}else {
						if(str.charAt(i) == str.charAt(j)) {
							dp[i][j] = 2 + dp[i + 1][j - 1];
						}else {
							dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
						}
					}
				}
			}
			System.out.println(dp[0][str.length() - 1]);
		}
		

	}

}
