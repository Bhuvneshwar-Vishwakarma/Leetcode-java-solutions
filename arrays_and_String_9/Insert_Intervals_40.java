package arrays_and_String_9;
import java.util.*;

public class Insert_Intervals_40 {

  public static int[][] insertIntervals(int intervalList[][], int newInterval[]) {
	  ArrayList<int[]> ans = new ArrayList<>();
	  
	  // 1. add in list as it as jo choote hai
	  int idx = 0;
	  
	  while(idx < intervalList.length) {
		  if(intervalList[idx][0] < newInterval[0]) {
			  ans.add(intervalList[idx]);
			  idx++;
		  }else {
			  break;
		  }
	  }
	  
	  // 2. merging jaha usse badi value aai hai
	  if(ans.size() == 0 || (newInterval[0] > ans.get(ans.size() - 1)[1])) {
		  ans.add(newInterval);
	  }else {
		  int[] lastInterval = ans.get(ans.size() - 1);
		  lastInterval[1] = Math.max(lastInterval[1], newInterval[1]); 
	  }
	  
	  // 3. baki bachi list me merging
	  while(idx < intervalList.length) {
		  int[] lastInterval = ans.get(ans.size() - 1);
		  if(lastInterval[1] >= intervalList[idx][0]) {
			  // merging
			  lastInterval[1] = Math.max(lastInterval[1], intervalList[idx][1]);
		  }else {
			  ans.add(intervalList[idx]);
		  }
		  idx++;
	  }
	
	  return ans.toArray(new int[ans.size()][]);
	  
	  
  }
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int intervalList[][] = new int[n][2];
    for (int i = 0 ; i < n ; i++) {
      int st = scn.nextInt();
      int et = scn.nextInt();

      intervalList[i][0] = st;
      intervalList[i][1] = et;
    }
    int newInterval[] = new int[2];
    newInterval[0] = scn.nextInt();
    newInterval[1] = scn.nextInt();

    int ans[][] = insertIntervals(intervalList, newInterval);

    System.out.print("[");
    for (int interval[] : ans) {
      System.out.print(Arrays.toString(interval));
    }
    System.out.println("]");

  }
}