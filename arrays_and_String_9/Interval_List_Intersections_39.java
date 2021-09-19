package arrays_and_String_9;
import java.util.*;

public class Interval_List_Intersections_39 {
  public static int[][] intersection(int list1[][], int list2[][]) {
    // write your code here
	  ArrayList<int[]> ans = new ArrayList<>();
	  int ptr1 = 0, ptr2 = 0;
	  
	  while(ptr1 < list1.length && ptr2 < list2.length) {
		  int cSP = Math.max(list1[ptr1][0], list2[ptr2][0]);
		  int cEP = Math.min(list1[ptr1][1], list2[ptr2][1]);
		  
		  if(cSP <= cEP) {
			  int[] interval = {cSP, cEP};
			  ans.add(interval);
		  }
		  if(list1[ptr1][1] < list2[ptr2][1]) {
			  ptr1++;
		  }else {
			  ptr2++;
		  }
	  }
	  return ans.toArray(new int[ans.size()][]);
  }
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    // Input format
    int n = scn.nextInt();
    int list1[][] = new int[n][2];
    for (int i = 0 ; i < n ; i++) {
      list1[i][0] = scn.nextInt();
      list1[i][1] = scn.nextInt();
    }

    int m = scn.nextInt();
    int list2[][] = new int[m][2];
    for (int i = 0 ; i < m ; i++) {
      list2[i][0] = scn.nextInt();
      list2[i][1] = scn.nextInt();
    }

    // output
    int ans[][] = intersection(list1, list2);
    System.out.print("[");
    for (int interval[] : ans) {
      System.out.print(Arrays.toString(interval));
    }
    System.out.println("]");
  }
}
