package hashMap_and_Heap_5;
import java.util.*;

public class Recurring_Sequence_In_A_Fraction_36 {

    public static String solution(int num, int den) {
        // write your code here
    	StringBuilder ans = new StringBuilder();
    	
    	int q = num / den;
    	int r = num % den;
    	ans.append(q);
    	
    	if(r == 0) {
    		return ans.toString();
    	}else {
    		ans.append(".");
    		HashMap<Integer, Integer> map = new HashMap<>();
    		
    		while(r != 0) {
    			if(map.containsKey(r)) {
    				int len = map.get(r);
    				ans.insert(len, "(");
    				ans.append(")");
    				break;
    			}else {
    				map.put(r, ans.length());
    				r *= 10;
    				q = r / den;
    				r = r % den;
    				
    				ans.append(q);
    				
    			}
    		}
    	}
    	
        
        return ans.toString();
    }
    
    public static void main(String[] args) {
		try (Scanner scn = new Scanner(System.in)) {
			int num = scn.nextInt();
			int den = scn.nextInt();
			System.out.println(solution(num , den));
		}
	}

}
