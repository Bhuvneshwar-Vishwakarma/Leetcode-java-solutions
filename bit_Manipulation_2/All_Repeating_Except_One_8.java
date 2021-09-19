package bit_Manipulation_2;
import java.util.*;

public class All_Repeating_Except_One_8 {

  public static void main(String[] args){
    try (Scanner scn = new Scanner(System.in)) {
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
		  arr[i] = scn.nextInt();
		}
		//write your code here
		int uni = 0;
		for(int val: arr){
		    uni = uni ^ val;
		}
		System.out.println(uni);
	}
    
  }

}