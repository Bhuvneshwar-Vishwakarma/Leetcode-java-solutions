package dynamic_Programming_3;
import java.util.*;

public class Longest_Repeating_Subsequences_36 {

	public static int solution(String str){
		int[][] dp = new int[str.length() + 1][str.length() + 1];
		for(int i = dp.length - 2; i >= 0; i--) {
			for(int j = dp[0].length - 2; j >= 0; j--) {
				
				if(str.charAt(i) == str.charAt(j) && i != j) {
					dp[i][j] = dp[i + 1][j + 1] + 1;
				}else {
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
				}
			}
		}

		return dp[0][0];
	}
	
	public static void main(String[] args) {
		try (Scanner scn = new Scanner(System.in)) {
			String str = scn.next();
			System.out.println(solution(str));
		}
	}

}