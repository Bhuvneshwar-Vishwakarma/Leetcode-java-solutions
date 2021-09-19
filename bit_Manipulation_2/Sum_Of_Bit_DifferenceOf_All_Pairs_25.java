package bit_Manipulation_2;
import java.util.*;

public class Sum_Of_Bit_DifferenceOf_All_Pairs_25 {

  public static long solution(int[] arr){
   long res = 0;
   for(int i = 0; i<32; i++){
       long counton = 0;
       for(int val: arr){
           if((val & (1 << i)) != 0){
               counton++;
           }
       }
       
       long countOff = arr.length - counton;
       long diff = counton * countOff * 2;
       res += diff;
   }
   return res;
  }

  public static void main(String[] args){
    try (Scanner scn = new Scanner(System.in)) {
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < arr.length; i++){
		  arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));
	}
  }

}