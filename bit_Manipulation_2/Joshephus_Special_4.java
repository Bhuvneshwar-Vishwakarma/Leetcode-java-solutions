package bit_Manipulation_2;
import java.util.*;

public class Joshephus_Special_4 {
	
	public static int powerof2(int n) {
		int i = 1;
		while(i * 2 <= n) {
			i = i * 2;
		}
		return i;
	}
	
	public static int solution(int n){
		int hp2 = powerof2(n);
		int l = n - hp2;
	    
		return 2 * l + 1;
	}
  public static void main(String[] args){
    try (Scanner scn = new Scanner(System.in)) {
		int n = scn.nextInt();
		System.out.println(solution(n));
	}
  }
  

}