package dynamic_Programming_3;

import java.util.Scanner;

public class Minimum_Cost_To_Make_Two_Strings_Identical_38 {
	
	public static int solution(String s1, String s2, int c1, int c2) {
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		for(int i = dp.length - 2; i>=0; i--) {
			for(int j = dp[0].length - 2; j>=0; j--) {
				if(s1.charAt(i) == s2.charAt(j)) {
					dp[i][j] = dp[i + 1][j + 1] + 1;
				}else {
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
				}
			}
		}
		int lcs = dp[0][0];
		int s1r = s1.length() - lcs;
		int s2r = s2.length() - lcs;
		int cost = s1r * c1 + s2r * c2;
		return cost;
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		System.out.println(solution(s1, s2, n1, n2));
		sc.close();

	}

}
