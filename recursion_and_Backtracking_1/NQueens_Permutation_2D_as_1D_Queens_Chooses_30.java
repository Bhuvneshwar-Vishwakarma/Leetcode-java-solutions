package recursion_and_Backtracking_1;
import java.io.*;

public class NQueens_Permutation_2D_as_1D_Queens_Chooses_30 {
//	public class Main {

    public static boolean isQueenSafe(int[][] chess, int row, int col) {
        // write your code here
    	for(int i = row, j = col; i >= 0; i--) { // vertical check
    		if(chess[i][j] != 0) {
    			return false;
    		}
    	}
    	for(int j = col, i = row; j >= 0; j--) { // left horizontal check
    		if(chess[i][j] != 0) {
    			return false;
    		}
    	}
    	for(int i = row, j = col; i >= 0 && j >= 0; i--, j--) { // left diagonal
    		if(chess[i][j] != 0) {
    			return false;
    		}
    	}
    	for(int i = row, j = col; i >= 0 && j < chess.length; i--, j++) { // right diagonal
    		if(chess[i][j] != 0) {
    			return false;
    		}
    	}
    	//upper
    	for(int j = col, i = row; j<chess.length; j++) { // right horizontal check
    		if(chess[i][j] != 0) {
    			return false;
    		}
    	}
    	for(int i = row, j = col; i<chess.length; i++) { // down vertical check
    		if(chess[i][j] != 0) {
    			return false;
    		}
    	}
    	for(int i = row, j = col; i<chess.length && j >= 0; i++, j--) { // down left diagonal
    		if(chess[i][j] != 0) {
    			return false;
    		}
    	}
    	for(int i = row, j = col; i<chess.length && j < chess.length; i++, j++) { // down right diagonal
    		if(chess[i][j] != 0) {
    			return false;
    		}
    	}
    	
    	
    	return true;
    }

    public static void nqueens(int qpsf, int tq, int[][] chess) {
        // write your code here
    	if(qpsf == tq) {
    		for(int i = 0; i<chess.length; i++) {
    			for(int j = 0; j < chess.length; j++) {
    				if(chess[i][j] == 0) {
    					System.out.print("-\t");
    				}else {
    					System.out.print("q" + chess[i][j]);
    				}
    			}
    			System.out.println();
    		}
    		System.out.println();
    		return;
    	}
    	for(int cell = 0; cell < chess.length * chess.length; cell++) {
    		int row = cell / chess.length;
    		int col = cell % chess.length;
    		
    		if(chess[row][col] == 0 && isQueenSafe(chess, row, col)) {
    			chess[row][col] = qpsf + 1;
    			nqueens(qpsf + 1, tq, chess);
    			chess[row][col] = 0;
    		}
    	}
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] chess = new int[n][n];

        nqueens(0, n, chess);
    }
}