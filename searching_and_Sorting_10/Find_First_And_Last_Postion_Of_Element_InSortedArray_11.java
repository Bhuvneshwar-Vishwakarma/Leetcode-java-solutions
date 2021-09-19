package searching_and_Sorting_10;
import java.util.*;

public class Find_First_And_Last_Postion_Of_Element_InSortedArray_11 {

    public static int[] find(int[]arr,int target) {
    	int[] ans = {-1, -1};
        //for first index
    	int lo = 0;
    	int hi = arr.length - 1;
    	while(lo <= hi) {
    		int mid = (lo + hi) / 2;
    		
    		if(arr[mid] == target) {
    			ans[0] = mid;
    			
    			hi = mid - 1;// main part
    		}else if(arr[mid] < target) {
    			lo = mid + 1;
    		}else {
    			hi = mid - 1;
    		}
    	}
    	
    	// for last index
    	lo = 0;
    	hi = arr.length - 1;
    	while(lo <= hi) {
    		int mid = (lo + hi) / 2;
    		if(arr[mid] == target) {
    			ans[1] = mid;
    			
    			lo = mid + 1;// main part
    		}else if(arr[mid] < target) {
    			lo = mid + 1;
    		}else {
    			hi = mid - 1;
    		}
    	}
    	
    	return ans;
    	
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
        int[] ans = find(arr,target);
        System.out.println(ans[0] +" "+ ans[1]);
    }
}