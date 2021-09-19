package stacks_8;
import java.io.*;
import java.util.*;

public class Asteroid_Collision_14 {

  public static int[] asteroidCollision(int[] asteroids) {
    /*1. You are given an array asteroids of integers representing asteroids in a row.
2. For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left).
3. Each asteroid moves at the same speed.
4. You need to find out the state of the asteroids after all collisions.
5. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.*/
	  
	  Stack<Integer> st = new Stack<>();
	  for(int val: asteroids) {
		  
		  if(val > 0) {
			  st.push(val);
		  }else {					// positive &&    smaller 
			  while(st.size() > 0 && st.peek() > 0 && st.peek() < Math.abs(val)) {
				  st.pop();
			  }
			  if(st.size() > 0 && st.peek() == Math.abs(val)) {
				  st.pop();
			  }else if(st.size() > 0 && st.peek() > Math.abs(val)) {
				  
			  }else {
				  st.push(val);
			  }
		  }
	  }
	  int[] ans = new int[st.size()];
	  int i = ans.length - 1;
	  while(i >= 0) {
		  ans[i] = st.pop();
		  i--;
	  }
	  return ans;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(read.readLine());
    int arr[] = new int[n];
    for (int i = 0; i < n; i++)arr[i] = Integer.parseInt(read.readLine());
    int result[] = asteroidCollision(arr);

    System.out.println(result.length);
    for (int e : result) {
      System.out.println(e);
    }

  }
}
