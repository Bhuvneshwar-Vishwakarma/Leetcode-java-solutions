 package hashMap_and_Heap_5;
import java.util.*;

public class CountOfSubstringsHavingAllUniqueCharacters_11 {

	public static int solution(String str) {
		int ans = 0;
		int i = -1;
		int j = -1;
		HashMap<Character, Integer> map = new HashMap<>();
		
		while(true) {
			boolean f1 = false;
			boolean f2 = false;
			
			//acquire
			while(i < str.length() - 1) {
				f1 = true;
				i++;
				char ch = str.charAt(i);
				map.put(ch, map.getOrDefault(ch, 0) + 1);
				
				if(map.get(ch) == 2) {
					break;
				}else {
					ans += i - j;
				}
			}
			
			//release
			while(j < i) {
			    f2 = true;
				j++;
				char ch = str.charAt(j);
				map.put(ch, map.get(ch) - 1);
				
				if(map.get(ch) == 1) {
					ans += i - j;
					break;
				}
			}
			
			if(f1 == false && f2 == false) {
				break;
			}
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		try (Scanner scn = new Scanner(System.in)) {
			String str = scn.next();
			System.out.println(solution(str));
		}
	}

}
