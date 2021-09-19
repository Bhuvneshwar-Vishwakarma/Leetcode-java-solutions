package dynamic_Programming_3;

import java.util.Scanner;

public class Wild_Card_Pattern_Matching_20 {
	
	public static boolean solution(String str, String pattern) {
		boolean[][] dp = new boolean[pattern.length() + 1][str.length() + 1];
		
		for(int i = dp.length - 1; i>=0; i--) {
			for(int j = dp[0].length - 1; j>=0; j--) {
				
				if(i == dp.length - 1 && j == dp[0].length - 1) {
					dp[i][j] = true;
				}else if(i == dp.length - 1) {
					dp[i][j] = false;
				}else if(j == dp[0].length - 1) {
					if(pattern.charAt(i) == '*') {
						dp[i][j] = dp[i + 1][j];
					}else {
						dp[i][j] = false;
					}
				}else {
					char ch = pattern.charAt(i);
					if(ch == '?') {
						dp[i][j] = dp[i + 1][j + 1];
					}else if(ch == '*') {
						dp[i][j] = dp[i][j + 1] || dp[i + 1][j];
					}else if(ch == str.charAt(j)) {
						dp[i][j] = dp[i + 1][j + 1];
					}else {
						dp[i][j] = false;
					}
				}
			}
		}
		
		
		return dp[0][0];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		System.out.println(solution(s1, s2));
		
		sc.close();

	}

}
