package hashMap_and_Heap_5;
import java.util.*;

public class LongestSubstringWithExactlyKUniqueCharacters_12 {

	public static int solution(String str, int k){
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
				
				if(map.size() < k) {
					continue;
				}else if(map.size() == k) {
					int len = i - j;
					if(len > ans) {
						ans = len;
					}
				}else {
					break;
				}
			}
			
			// release;
			while(j < i) {
				f2 = true;
				j++;
				char ch = str.charAt(j);
				if(map.get(ch) == 1) {
					map.remove(ch);
				}else {
					map.put(ch, map.get(ch) - 1);
				}
				
					
				if(map.size() > k) {
					continue;
				}else if(map.size() == k) {
					int len = i - j;
					if(len > ans) {
						ans = len;
					}
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
			int k = scn.nextInt();
			System.out.println(solution(str,k));
		}
	}

}
