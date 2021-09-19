package dynamic_Programming_3;
import java.util.*;

public class Min_Squares_of_two_6 {

	public static int solution(int n){
		//write your code here
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		for(int i = 2; i <= n; i++) {
			int min = Integer.MAX_VALUE;
			for(int j = 1; j * j <= i; j++) {
				int rem = i - j * j;
				if(dp[rem] < min) {
					min = dp[rem];
				}
			}
			dp[i] = min + 1;
		}

		return dp[n];
	}

	public static void main(String[] args) {
		try (Scanner scn = new Scanner(System.in)) {
			int n = scn.nextInt();
			System.out.println(solution(n));
		}
	}


	
}