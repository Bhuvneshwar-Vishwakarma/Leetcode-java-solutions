package bit_Manipulation_2;
import java.util.*;

public class Swap_All_Odd_And_Even_Bits_24 {

  public static void main(String[] args){
    try (Scanner scn = new Scanner(System.in)) {
		int n = scn.nextInt();
		//write your code here
		int om = 0x55555555;
		int em = 0xAAAAAAAA;
		int odds = (n & om);
		int even = (n & em);
		odds <<= 1;
		even >>= 1;
		n = odds | even;
		System.out.println(n);
	}
    
    
  }

}