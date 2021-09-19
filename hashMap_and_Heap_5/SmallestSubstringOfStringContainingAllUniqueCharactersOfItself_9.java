 package hashMap_and_Heap_5;
import java.util.*;

public class SmallestSubstringOfStringContainingAllUniqueCharactersOfItself_9 {

	public static int solution(String str){
		int len = str.length();
		
		HashSet<Character> set = new HashSet<>();
		for (int i = 0; i < str.length(); i++) {
			set.add(str.charAt(i)); // all unique character
		}
		HashMap<Character, Integer> map = new HashMap<>();
		int i = -1;
		int j = -1;
		
		while(true) {
			boolean f1 = false;
			boolean f2 = false;
			
			//acquire
			while(i < str.length() - 1 && map.size() < set.size()) {
				i++;
				char ch = str.charAt(i);
				map.put(ch, map.getOrDefault(ch, 0) + 1);
				f1 = true;

			}
			
			// Collect ans and release
			while(j < i && map.size() == set.size()) {
				int plen = i - j; // potential length
				if(plen < len) {
					len = plen;
				}
				
				j++;
				char ch = str.charAt(j);
				if(map.get(ch) == 1) {
					map.remove(ch);
				}else {
					map.put(ch, map.get(ch) - 1);
				}
				f2 = true;
			}
			
			if(f1 == false && f2 == false) {
				break;
			}
		}
		
		return len;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

}
