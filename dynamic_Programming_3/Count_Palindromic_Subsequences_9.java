package dynamic_Programming_3;
import java.util.*;

public class Count_Palindromic_Subsequences_9 {

    public static void main(String[] args) throws Exception {
        try (Scanner sc = new Scanner(System.in)) {
			String str = sc.next();
			
			int[][] dp = new int[str.length() + 1][str.length() + 1];
			for(int g = 0; g < str.length(); g++){
			    for(int i = 0, j = g; j < str.length(); i++, j++){
			        if(g == 0){
			            dp[i][j] = 1;
			        }else if(g == 1){
			            dp[i][j] = str.charAt(i) == str.charAt(j) ? 3: 2; 
			        }else {
			            if(str.charAt(i) == str.charAt(j)){
			                dp[i][j] = dp[i][j - 1] + dp[i + 1][j] + 1;
			            }else{
			                dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1];
			            }
			        }
			    }
			}
			System.out.println(dp[0][str.length() - 1]);
		}
    }

}