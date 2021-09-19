package hashMap_and_Heap_5;
import java.util.*;

public class IfArrayCanBeDividedIntoPairsWhoseSumIsDivisibleByK_3 {
	
	public static void solution(int[] arr, int k){
		HashMap<Integer, Integer> rfmap = new HashMap<>();
		for(int val: arr) {
			int rem = val % k;
			
			int of = rfmap.getOrDefault(rem, 0);
			rfmap.put(rem, of + 1);
		}
		
		for(int val: arr) {
			int rem = val % k;
			
			if(rem == 0) {
				int fq = rfmap.getOrDefault(rem, 0);
				if(fq % 2 == 1) {
					System.out.println(false);
					return;
				}
			}else if(rem == (k + 1) / 2) {
				int fq = rfmap.getOrDefault(rem, 0);
				if(fq % 2 == 1) {
					System.out.println(false);
					return;
				}
			}else {
				int fq = rfmap.get(rem);
				int ofq = rfmap.getOrDefault(rem - k, 0);
				if(fq != ofq) {
					System.out.println(false);
					return;
				}
			}
		}
	}

	public static void main(String[] args) {
		try (Scanner scn = new Scanner(System.in)) {
			int n = scn.nextInt();
			int[] arr = new int[n];
			for(int i = 0 ; i < n; i++){
				arr[i] = scn.nextInt();
			}
			int k = scn.nextInt();
			solution(arr,k);
		}
	}

}
