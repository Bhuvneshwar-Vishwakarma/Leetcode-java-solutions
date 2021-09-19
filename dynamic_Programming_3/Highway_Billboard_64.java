package dynamic_Programming_3;
import java.util.*;
public class Highway_Billboard_64{
	
	//*********There are two approach***************//
	
    public static int solution(int m , int[] allowed, int[] rev, int t) {//( O(total road length) || Miles
      
    	HashMap<Integer, Integer> map = new HashMap<>();
    	for(int i = 0; i < allowed.length; i++) {
    		map.put(allowed[i], rev[i]);
    	}
    	
       int[] dp = new int[m + 1];
       dp[0] = 0;
       
       for(int i = 1; i <= m; i++) {
    	   if(map.containsKey(i) == false) {
    		   dp[i] = dp[i - 1];
    	   }else {
    		   int boardNotInstalled = dp[i - 1];
    		   int boardInstalled = map.get(i);
    	    	  
    		   if(i >= t + 1) {
    	    	  boardInstalled += dp[i - t - 1];
    		   }
    	    	  
    		   dp[i] = Math.max(boardNotInstalled, boardInstalled);
    		   
    	   }
       }
       return dp[m];
    }
    public static int N_squre_Approach(int m , int[] allowed, int[] rev, int t) {// (Number of allowed board)^2
    	int ans = 0;
    	
    	int[] dp = new int[allowed.length];
    	dp[0] = rev[0];
    	
    	for(int i = 1; i < allowed.length; i++) {
    		int max = 0;
    		
    		for(int j = 0; j < i; j++) {
    			int dist = allowed[i] - allowed[j];
    			if(dist > t) {
    				max = Math.max(max, dp[j]);
    			}   
    		}
    		
    		dp[i] = max + rev[i];
    		ans = Math.max(ans, dp[i]);
    	}
    	return ans;
    }
    public static void input(int []arr,Scanner scn){
        for(int i = 0;i<arr.length;i++){
            arr[i] = scn.nextInt();
        }
    }
    public static void main(String []args){
        Scanner scn = new Scanner(System.in);   
        int m = scn.nextInt();
        int n = scn.nextInt();
        
        int x[] = new int[n];
        input(x, scn);

        int revenue[] = new int[n];
        input(revenue,scn);

        int t = scn.nextInt();

        System.out.println(solution(m, x, revenue, t));
        scn.close();
    }
}