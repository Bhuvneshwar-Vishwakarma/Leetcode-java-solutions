package searching_and_Sorting_10;
import java.util.*;
import java.io.*;

public class First_Bad_Version_31 {

  public static int firstBadVersion(int n) {
    int fbv = -1;
    int lo = 1;
    int hi = n;
    
    while(lo <= hi) {
    	int mid = lo + (hi - lo) / 2;
    	
    	if(isBadVersion(mid)) {
    		fbv = mid;
    		hi = mid - 1;
    	}else {
    		lo = mid + 1;
    	}
    	
    }
    return fbv;
  }

  static int bad = 0;
  public static boolean isBadVersion(int val) {
    if (val >= bad) {
      return true;
    }
    else {
      return false;
    }
  }

  public static void solve(int n, int fbv) {
    bad = fbv;
    System.out.println(firstBadVersion(n));
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int fbv = scn.nextInt();

    solve(n, fbv);
  }
}