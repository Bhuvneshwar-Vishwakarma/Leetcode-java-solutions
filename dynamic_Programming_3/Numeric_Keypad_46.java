package dynamic_Programming_3;
import java.util.*;

public class Numeric_Keypad_46 {
	
	public static int solution(int n) {
		int[][] dp = new int[n + 1][10];
		
		int[][] data = {
				{0, 8},
				{1, 2, 4},
				{1, 2, 3, 5},
				{2, 3, 6},
				{1, 4, 5, 7},
				{2, 4, 5, 6, 8},
				{3, 5, 6, 9},
				{4, 7, 8},
				{5, 7, 8, 9, 0},
				{6, 8, 9},	
		};
		
		for(int i = 1; i <= n; i++) {// presses, 
			for(int j = 0; j <= 9; j++) {//keys
				if(i == 1) {
					dp[i][j] = 1;
				}else {
					//ith press for jth key -> i - 1th press should of keys in data[j];
					for(int prev: data[j]) {
						dp[i][j] += dp[i - 1][prev];
					}
				}
			}
		}
		int sum = 0;
		for(int j = 0; j <= 9; j++) {
			sum += dp[n][j];
		}
		return sum;
		
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			System.out.println(solution(n));
		}

	}

}
