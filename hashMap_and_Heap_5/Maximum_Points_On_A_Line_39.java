package hashMap_and_Heap_5;
import java.util.*;

public class Maximum_Points_On_A_Line_39 {

	public static  int solution(int[][] points) {
		// write your code here
		
		return 0;
	}
	
    public static void main(String[] args) {
		try (Scanner scn = new Scanner(System.in)) {
			int n = scn.nextInt();
			int[][] arr = new int[n][2];
			for(int i = 0 ; i < n; i++){
				for(int j = 0 ; j < 2; j++){
					arr[i][j] = scn.nextInt();
				}
			}
			System.out.println(solution(arr));
		}
	}

}
