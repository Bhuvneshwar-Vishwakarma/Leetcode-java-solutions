package searching_and_Sorting_10;

import java.util.*;
import java.io.*;

public class Koko_Eating_Bananas_17 {
    public static int minEatingSpeed(int[]piles,int h) {
        //write your code here
    	int max = Integer.MIN_VALUE;
    	
    	for(int val: piles) {
    		max = Math.max(val, max);
    	}
    	
    	if(h == piles.length){// agar hour equils to piles.length;
    		return max;
    	}
    	int lo = 0;
    	int hi = max;
    	int speed = Integer.MAX_VALUE;// we have to find minimum
    	
    	while(lo <= hi) {
    		int sp = lo + (hi - lo) / 2;// to avoid overflow
    		
    		if(isPossible(piles, h, sp)) {
    			speed = sp;
    			hi = sp - 1;
    		}else {
    			lo = sp + 1;
    		}
    	}
    	return speed;
    }
    public static boolean isPossible(int[] piles, int h, int sp) {
    	int time = 0;
    	for(int i = 0; i < piles.length; i++) {
    		time += (int)Math.ceil(piles[i] * 1.0 / sp);
    	}
    	
    	return time <= h;
    }

    public static void main(String[]args) {
        Scanner scn = new Scanner(System.in);
        //input work
        int n = scn.nextInt();
        int[]piles = new int[n];

        for(int i=0 ; i < n ; i++) {
            piles[i] = scn.nextInt();
        }

        int h = scn.nextInt();

        int speed = minEatingSpeed(piles,h);
        System.out.println(speed);
    }
}