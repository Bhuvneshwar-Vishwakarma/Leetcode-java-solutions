package stacks_8;

import java.io.*;
import java.util.*;

public class Moving_Average_From_Data_Stream_29 {
  public static class MovingAverage {
	  
	  private Queue<Integer> que;
	  private final int size;
	  static int sum;
	  
    public MovingAverage(int size) {
    	this.size = size;
    	que = new ArrayDeque<>();
    	sum = 0;
    }

    public double next(int val) {
    	sum += val;
    	
    	if(que.size() > size) {
    		sum -= que.remove();
    	}
    	double avg = ((double)sum)/que.size();
    	return avg;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    int size = Integer.parseInt(read.readLine());
    MovingAverage obj = new MovingAverage(size);
    PrintWriter out = new PrintWriter(System.out);
    while (read.ready()) {
      int val = Integer.parseInt(read.readLine());
      double avg = obj.next(val);

      StringBuilder ans = new StringBuilder(String.format("%.5f", avg));
      while (ans.charAt(ans.length() - 2) != '.' && ans.charAt(ans.length() - 1) == '0') {
        ans.deleteCharAt(ans.length() - 1);
      }
      out.println(ans);
    }
    out.close();
  }
}
