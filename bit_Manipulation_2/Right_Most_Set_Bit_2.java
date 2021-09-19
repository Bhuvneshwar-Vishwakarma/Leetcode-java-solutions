package bit_Manipulation_2;
import java.util.*;

public class Right_Most_Set_Bit_2 {

  public static void main(String[] args){
    try (Scanner scn = new Scanner(System.in)) {
		//write your code here
		int n = scn.nextInt();
		int rsbm = n & -n;
		System.out.println(Integer.toBinaryString(rsbm));
	}

  }

}