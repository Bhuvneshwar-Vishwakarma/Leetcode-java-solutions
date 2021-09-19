package recursion_and_Backtracking_1;
import java.util.*;

public class All_Palindromic_Partition_13 {
	
	public static boolean isPalindrome(String str) {
		int i = 0;
		int j = str.length() - 1;
		while(i < j) {
			char li = str.charAt(i);
			char ri = str.charAt(j);
			if(li != ri) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	public static void solution(String str, String asf) {
		
		if(str.length() == 0) {
			System.out.println(asf);
			return;
		}
		
		for(int i = 0; i<str.length(); i++) {
			String preFix = str.substring(0, i + 1);
			String ros = str.substring(i + 1);
			if(isPalindrome(preFix)) {
				solution(ros, asf + "(" + preFix + ") ");
			}
		}
		
	}
	public static void main(String[] args) {
		try (Scanner scn = new Scanner(System.in)) {
			String str = scn.nextLine();
			solution(str, "");
		}
	}

}