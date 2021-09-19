package bit_Manipulation_2;
import java.util.*;

public class Flip_Bits_To_Convert_A_to_B_20 {

  public static void main(String[] args){
    try (Scanner scn = new Scanner(System.in)) {
		int a = scn.nextInt();
		int b = scn.nextInt();

		//write your code here
		int flipped = a ^ b;
		
		int count = 0;
		while(flipped != 0){
		    int rsb = flipped & (-flipped);
		    flipped -= rsb;
		    count++;
		}
		System.out.println(count);
	}
  }

}