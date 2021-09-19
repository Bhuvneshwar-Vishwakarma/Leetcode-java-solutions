package bit_Manipulation_2;
import java.util.*;

public class Number_Of_Valid_Words_7 {

	public static ArrayList<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
		//write your code here
		HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
		for(int i = 0; i<26; i++) {
			map.put((char)('a' + i), new ArrayList<>());
		}
		for(String word: words) {
			int mask = 0;
			for(char ch: word.toCharArray()) {
				int bit  = ch - 'a';
				mask = mask | (1 << bit);
			}
			
			HashSet<Character> unique = new HashSet<>();
			
			for(char ch: word.toCharArray()) {
				if (unique.contains(ch)) {
					continue;
				}
				unique.add(ch);
				map.get(ch).add(mask);
			}
		}
		ArrayList<Integer> res = new ArrayList<>();
		for(String puzzle: puzzles) {
			int pmask = 0;
			for(char ch: puzzle.toCharArray()) {
				int bit  = ch - 'a';
				pmask = pmask | (1 << bit);
			}
			char fch = puzzle.charAt(0);
			ArrayList<Integer> wordsToCheck = map.get(fch);
			int count = 0;
			
			for (int wmask : wordsToCheck) {
				if((wmask & pmask) == wmask) {
					count++;
				}
			}
			res.add(count);
		}
		return res;
	 }

	public static void main(String[] args) {
		try (Scanner scn = new Scanner(System.in)) {
			int n = scn.nextInt();
			String[] words = new String[n];
			for(int i = 0 ; i < words.length; i++) {
				words[i] = scn.next();
			}
			int m = scn.nextInt();
			String[] puzzles = new String[m];
			for(int i = 0 ; i < m ;i++) {
				puzzles[i] = scn.next();
			}
			ArrayList<Integer> ans = findNumOfValidWords(words,puzzles);
			for(int i = 0; i < ans.size(); i++) {
				System.out.println(puzzles[i] + " -> " + ans.get(i));
			}
		}
	}
	
}