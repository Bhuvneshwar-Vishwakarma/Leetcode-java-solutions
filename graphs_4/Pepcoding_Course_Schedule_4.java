package graphs_4;
import java.io.*;
import java.util.*;

public class Pepcoding_Course_Schedule_4 {
	
	public static int[] findOrder(int n, ArrayList<ArrayList<Integer>> graph) {
		int[] indegree = new int[n];
		int[] ans = new int[n];
		
		for(int i = 0; i < n; i++) {
			for(int nbrs: graph.get(i)) {
				indegree[nbrs]++;
			}
		}
		LinkedList<Integer> queue = new LinkedList<>();
		for(int i = 0; i < n; i++) {
			if(indegree[i] == 0) {
				queue.addLast(i);
			}
		}
		int idx = 0;
		while(queue.size() > 0) {
			int rem = queue.removeFirst();
			
			ans[idx] = rem;
			idx++;
			
			for(int nbrs: graph.get(rem)) {
				indegree[nbrs]--;
				if(indegree[nbrs] == 0) {
					queue.addLast(nbrs);
				}
			}
		}
		if(idx == n) {
			return ans;
		}else {
			return new int[]{-1};
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
        
	}
}
