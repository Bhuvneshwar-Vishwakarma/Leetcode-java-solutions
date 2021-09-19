package dynamic_Programming_3;

import java.util.*;

public class Regural_Expression_Matching_21 {
	
	public static boolean solution(String s, String p) {
		boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
		
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				
				if(i == 0 && j == 0) {
					dp[i][j] = true;
					
				}else if(i == 0) {
					dp[i][j] = false;
					
				}else if(j == 0) {
					char pc = p.charAt(i - 1);
					if(pc == '*') {
						dp[i][j] = dp[i - 2][j];
					}else {
						dp[i][j] = false;
					}
				}else {
					char pc = p.charAt(i - 1);// pattern char
					char sc = s.charAt(j - 1);// str char
								
					if(pc == '*') {
						dp[i][j] = dp[i - 2][j]; // above 2 row
						
						char pslc = p.charAt(i - 2);
						if(pslc == '.' || pslc == sc) {
							dp[i][j] = dp[i][j] || dp[i][j - 1];
						}
					}else if(pc == '.') {
						dp[i][j] = dp[i - 1][j - 1];
					}else if(pc == sc){
						dp[i][j] = dp[i - 1][j - 1];
					}else {
						dp[i][j] = false;
					}
				}
			}
		}
		return dp[p.length()][s.length()];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String pattern = sc.next();
		
		System.out.println(solution(str, pattern));
		sc.close();

	}

}
