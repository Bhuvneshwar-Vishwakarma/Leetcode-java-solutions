package searching_and_Sorting_10;

import java.util.*;

public class Roof_Top_8 {

    public static int findMaxSteps(int[]arr) {
        int max = 0;
        int c = 0;
        
        for(int i = 0; i < arr.length - 1; i++) {
        	if(arr[i] < arr[i + 1]) {
        		c++;
        	}else {
        		max = Math.max(c, max);
        		c = 0;// reset
        	}
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

        int ans = findMaxSteps(arr);
        System.out.println(ans);
    }
}