package dynamic_Programming_3;
import java.util.*;

public class Number_Of_Ways_Of_Triangulation_27 {

	public static int solution(int n){
		
		n = n - 2;// important
		
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		
		for(int i = 2; i<dp.length; i++) {
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
		try (Scanner scn = new Scanner(System.in)) {
			int n = scn.nextInt();
			System.out.println(solution(n));
		}
	}

}