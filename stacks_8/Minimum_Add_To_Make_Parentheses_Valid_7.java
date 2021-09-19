 package stacks_8;
import java.io.*;
import java.util.*;

public class Minimum_Add_To_Make_Parentheses_Valid_7 {
    public static int minAddToMakeValid1(String S) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < S.length(); i++) {
        	char ch = S.charAt(i);
        	
        	if(ch == '(') {
        		st.push(ch);
        	}else {
        		if(st.size() != 0 && st.peek() == '(') {
        			st.pop();
        		}else {
        			st.push(ch);
        		}
        			
        	}
        }
        return st.size();
    }
    public static int minAddToMakeValid(String str) {
    	int open = 0, closing = 0, correction = 0;
    	for(int i = 0; i < str.length(); i++) {
    		char ch = str.charAt(i);
    		
    		if(ch == '(') {
    			open++;
    		}else {
    			if(open != 0 && ch == ')') {
    				open--;
    			}else {
    				correction++;
    			}
    		}
    	}
    	
    	
    	return open + correction;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int result = minAddToMakeValid(read.readLine());
        System.out.println(result);
    }
}