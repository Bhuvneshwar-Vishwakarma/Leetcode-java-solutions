package arrays_and_String_9;
import java.util.*;

public class Transpose_Of_Matrix_With_Dimension_M_X_N_17 {

  // ~~~~~~~~~~~~~User Section~~~~~~~~~~~~~
  public static int[][] transpose(int[][] matrix) {
	  int n = matrix.length;// row
	  int m = matrix[0].length;// col
	  int[][] res = new int[m][n];
	  
	  for(int i = 0; i < m; i++) {
		  for(int j = 0; j < n; j++) {
			  res[i][j] = matrix[j][i];
		  }
	  }
	  
	  return res;
  }


  // ~~~~~~~~~~~Input Management~~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int m = scn.nextInt();

    int[][] matrix = new int[n][m];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        matrix[i][j] = scn.nextInt();
      }
    }

    int[][] res = transpose(matrix);

    for (int i = 0; i < res.length; i++) {
      for (int j = 0; j < res[0].length; j++) {
        System.out.print(res[i][j] + " ");
      }
      System.out.println();
    }
  }
}