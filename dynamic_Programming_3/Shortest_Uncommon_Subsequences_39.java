package dynamic_Programming_3;
//to find shortest uncommon subsequence.
/*Given two strings S and T, find the length of the shortest subsequence in S 
 * which is not a subsequence in T. If no such subsequence is possible, return -1. 
 * A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous. 
 * A string of length n has 2^n different possible subsequences.
String S of length m (1 <= m <= 1000) 
String T of length n (1 <= n <= 1000)
Examples: 

Input : S = “babab” T = “babba”
Output : 3
The subsequence “aab” of length 3 is 
present in S but not in T.

Input :  S = “abb” T = “abab”
Output : -1
There is no subsequence that is present 
in S but not in T.



Brute Force Method 
A simple approach will be to generate all the subsequences of string S and for each subsequence 
check if it is present in string T or not. Consider example 2 in which S = “abb”, 
its subsequences are “”, ”a”, ”b”, ”ab”, ”bb”, ”abb” each of which is present in “abab”. 
The time complexity of this solution will be exponential.

*/
public class Shortest_Uncommon_Subsequences_39 {

	static final int MAX = 1005;

	// Returns length of shortest common subsequence
	static int shortestSeq(char[] S, char[] T) {
	     int m = S.length, n = T.length;
	
	     // declaring 2D array of m + 1 rows and
	     // n + 1 columns dynamically
	     int dp[][] = new int[m + 1][n + 1];
	
	     // T string is empty
	     for (int i = 0; i <= m; i++) {
	         dp[i][0] = 1;
	     }
	
	     // S string is empty
	     for (int i = 0; i <= n; i++){
	         dp[0][i] = MAX;
	     }
	
	     for (int i = 1; i <= m; i++){
	    	 for (int j = 1; j <= n; j++){
	             char ch = S[i - 1];
	             int k;
	             for (k = j - 1; k >= 0; k--){
	                 if (T[k] == ch)
	                 {
	                     break;
	                 }
	             }

             // char not present in T
             if (k == -1){
                 dp[i][j] = 1;
             }else {
                 dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][k] + 1);
             }
         }
     }

     int ans = dp[m][n];
     if (ans >= MAX){
         ans = -1;
     }
     return ans;
 }

 // Driver code
 public static void main(String[] args)
 {
     char S[] = "babab".toCharArray();
     char T[] = "babba".toCharArray();
     
     System.out.println("Length of shortest" + "subsequence is : " +shortestSeq(S, T));
     /*Time complexity: O(mn^2)
Space Complexity: O(mn)*/
 }
}

//This code is contributed by 29AjayKumar