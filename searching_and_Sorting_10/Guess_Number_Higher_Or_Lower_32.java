package searching_and_Sorting_10;
import java.util.*;
import java.io.*;

public class Guess_Number_Higher_Or_Lower_32 {

  public static int guessNumber(int n) {
	  int lo = 1;
	  int hi = n;
	  
	  while(lo <= hi) { 
		  int mid = lo + (hi - lo) / 2;
		  if(guess(mid) == 0) {
			  // mid == pick
			  return mid;
		  }else if(guess(mid) == -1) {
			  // pick < mid
			  hi = mid - 1;
		  }else if(guess(mid) == 1) {
			  // pick > mid
			  lo = mid + 1;
		  }
	  }
	  
    return -1;
  }

  static int pn = 0; //picked number
  public static int guess(int val) {
    if (val == pn) {
      return 0;
    }
    else if (val < pn) {
      return 1;
    }
    else {
      return -1;
    }
  }

  public static void solve(int n, int pick) {
    pn = pick;
    System.out.println(guessNumber(n));
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int pick = scn.nextInt();

    solve(n, pick);
  }
}