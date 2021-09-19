package hashMap_and_Heap_5;
import java.util.*;

public class Largest_Subarray_With_Zero_Sum_5 {
	
	public static int solution(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int i = -1; 
		int sum = 0;
		int maxLen = 0;
		map.put(sum, i);
		
		while(i < arr.length - 1) {
			i++;
			sum += arr[i];
			
			if(map.containsKey(sum) == false) {
				map.put(sum, i);
			}else {
				int oIndx = map.get(sum);
				int len = i - oIndx;
				
				if(len > maxLen) {
					maxLen = len;
				}
			}
		}

		return maxLen;
	}

	public static void main(String[] args) {
		try (Scanner scn = new Scanner(System.in)) {
			int[] arr = new int[scn.nextInt()];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = scn.nextInt();
			}
			System.out.println(solution(arr));
		}
	}

}
