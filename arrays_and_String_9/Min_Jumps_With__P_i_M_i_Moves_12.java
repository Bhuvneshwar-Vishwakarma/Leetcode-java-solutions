package arrays_and_String_9;
/*Min Jumps With +i -i Moves
 * 
1. Given an integers X. 
2. The task is to find the minimum number of jumps to reach a point X in the number line starting from zero.
3. The first jump made can be of length one unit and each successive jump will be exactly one unit longer than the previous jump in length. 
4. It is allowed to go either left or right in each jump.*/
import java.util.*;

public class Min_Jumps_With__P_i_M_i_Moves_12 {
    // ~~~~~~~~~~~~User Section~~~~~~~~~~~
    public static int minJumps(int x) {
        int sum = 0;
        int jump = 1;
        while(sum < x) {
        	sum += jump;
        	jump++;
        }
        int distance = sum - x;
        
        if(distance % 2 == 0) {
        	return jump - 1;
        }else if((distance + jump) % 2 == 0) {
        	return jump;
        }else {
        	return jump + 1;
        }
    	
    	
    	
//    	return 0;
    }

    //~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();

        int jumps = minJumps(x);
        System.out.println(jumps);
    }
}