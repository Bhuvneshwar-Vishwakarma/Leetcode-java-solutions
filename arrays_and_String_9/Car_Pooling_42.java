package arrays_and_String_9;
import java.util.Scanner;

public class Car_Pooling_42 {
  public static boolean carPooling(int trips[][], int cap) {
    // write your code here
	  int lastDropLocation = -1;
	  for(int[] trip: trips) {
		  lastDropLocation = Math.max(trip[1], lastDropLocation);
	  }
	  int[] highway = new int[lastDropLocation + 1];
	  
	  for(int[] trip: trips) {
		  highway[trip[0]] += trip[2];// yah chad gaye log
		  highway[trip[1]] -= trip[2];// yah drop ho gaye
	  }
	  //make cumulative sum
	  for(int i = 1; i < lastDropLocation; i++) {
		  highway[i] += highway[i - 1];
		  if(highway[i] > cap) {
			  return false;
		  }
	  }
	  
	  return true;
  }
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int trips[][] = new int[n][3];
    for (int i = 0 ; i < n ; i++) {
      trips[i][0] = scn.nextInt();
      trips[i][1] = scn.nextInt();
      trips[i][2] = scn.nextInt();
    }
    int cap = scn.nextInt();

    if (carPooling(trips, cap)) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }

  }
}
