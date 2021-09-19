package dynamic_Programming_3;
import java.util.*;

public class Maximum_Sum_Of_M_Non_overlapping_Subarrays_52 {

	public static int solution(int[] arr, int m, int k){
		// write your code here
		
		return 0;
	}
	
	public static void main(String[] args) {
		try (Scanner scn = new Scanner(System.in)) {
			int n = scn.nextInt();
			int[] arr = new int[n];
			for(int i = 0 ; i < arr.length; i++){
				arr[i] = scn.nextInt();
			}
			int m = scn.nextInt();
			int k = scn.nextInt();
			System.out.println(solution(arr, m , k));
		}
	}

}