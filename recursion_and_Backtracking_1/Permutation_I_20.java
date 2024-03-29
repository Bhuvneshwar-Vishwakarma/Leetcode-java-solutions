package recursion_and_Backtracking_1;
import java.io.*;

public class Permutation_I_20 {

  public static void permutations(int[] boxes, int ci, int ti){
    // write your code here
	  if(ci > ti) {
		  for(int i = 0; i<boxes.length; i++) {
			  System.out.print(boxes[i]);
		  }
		  System.out.println();
		  return;
	  }
	  
	  for(int i = 0; i<boxes.length; i++) {
		  if(boxes[i] == 0) {
			  boxes[i] = ci;
			  permutations(boxes, ci + 1, ti);
			  boxes[i] = 0;
		  }
	  }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    permutations(new int[nboxes], 1, ritems);
  }

}