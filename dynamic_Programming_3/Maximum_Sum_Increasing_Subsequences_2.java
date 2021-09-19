package dynamic_Programming_3;

import java.util.Scanner;

public class Maximum_Sum_Increasing_Subsequences_2 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for(int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			int[] dp = new int[n];
			int omax = 0;
			
			for(int i = 0; i < dp.length; i++) {
				Integer max = null;
				
				for(int j = 0; j < i; j++) {
					if(arr[j] <= arr[i]) {
						
						if(max == null) {
							max = dp[j];
						} else if(dp[j] > max) {
							max = dp[j];
						}
					}
				}
				if(max == null) {
					dp[i] = arr[i];
				}else {
					dp[i] = max + arr[i];
				}
				
				if(dp[i] > omax) {
					omax = dp[i];
				}
			}
			System.out.println(omax);
		}

	}

}
