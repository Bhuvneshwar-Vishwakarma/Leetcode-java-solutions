package stacks_8;
import java.io.*;
import java.util.*;

public class Score_Of_Parentheses_8 {
    public static int scoreOfParentheses(String s) {
    	Stack<Integer> st = new Stack<>();
    	for(int i = 0; i < s.length(); i++) {
    		char ch = s.charAt(i);
    		if(ch == '(') {
    			st.push(-1);
    		}else if(ch == ')') {
    			if(st.peek() == -1) {
    				st.pop();
    				st.push(1);
    			}else {
    				int val = 0;
    				while(st.peek() != -1) {
    					val += st.pop();
    				}
    				st.pop();
    				st.push(2 * val);
    			}
    		}
    	}
    	int val = 0;
    	while(st.size() != 0) {
    		val += st.pop();
    	}
    	
        return val;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int score = scoreOfParentheses(read.readLine());
        System.out.println(score);
        
    }
}
