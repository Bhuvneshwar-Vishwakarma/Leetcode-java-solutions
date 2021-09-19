package searching_and_Sorting_10;
import java.util.*;
import java.io.*;

public class Maximum_Number_Of_1s_Row_34 {

  public static int findRow(int[][]mat) {
    int r = 0;
    int omax = 0;
    for(int i = 0; i < mat.length; i++) {
    	int coir = binarySearch(mat, i);
    	if(coir > omax) {
    		omax = coir;
    		r = i;
    	}
    }
    return r;
  }
  public static int binarySearch(int[][] arr, int r) {
	  int lo = 0;
	  int hi = arr[0].length - 1;
	  int fi1 = arr[0].length;
	  
	  while(lo <= hi) {
		  int mid = (lo + hi) / 2;
		  if(arr[r][mid] == 1) {
			  fi1 = mid;
			  hi = mid - 1;
		  }else {
			  lo = mid + 1;
		  }
	  }
	  int count = arr[0].length - fi1;
	  return count;
  }

  public static void main(String[]args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int m = scn.nextInt();

    int[][]mat = new int[n][m];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        mat[i][j] = scn.nextInt();
      }
    }

    System.out.println(findRow(mat));
  }
}