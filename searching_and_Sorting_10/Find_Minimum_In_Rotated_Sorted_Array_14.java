package searching_and_Sorting_10;

import java.util.*;

public class Find_Minimum_In_Rotated_Sorted_Array_14 {

    public static int findMinimum(int[]arr) {

    	int lo = 0;
    	int hi = arr.length - 1;
    	
    	if(arr[lo] <= arr[hi]) {// agar array sorted hai to first element hi minimum element hoga
    		return arr[0];
    	}
    	
    	while(lo <= hi) {
    		int mid = (lo + hi) / 2;
    		
    		if(arr[mid] > arr[mid + 1]) {
    			return arr[mid + 1];
    		}else if(arr[mid] < arr[mid - 1]) { 
    			return arr[mid];
    		}else if(arr[lo] <= arr[mid]) {
    			lo = mid + 1;
    		}else if(arr[mid] <= arr[hi]) {
    			hi = mid - 1;
    		}
    	}
    	
        return -1;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];
        for(int i = 0 ; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int ans = findMinimum(arr);
        System.out.println(ans);
    }
}