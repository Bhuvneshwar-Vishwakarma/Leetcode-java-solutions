package bit_Manipulation_2;
import java.util.*;

public class Utf_8_Encoding_17 {

    public static boolean solution(int[] arr) {
        //write your code here
        int rbytes = 0;
        for(int val: arr) {
        	if(rbytes == 0) {
        		if((val >> 7) == 0) {//1st byte of 1 length char
        			rbytes = 0;
        		}else if((val >> 5) == 0b110) {// 1st byte of 2 length  char
        			rbytes = 1;
        		}else if((val >> 4) == 0b1110) {//1st byte of 3 length char
        			rbytes = 2;
        		}else if((val >> 3) == 0b11110) {//1st byte of 4 length char
        			rbytes = 3;
        		}
        	}else {
        		if((val >> 6) == 0b10) {
        			rbytes--;
        		}else {
        			return false;
        		}
        	}
        }
        
        if(rbytes == 0) {
        	return true;
        }else {
        	return false;
        }
    }
	public static void main(String[] args) {
        try (Scanner scn = new Scanner(System.in)) {
			int n = scn.nextInt();
			int[] arr = new int[n];
			for(int i = 0 ; i < n; i++){
			    arr[i] = scn.nextInt();
			}
			System.out.println(solution(arr));
		}
    }
    
    
}