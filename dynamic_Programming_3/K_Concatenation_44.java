package dynamic_Programming_3;

import java.util.Scanner;

public class K_Concatenation_44 {
	
	public static int kadanes(int[] arr) {
		int csum = arr[0];
		int osum = arr[0];
		
		for(int i = 1; i < arr.length; i++) {
			if(csum >= 0) {
				csum += arr[i];
			}else {
				csum = arr[i];
			}
			
			if(csum > osum) {
				osum = csum;
			}
		}
		return osum;
	}
	public static int kadanesOfTwo(int[] arr) {
		int[] narr = new int[arr.length * 2];
		
		for(int i = 0; i < arr.length; i++) {
			narr[i] = arr[i];
		}
		for(int i = 0; i < arr.length; i++) {
			narr[i + arr.length] = arr[i];
		}
		return kadanes(narr);
	}
	
	public static long solution(int[] arr, long k, long sum) {
		if(k == 1) {
			return kadanes(arr);
		}else if(sum < 0) {
			return kadanesOfTwo(arr);
		}else {
			return kadanesOfTwo(arr) + (k - 2) * sum;
		}
	}
 
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			long sum = 0;
			for(int i = 0; i< arr.length; i++) {
				arr[i] = sc.nextInt();
				sum += arr[i];
			}
			
			int k = sc.nextInt();
			System.out.println(solution(arr, k, sum));
		}
		

	}

}
