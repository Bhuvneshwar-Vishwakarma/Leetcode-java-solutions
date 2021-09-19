package arrays_and_String_9;

import java.util.Scanner;
public class Min_Len_Of_String_After_Removing_Similar_Ends_45 {
  public static int minLen(String s) {
    int left = 0, right = s.length() - 1;
    
    while(left < right && s.charAt(left) == s.charAt(right)) {
    	char ch = s.charAt(left);
    	
    	while(left < right && ch == s.charAt(left)) {
    		left++;
    	}
    	while(left <= right && ch == s.charAt(right)) {
    		right--;
    	}
    }
    
    return right - left + 1;
  }
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    String inp = scn.nextLine();
    int len = minLen(inp);

    System.out.println(len);
  }
}
