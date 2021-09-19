package dynamic_Programming_3;
import java.util.*;
/*. You are given two strings s1 and s2.
2. You have to find the minimum number of operations needed to convert s1 to s2.
   Operations allowed are - 
   Insert - You can insert any character in s1.
   Remove - You can remove any character in s1.
   Replace - You can replace any character in s1 with any other character.*/

public class Edit_Distance_42 {
	
	public static int solution(String s, String t, int[][] arr) {//
		if(s.length() == 0) {
			return t.length();
		}
		if(t.length() == 0) {
			return s.length();
		}
		if(arr[s.length()][t.length()] > 0) {
			return arr[s.length()][t.length()];
		}
		
		if(s.charAt(0) == t.charAt(0)) {
			int f1 = solution(s.substring(1), t.substring(1), arr);
			arr[s.length()][t.length()] = f1;
			return f1;
		}else {
			int op1 = solution(s.substring(1), t.substring(1), arr);
			int op2 = solution(s, t.substring(1), arr);
			int op3 = solution(s.substring(1), t, arr);
			
			arr[s.length()][t.length()] = 1 + Math.min(op1, Math.min(op2, op3));
			return 1 + Math.min(op1, Math.min(op2, op3));
		}
		
	}
	
	public static void main(String[] args) {
		try (Scanner scn = new Scanner(System.in)) {
			String s1 = scn.next();
			String s2 = scn.next();
			int[][] arr = new int[s1.length()][s2.length()];
			System.out.println(solution(s1,s2, arr));
		}
	}

}