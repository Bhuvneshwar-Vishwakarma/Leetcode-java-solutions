package recursion_and_Backtracking_1;
import java.io.*;

public class Combinations_I_21 { 
//                              current box, total box, sesofa, tosele, asf
  public static void combinations(int cb, int tb, int ssf, int ts, String asf){
    // write your code here
    if(cb > tb){
       if(ssf == ts){
            System.out.println(asf);                           // ncr
       }
        return;
    }
    combinations(cb + 1, tb, ssf + 1, ts, asf + "i");
    combinations(cb + 1, tb, ssf, ts, asf + "-");
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    combinations(1, nboxes, 0, ritems, "");
  }

}