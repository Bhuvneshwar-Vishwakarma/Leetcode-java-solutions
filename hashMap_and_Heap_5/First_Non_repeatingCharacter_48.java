package hashMap_and_Heap_5;
import java.util.*;

public class First_Non_repeatingCharacter_48 {
	
	public static int solution(String s) {
		// write your code here
		HashMap<Character, Integer> map = new HashMap<>();
		for(char ch: s.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if(map.get(ch) == 1) {
				return i;
			}
		}
   
		return -1;
	 }
	 
	public static void main(String[] args){
		try (Scanner scn = new Scanner(System.in)) {
			String s= scn.next();
			System.out.print(solution(s));
		}
	}

}
