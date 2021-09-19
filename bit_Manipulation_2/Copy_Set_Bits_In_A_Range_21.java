package bit_Manipulation_2;
import java.util.*;

public class Copy_Set_Bits_In_A_Range_21 {

  public static void main(String[] args){
    try (Scanner scn = new Scanner(System.in)) {
		int a = scn.nextInt();
		int b = scn.nextInt();
		int left = scn.nextInt();
		int right = scn.nextInt();

   //write your code here
		int mask = 1;
		mask = (mask << (right - left + 1));
		mask--;
		mask = mask << (left - 1);
		mask = mask & a;
		b = b | mask;
		
		System.out.println(b);
	}
    
  }

}