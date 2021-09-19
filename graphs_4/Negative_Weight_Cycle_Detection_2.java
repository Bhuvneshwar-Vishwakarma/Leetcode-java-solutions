 package graphs_4;
import java.io.*;
/*
 * You are given 2 integers N and M , N is the number of vertices, M is the number of edges. You'll also be given ai, bi and wi where ai and bi represents an edge from a vertex ai to a vertex bi and wi respresents the weight of that edge.

Task is to find if it contains a negative weight cycle or not.*/
import java.util.Arrays;

public class Negative_Weight_Cycle_Detection_2{
   	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]);//vertexes
		int m = Integer.parseInt(st[1]);//edges

		int[][] edges = new int[m][3];
		
		for (int i = 0; i < m; i++) {
			st = br.readLine().split(" ");
			edges[i][0] = Integer.parseInt(st[0]);
			edges[i][1] = Integer.parseInt(st[1]);
			edges[i][2] = Integer.parseInt(st[2]);
		}
		
		System.out.println(isNegativeWeightCycle(n, edges));

	}
   	
   	public static boolean isNegativeWeightCycle(int vertexes, int[][] edges) {
   		int[] path = new int[vertexes];
		Arrays.fill(path, Integer.MAX_VALUE);
		path[0] = 0;
		
		for(int i = 0; i < vertexes - 1; i++) {
			for(int j = 0; j < edges.length; j++) {
				int u = edges[j][0];
				int v = edges[j][1];
				int wt = edges[j][2];
				
				if(path[u] == Integer.MAX_VALUE) {
					continue;
				}
				if(path[u] + wt < path[v]) {
					path[v] = path[u] + wt;
				}
			}
		}
		
		for(int j = 0; j < edges.length; j++) {
			int u = edges[j][0];
			int v = edges[j][1];
			int wt = edges[j][2];
			
			if(path[u] == Integer.MAX_VALUE) {
				continue;
			}
			if(path[u] + wt < path[v]) {// update ho raha hai to negative weight cycle hai
				return true;
			}
		}
   		
   		
   		return false;
   	}
   
}