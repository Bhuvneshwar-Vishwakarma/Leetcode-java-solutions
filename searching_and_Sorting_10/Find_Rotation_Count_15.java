package searching_and_Sorting_10;

import java.util.*;

public class Find_Rotation_Count_15 {

    public static int findRotationCount(int[]arr) {
    	
    	int lo = 0;
    	int hi = arr.length - 1;
    	
    	if(arr[lo] <= arr[hi]) {// array is sorted 
    		return 0;
    	}
    	
    	while(lo <= hi) {
    		int mid = (lo + hi) / 2;
    		
    		if(arr[mid] > arr[mid + 1]) {
    			return mid + 1;
    		}else if(arr[mid] < arr[mid - 1]) {
    			return mid;
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

        int ans = findRotationCount(arr);
        System.out.println(ans);
    }
}