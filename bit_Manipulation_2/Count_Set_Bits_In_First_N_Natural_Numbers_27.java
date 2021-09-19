package bit_Manipulation_2;
import java.util.*;

public class Count_Set_Bits_In_First_N_Natural_Numbers_27 {

  public static void main(String[] args){
    try (Scanner scn = new Scanner(System.in)) {
		int n = scn.nextInt();
		System.out.println(solution(n));
	}
  }

  public static int solution(int n){
    //write your code here
	  if(n == 0) {
		  return 0;
	  }
	  int x = largestPowerOf2inrange(n);
	  int btill2x = x * (1 << (x - 1)); // x.2^x-1
	  int msb2xton = n - (1 << x) + 1; // n - 2^x + 1
	  int rest = n - (1 << x);// n - 2^x
	  int ans = btill2x + msb2xton + solution(rest);
	  return ans;
    
  }
  public static int largestPowerOf2inrange(int n) {
	  int x = 0;
	  while((1 << x) <= n) {
		  x++;
	  }
	  return x - 1;
  }

}