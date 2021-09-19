package searching_and_Sorting_10;
import java.util.*;

public class Find_Pivot_Index_5 {

    public static int pivot_index(int[]arr) {
        //1. find sum
    	int sum = sum(arr);
    	int lsum = 0;// left sum
    	int rsum = sum; // right sum
    	
    	for(int i = 0; i < arr.length; i++) {
    		rsum -= arr[i];
    		if(lsum == rsum) {
    			return i;
    		}
    		lsum += arr[i];
    	}
    	
        return -1;
    }
    
    
    
    
    public static int sum(int[] arr) {// find sum in logn
    	int sum = 0;
     	int i = 0;
     	int j = arr.length - 1;
     	if(arr.length % 2 == 0) {
     		while(i < j) {
         		sum += arr[i] + arr[j];
         		i++;
         		j--;
         	}
     	}else {
     		while(i <= j) {
         		sum += arr[i] + arr[j];
         		i++;
         		j--;
         	}
     		sum -= arr[j + 1];
     	}
     	return sum;
    }

    public static void main(String[]args) {
        try (//input work
		Scanner scn = new Scanner(System.in)) {
			int n = scn.nextInt();

			int[]arr = new int[n];
				
			System.out.println("Take input");
			for(int i=0; i < arr.length;i++) {
			    arr[i] = scn.nextInt();
			}
			
			int pi = pivot_index(arr);
			System.out.println(pi);
		}
    }
}