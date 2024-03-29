package arrays_and_String_9;

import java.util.*;

public class Container_With_Most_Water_3 {

    // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~

    public static int mostWater(int[] heights) {

        int i = 0;
        int j = heights.length - 1;
    	
        int water = 0;
        while(i < j) {
        	int width = j - i;
        	int height = Math.min(heights[i], heights[j]);
        	water = Math.max(water, height * width);
        	
        	if(heights[i] < heights[j]) {
        		i++;
        	}else {
        		j--;
        	}
        }
    	
    	return water;
    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~

    public static void main(String[] args) {
        // Write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] heights = new int[n];
        for(int i = 0; i < n; i++) {
            heights[i] = scn.nextInt();
        }

        int res = mostWater(heights);
        System.out.println(res);
    }
}