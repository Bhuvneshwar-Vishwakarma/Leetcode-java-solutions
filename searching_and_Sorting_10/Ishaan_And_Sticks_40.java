package searching_and_Sorting_10;

import java.util.*;
import java.io.*;

public class Ishaan_And_Sticks_40 {

  public static ArrayList<Integer>  solve(int[]arr) {
	  HashMap<Integer, Integer> map = new HashMap<>();
	  for(int val: arr) {
		  map.put(val, map.getOrDefault(val, 0) + 1);
	  }
	  ArrayList<Integer> ans = new ArrayList<>();
	  
	  int maxArea = 0;
	  int sq = 0;
	  
	  for(int key: map.keySet()) {
		  int freq = map.get(key);
		  
		  if(freq >= 4) {
			  int area = key * key;
			  if(area > maxArea) {
				  maxArea = area;
				  sq = freq / 4;
			  }
		  }
	  }
	  if(maxArea == 0) {
		  ans.add(-1);
	  }else {
		  ans.add(maxArea);
		  ans.add(sq);
	  }
	  
	  return ans;

  }

  public static void main(String[]args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[]arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    ArrayList<Integer>ans = solve(arr);

    for (int val : ans) {
      System.out.print(val + " ");
    }
  }
}