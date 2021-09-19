package dynamic_Programming_3;
import java.util.*;

public class Cherry_Pickup_54 {

	public static int Solution(int r1, int c1, int r2, int[][] arr, int[][][] dp) {
		//write your code here

		return 0;
	}
	public static void main(String[] args) {
		try (Scanner scn = new Scanner(System.in)) {
			int n = scn.nextInt();
			int[][] arr = new int[n][n];
			for(int i = 0; i < n; i++){
				for(int j = 0 ; j < n; j++){
					arr[i][j] = scn.nextInt();
				}
			}
			int ans = Math.max(0,Solution(0, 0, 0, arr, new int[n][n][n]));
			System.out.println(ans);
		}
	}

}