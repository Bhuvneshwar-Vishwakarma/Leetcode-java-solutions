package hashMap_and_Heap_5;
import java.util.*;

public class CountOfSubarraysWithEqualNumberOfZeroesAndOnes_32 {

    public static int solution(int[] arr) {
        // write your code here
    	int ans = 0;
    	
    	HashMap<Integer, Integer> map = new HashMap<>();
    	int sum = 0;
    	map.put(sum, 1);
    	
    	for (int val : arr) {
			if(val == 0) {
				sum += -1;
			}else {
				sum += 1;
			}
			
			if(map.containsKey(sum)) {
				ans += map.get(sum);
				map.put(sum, map.get(sum) + 1);
			}else {
				map.put(sum, 1);
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
