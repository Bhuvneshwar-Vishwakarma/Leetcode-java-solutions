package recursion_and_Backtracking_1;
import java.io.*;
import java.util.*;

public class Words_K_Selection_I_34 {

  public static void generateWords(int i, String ustr, int ssf, int ts, String asf) { 
	  
    // write your code here
	  if(i == ustr.length()) {
		 if(ssf == ts) {
			 System.out.println(asf);
		 }
		  return;
	  }
    char ch = ustr.charAt(i);
    generateWords(i + 1, ustr, ssf + 1, ts, asf + ch);
    generateWords(i + 1, ustr, ssf, ts, asf + "");
    
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());
 
    HashSet<Character> unique = new HashSet<>();
    String ustr = "";
    
    for(char ch: str.toCharArray()){
      if(unique.contains(ch) == false) {
    	  unique.add(ch);
    	  ustr += ch;
      }
    }

    generateWords(0, ustr, 0, k, "");
  }

}