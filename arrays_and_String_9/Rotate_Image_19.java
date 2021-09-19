package arrays_and_String_9;
import java.util.*;

public class Rotate_Image_19 {

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
	 public static void reverseRow(int[][] arr) {
		 for(int r = 0; r < arr.length; r++) {
			 int left = 0;
			 int right = arr.length - 1;
			 
			 while(left < right) {
				 int temp = arr[r][left];
				 arr[r][left] = arr[r][right];
				 arr[r][right] = temp;
				 
				 left++;
				 right--;
			 } 
		 }
	 }
  public static void rotate(int[][] matrix) {
    transpose(matrix);
    reverseRow(matrix);
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
    rotate(matrix);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }
}