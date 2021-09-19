package searching_and_Sorting_10;
import java.util.*;

public class Maximize_Sum_Of_Arr_i_Of_An_Array_9 {

    public static int maximise(int[]arr) {
        int osum = 0;
    	Arrays.sort(arr);
    	
    	for(int i = 0; i < arr.length; i++) {
    		osum += arr[i] * i;
    	}
    	
        return osum;
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