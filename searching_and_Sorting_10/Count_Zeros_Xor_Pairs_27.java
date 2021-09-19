package searching_and_Sorting_10;
import java.util.*;
import java.io.*;

public class Count_Zeros_Xor_Pairs_27 {
  public static int countPairs(int[]arr) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < arr.length; i++) {
    	map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
    }
    int count = 0;
    
    for(int key: map.keySet()) {
    	int val = map.get(key);
    	count += ((val - 1) * val)/2;// sum of first natural n - 1 number
    }
    
    return count;
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[]arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    System.out.println(countPairs(arr));
  }
}