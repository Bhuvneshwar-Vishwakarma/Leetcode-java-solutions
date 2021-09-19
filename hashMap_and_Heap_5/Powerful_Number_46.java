package hashMap_and_Heap_5;
import java.util.*;
/*1. You are given three numbers A, B, and X.
2. You have to print all-powerful numbers that have value less than or equal to X.
3. A number is powerful if it is equal to x^i + y^j for i >= 0 and j >= 0.*/
public class Powerful_Number_46 {
	
	/*Time Complexity -> O(logBound.logBound)
	 *Space Complexity -> O(".........") */
	
	public static ArrayList<Integer> powerfulIntegers(int x, int y, int bound) {
		// write your code here
		HashSet<Integer> set = new HashSet<>();
		for(int i = 1; i < bound; i *= x) {
			for(int j = 1; i + j <= bound; j *= y) {
				set.add(i + j);
				if(y == 1) break;
			}
			if(x == 1) break;
		}

		return new ArrayList<>(set);
	}
	
	public static void main(String[] args) {
		try (Scanner scn = new Scanner(System.in)) {
			int x = scn.nextInt();
			int y = scn.nextInt();
			int bound = scn.nextInt();
			ArrayList<Integer> ret = new ArrayList<>();
			ret = powerfulIntegers(x, y, bound);
			Collections.sort(ret);
			for (int i = 0; i < ret.size(); i++) {
				System.out.print(ret.get(i) + " ");
			}
		}
	}

}
