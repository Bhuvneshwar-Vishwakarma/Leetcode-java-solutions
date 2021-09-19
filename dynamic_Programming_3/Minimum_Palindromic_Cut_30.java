package dynamic_Programming_3;

import java.util.Scanner;

public class Minimum_Palindromic_Cut_30 {
	
	public static int minPalindromicCut(String s) {
		boolean[][] cdp = new boolean[s.length()][s.length()];
		
		for (int g = 0; g < s.length(); g++) {
			for(int i = 0, j = g; j <cdp.length; i++, j++) {
				if(g == 0) {
					cdp[i][j] = true;
				}else if(g == 1) {
					cdp[i][j] = s.charAt(i) == s.charAt(j);
				}else {
					if(s.charAt(i) == s.charAt(j) && cdp[i + 1][j - 1] == true) {
						cdp[i][j] = true;
					}else {
						cdp[i][j] = false;
					}
					
				}
			}
		}
		//O(n^2)
		int[] dp = new int[s.length()];
		dp[0] = 0;
		for(int j = 0; j < s.length(); j++) {
			if(cdp[0][j]) {
				dp[j] = 0;
			}else {
				int min = Integer.MAX_VALUE;
				for(int i = j; i >= 1; i--) {
					if(cdp[i][j]) {
						if(dp[i - 1] < min) {
							min = dp[i - 1];
						}
					}
				}
				dp[j] = min + 1;
			}
		}
		
		return dp[dp.length - 1];
		
		
		
		//*********** O(n^3)
		
//		int[][] dp = new int[s.length()][s.length()];
//		for(int g = 0; g < s.length(); g++) {
//			for(int i = 0, j = g; j < dp.length; i++, j++) {
//				if(g == 0) {
//					dp[i][j] = 0;
//				}else if(g == 1) {
//					if(s.charAt(i) == s.charAt(j)) {
//						dp[i][j] = 0;
//					}else {
//						dp[i][j] = 1;
//					}
//				}else {
//					if(cdp[i][j]) {
//						dp[i][j] = 0;
//					}else {
//						
//						int min = Integer.MAX_VALUE;
//						
//						for(int k = i; k < j; k++) {
//							int left = dp[i][k];
//							int right = dp[k + 1][j];
//							
//							if(left + right + 1 < min) {
//								min = left + right + 1;
//							}
//						}
//						dp[i][j] = min;
//					}
//				}
//			}
//		}
//		
//		return dp[0][s.length() - 1];
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			String str = sc.next();
			 
			System.out.println(minPalindromicCut(str));
		}
	}

}
