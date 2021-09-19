package recursion_and_Backtracking_1;
import java.io.*;

public class Coin_Change_Permutations_I_44 {

    public static void coinChange(int[] coins, int amtsf, int tamt, String asf, boolean[] used){
       // write your code here
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int amt = Integer.parseInt(br.readLine());
        boolean[] used = new boolean[coins.length];
        coinChange(coins, 0, amt, "", used);
    }
}