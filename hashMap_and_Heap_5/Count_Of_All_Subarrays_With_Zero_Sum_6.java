 package hashMap_and_Heap_5;
import java.util.*;

public class Count_Of_All_Subarrays_With_Zero_Sum_6 {

	public static int solution(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int count = 0; 
		int i = -1;
		int sum = 0;
		map.put(sum, 1);
		while(i < arr.length - 1) {
			i++;
			sum += arr[i];
			
			if(map.containsKey(sum)) {
				int oldFreq = map.get(sum);
				count += oldFreq;
				map.put(sum, oldFreq + 1);
			}else{
			    map.put(sum, 1);
			}
		}

		return count;
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
