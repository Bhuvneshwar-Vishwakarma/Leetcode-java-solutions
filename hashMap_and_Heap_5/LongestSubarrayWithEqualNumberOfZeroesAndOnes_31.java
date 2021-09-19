package hashMap_and_Heap_5;
import java.util.*;

public class LongestSubarrayWithEqualNumberOfZeroesAndOnes_31 {

    public static int solution(int[] arr) {
    	int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(sum, -1);
        for(int i = 0; i < arr.length; i++) {
        	if(arr[i] == 0) {
        		sum += -1;
        	}else {
        		sum += 1;
        	}
        	
        	if(map.containsKey(sum)) {
        		int idx = map.get(sum);
        		int len = i - idx;
        		if(len > ans) {
        			ans = len;
        		}
        	}else {
        		map.put(sum, i);
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
