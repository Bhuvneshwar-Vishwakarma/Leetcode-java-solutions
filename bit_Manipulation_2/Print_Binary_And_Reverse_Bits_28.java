package bit_Manipulation_2;
import java.util.*;

public class Print_Binary_And_Reverse_Bits_28 {

  public static void main(String[] args){
    try (Scanner scn = new Scanner(System.in)) {
		int n = scn.nextInt();
		
		//write your code here
		boolean flag = false;
		int rev = 0;
		int j = 0;
		
		for(int i = 31; i>= 0; i--) {
			int mask = (1 << i);
			
			if(flag) {
				if((n & mask) != 0) {
					System.out.print(1);
					
					int smask = (1 << j);
					rev |= smask;
				}else {
					System.out.print(0);
				}
				j++;
			}else {
				if((n & mask) != 0) {
					flag = true;
					System.out.print(1);
					
					int smask = (1 << j);
					rev |= smask;
					j++;
				}else {
					
				}
			}
		}
		System.out.println();
		System.out.println(rev);
	}
    
  }

}