package arrays_and_String_9;
import java.util.*;

public class Transpose_Of_Matrix_With_Dimension_N_X_N_18 {

  // ~~~~~~~~~~~~~User Section~~~~~~~~~~~~~
  public static void transpose(int[][] matrix) {
    for(int i = 0; i < matrix.length; i++) {
    	for(int j = 0; j < i; j++) {
    		int temp = matrix[i][j];
    		matrix[i][j] = matrix[j][i];
    		matrix[j][i] = temp;
    	}
    }
  }

  // ~~~~~~~~~~~Input Management~~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[][] matrix = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        matrix[i][j] = scn.nextInt();
      }
    }
    transpose(matrix);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }
}