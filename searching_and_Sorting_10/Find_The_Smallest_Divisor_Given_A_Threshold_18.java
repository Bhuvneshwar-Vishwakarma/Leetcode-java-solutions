package searching_and_Sorting_10;

import java.util.*;

public class Find_The_Smallest_Divisor_Given_A_Threshold_18 {
    public static int findSmallestDivisor(int[]nums,int th) {
    	int max = Integer.MIN_VALUE;
    	
    	for(int val: nums) {
    		max = Math.max(val, max);
    	}
    	
    	if(th == nums.length){// agar thour equils to nums.lengtth;
    		return max;
    	}
    	int lo = 0;
    	int thi = max;
    	int speed = Integer.MAX_VALUE;// we thave to find minimum
    	
    	while(lo <= thi) {
    		int sp = lo + (thi - lo) / 2;// to avoid overflow
    		
    		if(isPossible(nums, th, sp)) {
    			speed = sp;
    			thi = sp - 1;
    		}else {
    			lo = sp + 1;
    		}
    	}
    	return speed;
    }
    public static boolean isPossible(int[] nums, int th, int sp) {
    	int time = 0;
    	for(int i = 0; i < nums.length; i++) {
    		time += (int)Math.ceil(nums[i] * 1.0 / sp);
    	}
    	
    	return time <= th;
    }
    public static void main(String[]args) {
        Scanner scn = new Scanner(System.in);
        //input work
        int n = scn.nextInt();
        int[]nums = new int[n];

        for(int i=0 ; i < n ; i++) {
            nums[i] = scn.nextInt();
        }

        int tth = scn.nextInt();

        int speed = findSmallestDivisor(nums,tth);
        System.out.println(speed);
    }
}