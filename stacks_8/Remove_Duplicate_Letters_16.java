package stacks_8;

import java.io.*;
import java.util.*;

public class Remove_Duplicate_Letters_16 {
    public static String removeDuplicateLetters(String s) {
    	Stack<Character> st = new Stack<>();
    	int[] freq = new int[26];
    	boolean[] used = new boolean[26];
    	
    	// frequency
    	for(int i = 0; i < s.length(); i++) {
    		char ch = s.charAt(i);
    		freq[ch - 'a']++;
    	}
    	
    	for(int i = 0; i < s.length(); i++) {
    		char ch = s.charAt(i);
    		freq[ch - 'a']--;
    		if(used[ch - 'a']) continue;
    		
    		while(st.size() > 0 && st.peek() > ch && freq[st.peek() - 'a'] > 0) {
    			char rem = st.pop();
    			used[rem - 'a'] = false;
    		}
    		
    		st.push(ch);
    		used[ch - 'a'] = true;
    	}
    	char[] ans = new char[st.size()];
    	int i = ans.length - 1;
    	while(i >= 0) {
    		ans[i--] = st.pop();
    	}
    	
        return new String(ans);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String result = removeDuplicateLetters(read.readLine());
        System.out.println(result);
        
    }
}
