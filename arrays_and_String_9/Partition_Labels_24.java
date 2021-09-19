package arrays_and_String_9;

import java.util.*;

public class Partition_Labels_24 {

  // ~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~
  public static List<Integer> partitionLabels(String s) {
    // write your code here
	  HashMap<Character, Integer> map = new HashMap<>();
	  
	  //1. filling of impact of characters
	  for(int i = 0; i < s.length(); i++) {
		  char ch = s.charAt(i);
		  map.put(ch, i);
	  }
	  
	  // 2. making of result
	  List<Integer> ans = new ArrayList<>();
	  int prev = -1;
	  int max = 0;
	  
	  for(int i = 0; i < s.length(); i++) {
		  char ch = s.charAt(i);
		  max = Math.max(max, map.get(ch));
		  if(i == max) {
			  ans.add(max - prev);
			  prev = max;
		  }
	  }
	  
	  return ans;
  }

  // ~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine();

    List<Integer> res = partitionLabels(str);
    for (int val : res) {
      System.out.print(val + " ");
    }
  }
}