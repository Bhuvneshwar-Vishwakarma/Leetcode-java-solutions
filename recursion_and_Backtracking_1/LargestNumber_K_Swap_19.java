package recursion_and_Backtracking_1;
import java.util.*;

public class LargestNumber_K_Swap_19 {

	static String max;
	public static void findMaximum(String str, int k) {
		if(Integer.parseInt(str) > Integer.parseInt(max)) {
			max = str;
		}
		if(k == 0) {
			return;
		}
		
		for(int i = 0; i<str.length() - 1; i++) {
			for(int j = i + 1; j <str.length(); j++) {
				if(str.charAt(i) < str.charAt(j)) {
					String swapped = swap(str, i, j);
					findMaximum(swapped, k - 1);
				}
			}
		}
		
	}
	public static String swap(String str, int i, int j) {
		char ith = str.charAt(i);
		char jth = str.charAt(j);
		
		String left = str.substring(0, i);
		String middle = str.substring(i + 1, j);
		String right = str.substring(j + 1);
		
		String swapped = left + jth + middle + ith + right;
		return swapped;
		
	}
	public static void main(String[] args) {
		try (Scanner scn = new Scanner(System.in)) {
			String str = scn.next();
			int k = scn.nextInt();
			 max = str;
			findMaximum(str, k);
		}
		System.out.println(max);
	}

}