package dynamic_Programming_3;

import java.util.Scanner;

public class Maximum_Difference_Of_Zeros_And_Ones_In_BinaryString_47 {
	
	public static int solution(String str) {
		int ans = 0;
		int csum = 0;
		for(int i = 0; i < str.length(); i++) {
			csum += str.charAt(i) == '0' ? 1 : -1;
			if(csum < 0) {
				csum = 0;
			}
			ans = Math.max(ans, csum);
		}
		
		return ans == 0 ? -1 : ans;
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			String str = sc.next();
			System.out.println(solution(str));
		}

	}

}
