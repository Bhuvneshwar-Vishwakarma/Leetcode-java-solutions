 package stacks_8;
import java.io.*;
import java.util.*;

public class Minimum_Remove_To_Make_Valid_Parentheses_10 {
    public static String reverseParentheses(String s) {
    	
    	char[] chars = s.toCharArray();
    	Stack<Integer> st = new Stack<>();
    	for (int i = 0; i < chars.length; i++) {
			if(chars[i] == '(') {
				st.push(i);
			}else if(chars[i] == ')') {
				if(st.size() == 0) {
					chars[i] = '.';
				}else {
					st.pop();
				}
			}
		}
    	while(st.size() > 0) {
    		chars[st.pop()] = '.';
    	}
    	StringBuilder sb = new StringBuilder();
    	for(char ch: chars) {
    		if(ch != '.') {
    			sb.append(ch);
    		}
    	}
    	
    	
        return sb.toString();
    }

    
    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String result = reverseParentheses(read.readLine());
        System.out.println(result);
        
    }
}
