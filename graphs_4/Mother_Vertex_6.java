package graphs_4;
import java.io.*;
import java.util.*;

public class Mother_Vertex_6{
    	public static void main(String args[]) throws Exception {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String[] st = br.readLine().split(" ");
			int vtces = Integer.parseInt(st[0]);
			int edge = Integer.parseInt(st[1]);
	
			ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
			for (int i = 0; i < vtces; i++) {
				graph.add(new ArrayList<>());
			}
	
			for (int i = 0; i < edge; i++) {
				st = br.readLine().split(" ");
				int u = Integer.parseInt(st[0]) - 1;
				int v = Integer.parseInt(st[1]) - 1;
				graph.get(u).add(v);
			}

			System.out.println(findMotherVertex(graph, vtces));
    	}
    	static int count;
	    public static int findMotherVertex(ArrayList<ArrayList<Integer>> graph, int vtces){
	    	Stack<Integer> st = new Stack<>();
	    	boolean[] visited = new boolean[vtces];
	    	
	    	for(int v = 0; v < vtces; v++) {
	    		if(visited[v] == false) {
	    			dfsAndFillStack(graph, v, visited, st);
	    		}
	    	}
	    	
	    	int ans = st.pop();
	    	visited = new boolean[vtces];
	    	count = 0;
	    	dfsAndCount(graph, ans, visited);
	    	
	    	if(count == vtces) {
	    		return ans + 1;
	    	}else {
	    		return -1;
	    	}
	    }
	    
	    public static void dfsAndFillStack(ArrayList<ArrayList<Integer>> graph, int src, boolean[] visited, Stack<Integer> st) {
	    	visited[src] = true;
	    	
	    	for(int nbrs: graph.get(src)) {
	    		if(visited[nbrs] == false) {
	    			dfsAndFillStack(graph, nbrs, visited, st);
	    		}
	    	}
	    	st.push(src);
	    }
	    public static void dfsAndCount(ArrayList<ArrayList<Integer>> graph, int src, boolean[] visited) {
	    	visited[src] = true;
	    	count++;
	    	
	    	for(int nbrs: graph.get(src)) {
	    		if(visited[nbrs] == false) {
	    			dfsAndCount(graph, nbrs, visited);
	    		}
	    	}
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
}