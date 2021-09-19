package arrays_and_String_9;
import java.util.*;

public class Max_Chunks_To_Make_Array_Sorted_II_11 {

    // ~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~
    public static int maxChunksToSorted2(int[] arr) {
        // 1. right min
    	int[] rightMin = new int[arr.length + 1];
    	rightMin[arr.length] = Integer.MAX_VALUE;
    	
    	for(int i = arr.length - 1; i >= 0; i--) {
    		rightMin[i] = Math.min(rightMin[i + 1], arr[i]);
    	}
    	
    	int count = 0;
    	int leftMax = Integer.MIN_VALUE;
    	
    	for(int i = 0; i < arr.length; i++) {
    		leftMax = Math.max(leftMax, arr[i]);
    		if(leftMax <= rightMin[i + 1]) {
    			count++;
    		}
    	}
    	
    	return count;
    }

    // ~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int res = maxChunksToSorted2(arr);
        System.out.println(res);
    }
}