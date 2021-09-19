package searching_and_Sorting_10;
import java.util.*;
import java.io.*;

public class Chocolate_Distribution_19 {

  public static int find(int[]arr, int n, int m) {

	  int ans = Integer.MAX_VALUE;
	  Arrays.sort(arr);
	  
	  for(int i = 0; i <= n - m; i++) {
		  int min = arr[i];
		  int max = arr[i + m - 1];
		  int gap = max - min;
		  ans = Math.min(ans, gap);
	  }
    return ans;
  }

  public static void main(String[]args) {
    Scanner scn = new Scanner(System.in);
    //input work
    int n = scn.nextInt();
    int[]arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    int m = scn.nextInt();
    int ans = find(arr, n, m);

    System.out.println(ans);
  }
}