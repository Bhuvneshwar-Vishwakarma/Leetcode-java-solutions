package bit_Manipulation_2;
import java.util.*;

public class Xor_Of_Sum_Of_All_Pairs_15 {

    public static int solution(int[] arr){
       //write your code here
    	int ans = 0;
    	for (int val : arr) {
			ans = ans ^ val;
		}
       
       return 2 * ans;
//       for (int val : arr) {
//    	   ans = ans ^ (2 * val);
//       }
//       
//       return 2 * ans;
    }
	public static void main(String[] args) {
		try (Scanner scn = new Scanner(System.in)) {
			int n = scn.nextInt();
			int[] arr = new int[n];
			for(int i = 0 ; i < n; i++){
			    arr[i] = scn.nextInt();
			}
			System.out.println(solution(arr));
		}
    }
    
    
}