package hashMap_and_Heap_5;
import java.util.*;

public class Double_Pair_Array_38 {

    public static boolean solution(int[] arr) {
        // write your code here
    	HashMap<Integer, Integer> freqMap = new HashMap<>();
    	for(int val: arr) {
    		freqMap.put(val, freqMap.getOrDefault(val, 0) + 1);
    	}
        
    	Integer[] ar = new Integer[arr.length];
    	for(int i = 0; i < arr.length; i++) {
    		ar[i] = arr[i];
    	}
    	
    	Arrays.sort(ar, (a, b)->{
    		return Math.abs(a) - Math.abs(b);
    	});
    	
    	for(Integer val: ar) {
    		if(freqMap.get(val) == 0) continue;
    		if(freqMap.getOrDefault(2 * val, 0) == 0) return false;
    		
    		freqMap.put(val, freqMap.get(val) - 1);
    		freqMap.put(2 * val, freqMap.get(2 * val) - 1);
    		
    	}
    	
        return true;
    }
    
    public static void main(String[] args) {
		try (Scanner scn = new Scanner(System.in)) {
			int n = scn.nextInt();
			int[] arr = new int[n];
			for(int i = 0 ; i < n; i++){
				arr[i] = scn.nextInt();
			}
			System.out.println(solution(arr));
		}
	}

}
