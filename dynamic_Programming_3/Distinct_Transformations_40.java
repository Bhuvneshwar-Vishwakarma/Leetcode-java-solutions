package dynamic_Programming_3;

import java.util.Scanner;

public class Distinct_Transformations_40 {
	
	public static int solution(String s, String t) {
		int[][] dp = new int[t.length() + 1][s.length() + 1];
		
		for(int i = dp.length - 1; i >= 0; i--) {
			for(int j = dp[0].length - 1; j>=0; j--) {
				
				if(i == dp.length - 1) {
					dp[i][j] = 1;
				}else if(j == dp[0].length - 1) {
					dp[i][j] = 0;
				}else {
					char c1 = t.charAt(i);
					char c2 = s.charAt(j);
					
					if(c1 != c2) {
						dp[i][j] = dp[i][j + 1];
					}else {
						dp[i][j] = dp[i][j + 1] + dp[i + 1][j + 1];
					}
				}
				
			}
		}
		
		return dp[0][0];
		
	}
	
//	public static int solution(String s, String t, int si, int ti, int[][] dp) {		
//		/***********Simple Memoization Solution************/
//		
//		if(ti == t.length()) {
//			return 1;
//		}else if(si == s.length()) {
//			return 0;
//		}
//		if(dp[si][ti] != -1) {
//			return dp[si][ti];
//		}
//		
//		char c1 = s.charAt(si);
//		char c2 = t.charAt(ti);
//		
//		int tw = 0;
//		if(c1 != c2) {
//			tw = solution(s, t, si + 1, ti, dp);
//		}else {
//			int tw1 = solution(s, t, si + 1, ti, dp);
//			int tw2 = solution(s, t, si + 1, ti + 1, dp);
//			tw = tw1 + tw2;
//		}
//		
//		dp[si][ti] = tw;
//		
//		return tw;
//	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String task = sc.next();
		int[][] dp = new int[str.length()][task.length()];
		for(int i = 0; i < dp.length; i++) {
			for(int j = 0; j < dp[0].length; j++) {
				dp[i][j] = -1;
			}
		}
		
		//System.out.println(solution(str, task, 0, 0, dp)); Memoization call
		System.out.println(solution(str, task));

	}

}
