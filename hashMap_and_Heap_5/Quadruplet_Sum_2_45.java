package hashMap_and_Heap_5;

// package hashMap_and_Heap_5;
import java.util.*;
/*1. You are given four arrays(A1,A2,A3,A4) of integers. All arrays are of same length(N).
2. You have to find the count of all unique quadruplets(a,b,c,d) such that - 
   A1[a] + A2[b] + A3[c] + A4[d] = 0.*/
public class Quadruplet_Sum_2_45 {
	
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		// write your code here
    	HashMap<Integer, Integer> map = new HashMap<>();
    	int count = 0;
    	for(int e1: A) {
    		for(int e2: B) {
    			int val = e1 + e2;
    			map.put(val, map.getOrDefault(val, 0) + 1);
    		}
    	}
    	int target = 0;
    	for(int e1: C) {
    		for(int e2: D) {
    			int val = e1 + e2;
    			int comp = target - val;
    			count += map.getOrDefault(comp, 0);
    		}
    	}

		return count;
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			int[] arr1 = new int[n];
			int[] arr2 = new int[n];
			int[] arr3 = new int[n];
			int[] arr4 = new int[n];
			for (int i = 0; i < n; i++) {
				arr1[i] = sc.nextInt();
			}
			for (int i = 0; i < n; i++) {
				arr2[i] = sc.nextInt();
			}
			for (int i = 0; i < n; i++) {
				arr3[i] = sc.nextInt();
			}
			for (int i = 0; i < n; i++) {
				arr4[i] = sc.nextInt();
			}
			System.out.println(fourSumCount(arr1, arr2, arr3, arr4));
		}
	}

}
