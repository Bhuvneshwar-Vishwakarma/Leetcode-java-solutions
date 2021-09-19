package searching_and_Sorting_10;
import java.util.*;

public class Max_Sum_In_The_Configuration_12 {

    public static int maximise(int[]arr) {
        int n = arr.length;
    	int sum = 0;
    	int s0 = 0;
    	for(int i = 0; i < arr.length; i++) {
    		sum += arr[i];
    		s0 += arr[i] * i;
    	}
    	
    	int max = s0;
    	int Si = s0;
    	
    	for(int i = 0; i< n - 1; i++) {
    		int sip1 = Si + sum - n * arr[n - i - 1];// si plus 1
    		max = Math.max(max, sip1);
    		
    		Si = sip1;
    	}
    	return max;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];
        for(int i = 0 ; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int ans = maximise(arr);
        System.out.println(ans);
    }
}