 package bit_Manipulation_2;
import java.util.*;

public class Same_Number_Set_Bits_14 {
    public static long ncr(long n, long r){
        if(n < r){
            return 0L;    
        }
        
        long res = 1L;
        
        for(long i = 0L; i < r; i++){
            res = res * (n - i);
            res = res / (i + 1);
        }
        
        return res;
    }
    
    public static long solution(long n, int k, int i) {
        if(i == 0){
            return 0;
        }
      long res = 0;
      
      long mask = 1L << i;
      
      if((n & mask) == 0) {// bit is off(0)
    	  res = solution(n, k, i - 1);
      }else {
    	  long res1 = solution(n, k - 1, i - 1);
    	  long res0 = ncr(i, k);
    	  res = res1 + res0;
      }
      
      return res;
    }
    
    public static int csb(long n){
        int res = 0;
        
        while(n > 0){
            long rsb = n & -n;
            n -= rsb;
            res++;
        }
        
        return res;
    }
    
	public static void main(String[] args) {
		try (Scanner scn = new Scanner(System.in)) {
			long n = scn.nextLong();
			int k = csb(n);
			System.out.println(solution(n, k, 63));
		}
    }
	
	
}