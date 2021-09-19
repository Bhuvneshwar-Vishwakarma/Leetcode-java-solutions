package stacks_8;
import java.io.*;
import java.util.*;

public class Number_Of_Recent_Calls_28 {
  public static class RecentCounter {
	 private Queue<Integer> que;
	 
    public RecentCounter() {
    	que = new ArrayDeque<>();
    }

    public int ping(int t) {
    	que.add(t);
    	int min = t - 3000;
    	while(que.peek() < min) {
    		que.remove();
    	}
      return que.size();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    RecentCounter obj = new RecentCounter();

    while (read.ready()) {
      int val = Integer.parseInt(read.readLine());
      int ans = obj.ping(val);
      System.out.println(ans);
    }

  }
}