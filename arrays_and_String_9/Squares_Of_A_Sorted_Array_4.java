package arrays_and_String_9;
import java.util.*;

public class Squares_Of_A_Sorted_Array_4 {

    // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~

    public static int[] sortedSquares(int[] nums) {
    	int[] res = new int[nums.length];
        int i = 0;// most -ve value
        int j = nums.length - 1; // most +ve value
        int index = nums.length - 1;// help to fill result
        
        while(i <= j) {
        	int val1 = nums[i] * nums[i];
        	int val2 = nums[j] * nums[j];
        	
        	if(val1 > val2) {
        		res[index] = val1;
        		i++;
        	}else {
        		res[index] = val2;
        		j--;
        	}
        	index--;
        }
        return res;
        
    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~

    public static void main(String[] args) {
        try (Scanner scn = new Scanner(System.in)) {
			int n = scn.nextInt();
			int[] nums = new int[n];
			
			for(int i = 0; i < n; i++) 
			    nums[i] = scn.nextInt();
			
			int[] res = sortedSquares(nums);

			for(int i = 0; i < n; i++) {
			    System.out.print(res[i] + " ");
			}
		}
    }
}