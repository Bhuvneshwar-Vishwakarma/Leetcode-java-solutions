package dynamic_Programming_3;

import java.util.Scanner;

public class Longest_Increasing_Subsequences_1 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for(int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			int[] dp = new int[n];
			int ovralMax = 0;
			
			for(int i = 0; i < dp.length; i++) {
				int max = 0;
				
				for(int j = 0; j < i; j++) {
					if(arr[j] < arr[i]) {
						if(dp[j] > max) {
							max = dp[j];
						}
			 		}
				}
				
				dp[i] = max + 1;
				
				if(dp[i] > ovralMax) { // over all max
					ovralMax = dp[i];
				}
			}
			System.out.println(ovralMax);
		}

	}

}
