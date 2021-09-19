package dynamic_Programming_3;

import java.util.Scanner;

public class Rod_Cutting_29 {
	
	public static int solution(int[] arr) {
		int[] np = new int[arr.length + 1];
		for (int i = 0; i < arr.length; i++) {
			np[i + 1] = arr[i];
		}
		int[] dp = new int[np.length];
		dp[0] = 0;
		dp[1] = np[1];
		
		for (int i = 2; i < dp.length; i++) {
			dp[i] = np[i];
			
			int li = 1;
			int ri = i - 1;
			while (li <= ri) {
				if(dp[li] + dp[ri] > dp[i]) {
					dp[i] = dp[li] + dp[ri];
				}
				li++;
				ri--;
			}
		}
		
		return dp[dp.length - 1];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(solution(arr));
		sc.close();
	}

}
