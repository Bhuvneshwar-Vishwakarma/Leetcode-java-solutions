package hashMap_and_Heap_5;
import java.util.*;

public class CountOfSubarraysWithEqualNumberOf0s1sAnd2s_34 {

    public static int solution(int[] arr) {
        // write your code here
    	int ans = 0;
    	int c0 = 0;
    	int c1 = 0;
    	int c2 = 0;
    	
    	String key = (c2 - c1) +"#"+ (c1 - c0);
    	HashMap<String, Integer> map = new HashMap<>();
    	map.put(key, 1);
    	
    	for(int val: arr) {
    		if(val == 0) {
    			c0++;
    		}else if(val == 1) {
    			c1++;
    		}else {
    			c2++;
    		}
    		
    		key = (c2 - c1) +"#"+ (c1 - c0);
    		if(map.containsKey(key)) {
    			ans += map.get(key);
    			map.put(key, map.get(key) + 1);
    		}else {
    			map.put(key, 1);
    		}
    	}

        return ans;
    }
    
    public static void main(String[] args) {
        try (Scanner scn = new Scanner(System.in)) {
			int n = scn.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
			    arr[i] = scn.nextInt();
			}
			System.out.println(solution(arr));
		}
    }

}
