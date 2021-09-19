 package hashMap_and_Heap_5;
import java.util.*;

public class FindAllAnagramsInAString_21 {
	

	private static boolean compare(HashMap<Character, Integer> pmap, HashMap<Character, Integer> smap) {
		for(char ch : smap.keySet()) {
			if(smap.get(ch) != pmap.getOrDefault(ch, 0)) {
				return false;
			}
		}
		return true;
	}
	public static void findAnagrams(String src, String ptr) {
        HashMap<Character, Integer> smap = new HashMap<>();
        HashMap<Character, Integer> pmap = new HashMap<>();
        for(int i = 0; i<ptr.length(); i++) {
        	char ch = ptr.charAt(i);
        	pmap.put(ch, pmap.getOrDefault(ch, 0) + 1);
        }
        for(int i = 0; i<ptr.length(); i++) {
        	char ch = src.charAt(i);
        	smap.put(ch, smap.getOrDefault(ch, 0) + 1);
        }
        String ans = "";
        int count = 0;
        int i = ptr.length();
        
        while(i < src.length()) {
        	if(compare(pmap, smap) == true) { // anagram hai to ++
        		count++;
        		ans += (i - ptr.length()) + " ";
        	}
        	
        	char cha = src.charAt(i);// character for acquire
        	smap.put(cha, smap.getOrDefault(cha, 0) + 1);
        	
        	char chr = src.charAt(i - ptr.length()); // character for remove
        	if(smap.get(chr) == 1) {
        		smap.remove(chr);
        	}else {
        		smap.put(chr, smap.get(chr) - 1);
        	}
        	i++;
        }
        if(compare(pmap, smap) == true) {
    		count++;
    		ans += (i - ptr.length()) + " ";
    	}
    	System.out.print(count +"\n"+ ans);

    	
	}

	public static void main(String[] args) {
		try (Scanner scn = new Scanner(System.in)) {
			String src = scn.next();
			String ptr = scn.next();
			findAnagrams(src, ptr);
		}
	}

}
