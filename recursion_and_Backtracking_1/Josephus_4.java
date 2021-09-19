package recursion_and_Backtracking_1;
import java.util.*;

public class Josephus_4 {

  public static int solution(int n, int k){
      if(n == 0){
          return 0;
      }
    int x = solution(n - 1, k);
    int y = (x + k) % n;
    return y;
    
  }
  public static void main(String[] args){
    try (Scanner scn = new Scanner(System.in)) {
		int n = scn.nextInt();
		int k = scn.nextInt();
		System.out.println(solution(n,k));
	}
  }
  

}