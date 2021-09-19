package searching_and_Sorting_10;

import java.util.*;
import java.io.*;

public class Heaters_35 {
	public static class Pair{
		int js = -1;
		int jl = -1;

	}
  public static int findRadius(int[]houses, int[]heaters) {
	  	Arrays.sort(heaters);
	    int ans= 0;
	    
	    for(int i = 0; i < houses.length; i++) {
	    	int key = houses[i];
	    	Pair p = binarySearch(heaters, key);
	    	
	    	int d1 = p.js == -1 ? Integer.MAX_VALUE : key - p.js;
	    	int d2 = p.jl == -1 ? Integer.MAX_VALUE : p.jl - key;
	    	
	    	int minD = Math.min(d1, d2);;
	    	ans = Math.max(ans, minD);
	    	
	    }
	    return ans;
  }
  public static Pair binarySearch(int[] arr, int key) {
	  
	  int lo = 0;
	  int hi = arr.length - 1;
	  Pair p = new Pair();
	  while(lo <= hi) {
		  int mid = (lo + hi) / 2;
		  if(arr[mid] == key) {
			  p.jl = arr[mid];
			  p.js = arr[mid];
			  break;
		  }else if(arr[mid] < key) {
			  p.js = arr[mid];
			  lo = mid + 1;
		  }else {
			  p.jl = arr[mid];
			  hi = mid - 1;
		  }
	  }
	  
	  return p;
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[]houses = new int[n];

    for (int i = 0; i < n; i++) {
      houses[i] = scn.nextInt();
    }

    int m = scn.nextInt();
    int[]heaters = new int[m];

    for (int i = 0; i < m; i++) {
      heaters[i] = scn.nextInt();
    }

    System.out.println(findRadius(houses, heaters));
  }
}