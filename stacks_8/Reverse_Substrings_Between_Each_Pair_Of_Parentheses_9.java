package stacks_8;
import java.io.*;
import java.util.*;

public class Reverse_Substrings_Between_Each_Pair_Of_Parentheses_9 {
    public static String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i< s.length(); i++) {
        	char ch = s.charAt(i);
        	
        	if(ch == ')') {
        		Queue<Character> q = new LinkedList<>();
        		while(st.peek() != '(') {
        			q.add(st.pop());
        		}
        		st.pop();
        		while(q.size() != 0) {
        			st.push(q.remove());
        		}
        	}else {
        		st.push(ch);
        	}
        }
        char[] ans = new char[st.size()];
        int i = ans.length - 1;
        while(i >= 0) {
        	ans[i] = st.pop();
        	i--;
        }
        return new String(ans);
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String result = reverseParentheses(read.readLine());
        System.out.println(result);
        
    }
}
