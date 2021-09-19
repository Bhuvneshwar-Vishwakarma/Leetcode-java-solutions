package bit_Manipulation_2;
import java.util.*;

public class Solve_7n_by_8_23 {

  public static void main(String[] args){
    try (Scanner scn = new Scanner(System.in)) {
		int n = scn.nextInt();
		//write your code here
		int val = ((n << 3) - n) >> 3;
		System.out.println(val);
	}
    
  }

}