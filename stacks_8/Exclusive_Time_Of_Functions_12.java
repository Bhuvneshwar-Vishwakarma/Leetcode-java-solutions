package stacks_8;
import java.io.*;
import java.util.*;

public class Exclusive_Time_Of_Functions_12 {
	static class Pair{
		int id;
		int st;
		int ct;
	}

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(read.readLine());
        int[] timeF = new int[n];
        int len = Integer.parseInt(read.readLine());
        Stack<Pair> st = new Stack<>();
        
        for(int i = 0; i < len; i++) {
        	String[] log = read.readLine().split(":");//0 id 1 s-e 2 t
        	
        	if(log[1].equals("start")) {
        		Pair p = new Pair();
        		p.id = Integer.parseInt(log[0]);// id
        		p.st = Integer.parseInt(log[2]);// start time
        		p.ct = 0;// child function time
        		st.push(p);
        	}else {// end
        		Pair p = st.pop();
        							//start time        //pop start time
        		int interval = Integer.parseInt(log[2]) - p.st + 1;
        		int time = interval - p.ct;
        		timeF[p.id] += time;
        		
        		if(st.size() > 0) {
        			st.peek().ct += interval;
        		}
        	}
        }
        
        for(int e: timeF) {
        	System.out.println(e);
        }
    }
}
