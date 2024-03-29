package recursion_and_Backtracking_1;
import java.util.*;

public class Print_Valid_Paranthisis_18 {

	public static void solution(String str, int minRemoval, HashSet<String> ans) {
		
		if(minRemoval == 0) {
			int mr = getMin(str);
			if(mr == 0) {
				if(!ans.contains(str)) {
					System.out.println(str);
					ans.add(str);
				}
			}
			return;
		}
		
		for(int i = 0; i<str.length(); i++) {
			String left = str.substring(0, i);
			String right = str.substring(i + 1);
			
			solution(left + right, minRemoval - 1, ans);
			
		}
	}

	public static int getMin(String str){
		Stack<Character> st = new Stack<>();
		for(int i = 0; i<str.length(); i++) {
			char ch = str.charAt(i);
			if(ch == '(') {
				st.push(ch);
			}else if(ch == ')') {
				if(st.size() == 0) {
					st.push(ch);
				}else if(st.peek() == ')') {
					st.push(ch);
				}else if(st.peek() == '('){
					st.pop();
				}
			}
		}
		return st.size();
	}
	public static void main(String[] args) {
		try (Scanner scn = new Scanner(System.in)) {
			String str = scn.next();
			int mra = getMin(str);
			solution(str, mra ,new HashSet<>());
		}
	}
		
}