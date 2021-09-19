package searching_and_Sorting_10;

import java.util.*;
import java.io.*;

public class Facing_The_Sun_28 {
  public static int countBuildings(int[]ht) {
	  
	  int count = 0;
	  int lmax = ht[0];
	  
	  for(int i = 1; i < ht.length; i++) {
		  if(ht[i] > lmax) {
			  count++;
			  lmax = ht[i];
		  }
	  }
    return count;
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[]ht = new int[n];

    for (int i = 0; i < n; i++) {
      ht[i] = scn.nextInt();
    }

    System.out.println(countBuildings(ht));
  }
}