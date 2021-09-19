package hashMap_and_Heap_5;

import java.util.Scanner;

public class Maximum_Consicutive__Ones_1_allowed_16 {
	
	private static int solution(int[] arr) {
		int ans = 0;
		int j = -1;
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == 0) {
				count++;
			}
			
			while(count > 1) {
				j++;
				if(arr[j] == 0) {
					count--;
				}
			}
			int len = i - j;
			if(len > ans) {
				ans = len;
			}
		}
		
		return ans;
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}

			System.out.println(solution(arr));
		}

	}

}
