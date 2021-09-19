package dynamic_Programming_3;

import java.util.Scanner;

public class Longest_Common_Substring_35 {
	
	public  static int solution(String s1, String s2) {
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		
		int max = Integer.MIN_VALUE;
		for(int i = 1; i < dp.length; i++) {
			for(int j = 1; j < dp[0].length; j++) {
				
				char ch1 = s1.charAt(i - 1);
				char ch2 = s2.charAt(j - 1);
				
				if(ch1 == ch2) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}else {
					dp[i][j] = 0;
				}
				
				if(dp[i][j] > max) {
					max = dp[i][j];
				}
			}
		}	
		return max;
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			String str1 = sc.next();
			String str2 = sc.next();
			
			System.out.println(solution(str1, str2));
		}

	}

}
