 package hashMap_and_Heap_5;
import java.util.*;

public class CountOfSubstringsWithExactlyKUniqueCharacters_13 {

	public static int solution(String str, int k){
		int count = 0;
		int ib = -1;
		int is= -1;
		int j = -1;
		HashMap<Character, Integer> mapb = new HashMap<>();
		HashMap<Character, Integer> maps = new HashMap<>();
		while(true) {
			boolean f1 = false;
			boolean f2 = false;
			boolean f3 = false;
			
			//acquire;
			while(ib < str.length() - 1) {
				f1 = true;
				ib++;
				char ch = str.charAt(ib);
				mapb.put(ch, mapb.getOrDefault(ch, 0) + 1);
				if(mapb.size() > k) {       // k 
					mapRemove(mapb, ch);
					ib--;
					break;
				}
			}
			
			while(is < ib) {
				f2 = true;
				is++;
				char ch = str.charAt(is);
				maps.put(ch, maps.getOrDefault(ch, 0) + 1);
				if(maps.size() == k) {  // k - 1
					mapRemove(maps, ch);
					is--;
					break;
				}
			}
			
			// Release
			while(j < is) {
				if(mapb.size() == k && maps.size() == k - 1) {
					count += ib - is;
				}
				j++;
				char ch = str.charAt(j);
				mapRemove(maps, ch);
				mapRemove(mapb, ch);
				
				if(maps.size() < k - 1  || mapb.size() < k) {
					break;
				}
			}
			
			if(f1 == false && f2 == false && f3 == false) {
				break;
			}
		}

		return count;
	}
	public static int solution_For_K1(String str, int k) {
		int ans = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		int i = -1;
		int j = -1;
		
		while(true) {
			boolean f1 = false;
			boolean f2 = false;
			
			while(i < str.length() - 1) {
				f1 = true;
				i++;
				char ch = str.charAt(i);
				map.put(ch, map.getOrDefault(ch, 0) + 1);
				
				if(map.size() == 2) {
					mapRemove(map, ch);
					i--;
					break;
				}
			}
			while(j < i) {
				f2 = true;
				if(map.size() == 1) {
					ans += i - j;
				}
				j++;
				char ch = str.charAt(j);
				mapRemove(map, ch);
				
				if(map.size() == 0) {
					break;
				}
			}
			
			if(f1 == false && f2 == false) {
				break;
			}
		}
		
		
		return ans;
	}
	public static void mapRemove(HashMap<Character, Integer> map,char ch) {
		if(map.get(ch) == 1) {
			map.remove(ch);
		}else {
			map.put(ch, map.get(ch) - 1);
		}
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
        if(k == 1) {
        	System.out.println(solution_For_K1(str,k));
        }else {
        	System.out.println(solution(str,k));
        }
        	
	}

}
