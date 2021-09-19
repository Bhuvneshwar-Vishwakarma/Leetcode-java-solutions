package recursion_and_Backtracking_1;
import java.io.*;
//https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/queens-combinations-2das2d-box-chooses-official/ojquestion
public class Queens_Combinations_2d_as_2d_Box_Chooses_24 {

    public static void queensCombinations(int qpsf, int tq, int row, int col, String asf){
        // write your code here
    	if(row == tq) {
    		if(qpsf == tq) {
    			System.out.println(asf);
    		}
    		return;
    	}
    	
    	String yasf = "";
    	String nasf = "";
    	int nr = 0;
    	int nc = 0;
    	if(col == tq - 1) {
    		nr = row + 1;
    		nc = 0;
    		yasf = asf + "q\n";
    		nasf = asf + "-\n";
    		
    	}else {
    		nc = col + 1;
    		nr = row;
    		yasf = asf + "q";
    		nasf = asf + "-";
    	}
    	
    	
    	queensCombinations(qpsf + 1, tq, nr, nc, yasf);
    	queensCombinations(qpsf, tq, nr, nc, nasf);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        queensCombinations(0, n, 0, 0, "");
    }
}