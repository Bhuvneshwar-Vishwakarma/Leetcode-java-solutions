package graphs_4;
import java.io.*;
import java.util.*;

/*You are given a graph with N nodes and M directed edges. Find the number of Strongly connected components in the graph.*/
public class Kosaraju_Algorithm_5 {
	
	
	public static void main(String[] args) throws Exception {
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	      String[] str = br.readLine().split(" ");
	      int vtces = Integer.parseInt(str[0]);
	      int edges = Integer.parseInt(str[1]);
	      
	      ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	      for (int i = 0; i < vtces; i++) {
	    	  graph.add(new ArrayList<>());
	      }

	      for (int i = 0; i < edges; i++) {
	         str = br.readLine().split(" ");
	         int u = Integer.parseInt(str[0]) - 1;
	         int v = Integer.parseInt(str[1]) - 1;
	         graph.get(u).add(v);
	      }

	      System.out.println(kosaraju(graph, vtces));
	   }

	
	public static int kosaraju(ArrayList<ArrayList<Integer>> graph, int vtces) {
		
		// dfs and fill stack;
		Stack<Integer> st = new Stack<>();
		boolean[] visited = new boolean[vtces];
		
		for(int v = 0; v < vtces; v++) {
			if(visited[v] == false) {
				dfsAndFillStack(graph, v, visited, st);
			}
		}
		
		ArrayList<ArrayList<Integer>> trnspseGraph = transpose(graph, vtces); 
		
		visited = new boolean[vtces];
		int scc = 0;
		while(st.size() > 0) {
			int v = st.pop();
			if(visited[v] == false) {
				dfsAndCountSCC(trnspseGraph, v, visited);
				scc++;
			}
		}
		
		return scc;
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
	public static void dfsAndCountSCC(ArrayList<ArrayList<Integer>> graph, int src, boolean[] visited) {
		visited[src] = true;
		
		for(int nbrs: graph.get(src)) {
			if(visited[nbrs] == false) {
				dfsAndCountSCC(graph, nbrs, visited);
			}
		}
	}
	
	public static ArrayList<ArrayList<Integer>> transpose(ArrayList<ArrayList<Integer>> graph, int vtces){
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		
		for(int i = 0; i<vtces; i++) {
			result.add(new ArrayList<>());
		}
		for(int v = 0; v<vtces; v++) {
			for(int nbrs: graph.get(v)) {
				result.get(nbrs).add(v);
			}
		}
		return result;
		
	}

}
