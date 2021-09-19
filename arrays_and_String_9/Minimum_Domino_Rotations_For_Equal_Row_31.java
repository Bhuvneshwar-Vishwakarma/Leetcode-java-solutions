package arrays_and_String_9;
import java.util.*;

public class Minimum_Domino_Rotations_For_Equal_Row_31 {

  //~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~
  public static int minDominoRotations(int[] tops, int[] bottoms) {
    int count1 = 0, count2 = 0, count3 = 0, count4 = 0;
    int num1 = tops[0];
    int num2 = bottoms[0];
    
    for(int i = 0; i < tops.length; i++) {
    	//for num1 
    	// count1 -> no. of swapping required to make top array as num1;
    	if(count1 != Integer.MAX_VALUE) {
    		if(num1 == tops[i]) {
    			// nothing to do
    		}else if(bottoms[i] == num1) {
    			count1++;
    		}else {
    			count1 = Integer.MAX_VALUE;
    		}
    	}
    	//for num1 
    	// count2 -> no. of swapping required to make bottoms array as num1;
    	if(count2 != Integer.MAX_VALUE) {
    		if(num1 == bottoms[i]) {
    			// nothing to do
    		}else if(tops[i] == num1) {
    			count2++;
    		}else {
    			count2 = Integer.MAX_VALUE;
    		}
    	}
    	//for num2 
    	// count3 -> no. of swapping required to make bottoms array as num2;
    	if(count3 != Integer.MAX_VALUE) {
    		if(num2 == bottoms[i]) {
    			// nothing to do
    		}else if(tops[i] == num2) {
    			count3++;
    		}else {
    			count3 = Integer.MAX_VALUE;
    		}
    	}
    	
    	//for num2 
    	// count4 -> no. of swapping required to make tops array as num2;
    	if(count4 != Integer.MAX_VALUE) {
    		if(num2 == tops[i]) {
    			// nothing to do
    		}else if(bottoms[i] == num2) {
    			count4++;
    		}else {
    			count4 = Integer.MAX_VALUE;
    		}
    	}
    }
    int res = Math.min(Math.min(count1, count2), Math.min(count3, count4));
    
	return res == Integer.MAX_VALUE ? -1 : res;
  }

  //~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] top = new int[n];
    int[] bottom = new int[n];

    // read top
    for (int i = 0; i < top.length; i++) {
      top[i] = scn.nextInt();
    }
    // read bottom
    for (int i = 0; i < bottom.length; i++) {
      bottom[i] = scn.nextInt();
    }

    int rotation = minDominoRotations(top, bottom);
    System.out.println(rotation);
  }
}