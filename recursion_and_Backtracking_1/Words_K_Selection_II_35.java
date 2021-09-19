 package recursion_and_Backtracking_1;
import java.io.*;
import java.util.*;

public class Words_K_Selection_II_35 {

  public static void generateWords(String ustr, int cs, int ts, int lc, String asf) { 
	  
    // write your code here
	  if(cs > ts) {
		  System.out.println(asf);
		  return;
	  }
	  for(int i = lc + 1; i<ustr.length(); i++) {
		  char ch = ustr.charAt(i);
		  generateWords(ustr, cs + 1, ts, i, asf + ch);	  
	  }
    
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

    generateWords(ustr, 1, k, -1, "");
  }

}