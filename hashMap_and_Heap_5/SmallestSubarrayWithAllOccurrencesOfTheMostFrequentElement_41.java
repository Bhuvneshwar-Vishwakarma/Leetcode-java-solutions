package hashMap_and_Heap_5;
import java.util.*;

public class SmallestSubarrayWithAllOccurrencesOfTheMostFrequentElement_41 {

    public static void solution(int[] arr) {
        // write your code here
    	HashMap<Integer, Integer> freqMap = new HashMap<>();
    	HashMap<Integer, Integer> startMap = new HashMap<>();
    	int hfreq = 0;// highest frequency
    	int si = 0;// start index;
    	int ei = 0;// end index;
    	int len = ei - si + 1;// length
    	
    	for(int i = 0; i < arr.length; i++) {
    		if(freqMap.containsKey(arr[i])) {
    			freqMap.put(arr[i], freqMap.get(arr[i]) + 1);
    		}else {
    			freqMap.put(arr[i], 1);
    			startMap.put(arr[i], i);
    		}
    		
    		if(freqMap.get(arr[i]) > hfreq) {
    			hfreq = freqMap.get(arr[i]);
    			si = startMap.get(arr[i]);
    			ei = i;
    			len = ei - si + 1;
    			
    		}else if(freqMap.get(arr[i]) == hfreq) {
    			int clen = i - startMap.get(arr[i]) + 1; // challenging length
    			if(clen < len) {
    				hfreq = freqMap.get(arr[i]);
        			si = startMap.get(arr[i]);
        			ei = i;
        			len = ei - si + 1;
    			}	
    		}
    	}
    	
    	System.out.println(arr[si]);
    	System.out.println(si);
    	System.out.println(ei);
    	
    	
        
        
    }
    
    public static void main(String[] args) {
		try (Scanner scn = new Scanner(System.in)) {
			int n = scn.nextInt();
			int[] arr = new int[n];
			for(int i = 0 ; i < n; i++){
				arr[i] = scn.nextInt();
			}
			solution(arr);
		}
	}

}
