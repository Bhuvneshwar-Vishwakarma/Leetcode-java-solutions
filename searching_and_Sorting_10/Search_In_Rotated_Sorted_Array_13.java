package searching_and_Sorting_10;
import java.util.*;

public class Search_In_Rotated_Sorted_Array_13 {

    public static int find(int[]arr,int target) {
        
    	int lo = 0;
    	int hi = arr.length - 1;
    	
    	while(lo <= hi) {
    		int mid = (lo + hi) / 2;
    		
    		if(arr[mid] == target) {
    			return mid;
    		}else if(arr[lo] <= arr[mid]) {// left array is sorted
    			// lo to mid part is sorted
    			if(target >= arr[lo] && target < arr[mid]) {// left arr me hai
    				hi = mid - 1;
    			}else {
    				lo = mid + 1;
    			}
    		}else if(arr[mid] <= arr[hi]) {// right array is sorted
    			// mid to hi part is sorted
    			if(target > arr[mid] && target <= arr[hi]) {
    				lo = mid + 1;
    			}else {
    				hi = mid - 1;
    			}
    			
    		}
    	}
    	
    	return -1;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[]arr = new int[n];

        for(int i=0; i < n;i++) {
            arr[i] = scn.nextInt();
        }

        int target = scn.nextInt();
        int ans = find(arr,target);
        System.out.println(ans);
    }
}