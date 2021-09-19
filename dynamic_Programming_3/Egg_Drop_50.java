package dynamic_Programming_3;

import java.util.Scanner;

public class Egg_Drop_50 {
	
	public static int eggDrop(int n, int k) {
		int[][] dp= new int[n + 1][k + 1];
		for(int i = 1; i< dp.length; i++) {
			for(int j = 1; j < dp[0].length; j++) {
				if(i == 1) {
					dp[i][j] = j;
				}else if(j == 1){
					dp[i][j] = 1;
				}else {
					int min = Integer.MAX_VALUE;
					
					for(int mj = j - 1, pj = 0; mj >= 0; mj--, pj++) {
						int v1 = dp[i][mj];
						int v2 = dp[i - 1][pj];
						int val = Math.max(v1, v2);
						
						min = Math.min(min, val);
					}
					
					dp[i][j] = min + 1; 
				}
			}
		}
		return dp[n][k];
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			System.out.println(eggDrop(n, k));
		}

	}

}
