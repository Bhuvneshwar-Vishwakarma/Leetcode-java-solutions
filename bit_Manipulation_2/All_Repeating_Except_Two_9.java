package bit_Manipulation_2;
import java.util.*;

public class All_Repeating_Except_Two_9 {

  public static void main(String[] args){
    try (Scanner scn = new Scanner(System.in)) {
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
		  arr[i] = scn.nextInt();
		}
		solution(arr);
	}
  }

  public static void solution(int[] arr){
   //write your code here
	  int xxory = 0;
	  for(int val: arr) {
		  xxory = xxory ^ val;
	  }
	  int rbsm = xxory & -xxory;
	  int x = 0;
	  int y = 0;
	  
	  for(int val: arr) {
		  if((val & rbsm) == 0) {
			  x = x ^ val;
		  }else {
			  y = y ^ val;
		  }
	  }
	  if(x < y) {
		  System.out.println(y);
		  System.out.println(x);
	  }else {
		  System.out.println(y);
		  System.out.println(x);
	  }
   
  }

}