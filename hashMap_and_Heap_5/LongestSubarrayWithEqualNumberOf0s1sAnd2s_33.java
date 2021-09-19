package hashMap_and_Heap_5;
import java.util.*;

public class LongestSubarrayWithEqualNumberOf0s1sAnd2s_33 {

    public static int solution(int[] arr) {
        // write your code here
    	int ans = 0;
    	HashMap<String, Integer> map = new HashMap<>();
    	int countZ = 0;
    	int countO = 0;
    	int countT = 0;
    	
    	int delta10 = countO - countZ;
    	int delta21 = countT - countO;
    	
    	String key = delta21 +"#"+ delta10;
    	map.put(key, -1);
    	
    	for(int i = 0; i < arr.length; i++) {
    		if(arr[i] == 0) {
    			countZ++;
    		}else if(arr[i] == 1) {
    			countO++;
    		}else {
    			countT++;
    		}
    		
    		delta10 = countO - countZ;
        	delta21 = countT - countO;
        	
        	key = delta21 +"#"+ delta10;
        	
        	if(map.containsKey(key)) {
        		int idx = map.get(key);
        		int len = i - idx;
        		ans = Math.max(len, ans);
        	}else {
        		map.put(key, i);
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
