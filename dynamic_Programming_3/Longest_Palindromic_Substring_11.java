package dynamic_Programming_3;

import java.util.Scanner;

public class Longest_Palindromic_Substring_11 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
	
			String str = sc.next();
			boolean[][] dp = new boolean[str.length()][str.length()];
			int len = 0;
			for(int g = 0; g < str.length(); g++) {
				for(int i = 0, j = g; j < str.length(); i++, j++) {
					if(g == 0) {
						dp[i][j] = true;
					}else if(g == 1) {
						dp[i][j] = str.charAt(i) == str.charAt(j) ? true: false;
					}else {
						if(str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1] == true) {
							dp[i][j] = true;
						}else {
							dp[i][j] = false;
						}
					}
					
					if(dp[i][j] == true) {
						len = g + 1;
					}
				}
			}
			System.out.println(len);
		}

	}

}
