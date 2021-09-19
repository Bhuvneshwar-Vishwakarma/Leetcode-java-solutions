package dynamic_Programming_3;
import java.util.*;

public class Arithmetic_Slices_one_57 {

	public static int solution(int[] arr) {
		int[] dp = new int[arr.length + 1];
		int ans = 0;
		for (int i = 2; i < arr.length; i++) {
			if(arr[i] - arr[i - 1] == arr[i - 1] - arr[i - 2]) {
				dp[i] = dp[i - 1] + 1;
				ans += dp[i];
			}
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for(int i = 0 ; i < n; i++){
				arr[i] = sc.nextInt();
			}
			System.out.println(solution(arr));
		}
	}

}