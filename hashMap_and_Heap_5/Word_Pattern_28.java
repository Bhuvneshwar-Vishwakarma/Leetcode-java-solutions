package hashMap_and_Heap_5;
import java.util.*;

public class Word_Pattern_28 {

	public static boolean wordPattern(String pattern, String str) {
		// write your code here
		String[] words = str.split(" ");
		
		HashMap<Character, String> map = new HashMap<>();
		HashMap<String, Boolean> used = new HashMap<>();
		
		for(int i = 0; i < pattern.length(); i++) {
			char ch = pattern.charAt(i);
			String word = words[i];
			
			if(map.containsKey(ch) == false) { // contain nahi karta hai
				if(used.containsKey(word) == true) {
					return false;
				}else {
					used.put(word, true);
					map.put(ch, word);
				}
			}else {            // contain karta hai
				String mapWith = map.get(ch);
				if(mapWith.equals(word) == false) {
					return false;
				}
			}
		}
		
		
		return true;
	}
	
	public static void main(String[] args) {
		try (Scanner scn = new Scanner(System.in)) {
			String pattern = scn.nextLine();
			String words = scn.nextLine();
			System.out.println(wordPattern(pattern,words));
		}
	}

}
