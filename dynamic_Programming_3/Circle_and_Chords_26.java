package dynamic_Programming_3;

import java.util.Scanner;

public class Circle_and_Chords_26 {
	
	public static long NumberOfChords(int n) {
		long[] dp = new long[n + 1];
		
		dp[0] = 1;
		dp[1] = 1;
		
		for(int i = 2; i < dp.length; i++) {
			int right = i - 1;
			int left = 0;
			
			while(left <= i - 1) {
				dp[i] += dp[left] * dp[right];
				left++;
				right--;
			}
		}
		
		return dp[n];
	}
	
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			System.out.println(NumberOfChords(n));
		}
	}
}
