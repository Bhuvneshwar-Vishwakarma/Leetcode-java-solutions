 package dynamic_Programming_3;

import java.util.*;
//import java.util.Scanner;

public class Count_Distinct_Subsequences_12 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			String str = sc.next();
			
			long[] dp = new long[str.length() + 1];
			HashMap<Character, Integer> lo = new HashMap<>();
			dp[0] = 1;
			for(int i = 1; i < dp.length; i++) {
				dp[i] = 2 * dp[i - 1];
				char ch = str.charAt(i - 1);
				
				if(lo.containsKey(ch)) {
					int j = lo.get(ch);
					dp[i] = dp[i] - dp[j - 1];
				}
				lo.put(ch, i);
			}
			
			System.out.println(dp[str.length()] - 1);
		}
	}

}
