package recursion_and_Backtracking_1;
import java.util.*;

public class MaxScore_3 {

	public static int solution(String[] words, int[] farr, int[] score, int idx) {
		if(idx == words.length) {
			return 0;
		}
		int sno = 0 + solution(words, farr, score, idx + 1);//word not to include
		
		// word to include
		int sword = 0;
		String word = words[idx];
		boolean flage = true; // true if yes call can be made
		for(int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			
			if(farr[ch - 'a'] == 0) {
				flage = false;
			}
			
			farr[ch - 'a']--;
			sword += score[ch - 'a'];
		}
		int syes = 0;
		if(flage) {
			syes = sword + solution(words, farr, score, idx + 1);
		}
		for(int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			farr[ch - 'a']++;
		}
			
		return Math.max(sno, syes);
			
		
			
		
	}

	public static void main(String[] args) {

		try (Scanner scn = new Scanner(System.in)) {
			int nofWords = scn.nextInt();
			String[] words = new String[nofWords];
			for(int i = 0 ; i < words.length; i++) {
				words[i] = scn.next();
			}
			int nofLetters = scn.nextInt();
			char[] letters = new char[nofLetters];
			for (int i = 0; i < letters.length; i++) {
				letters[i] = scn.next().charAt(0);
			}
			int[] score = new int[26];
			for (int i = 0; i < score.length; i++) {
				score[i] = scn.nextInt();
			}
			if (words == null || words.length == 0 || letters == null || letters.length == 0 || score == null
					|| score.length == 0) {
				System.out.println(0);
				return;
			}
			int[] farr = new int[score.length];
			for (char ch : letters) {
				farr[ch - 'a']++;
			}
			System.out.println(solution(words, farr, score, 0));
		}

	}
}