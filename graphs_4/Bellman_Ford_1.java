 package graphs_4;
import java.io.*;
import java.util.*;
/*
 * You are given 2 integers N and M , N is the number of vertices, M is the number of edges. You'll also be given ai, bi and wi where ai and bi represents an edge from a vertex ai to a vertex bi and wi respresents the weight of that edge.
Your task is to find the shortest path from source vertex (vertex number 1) to all other vertices*/

public class Bellman_Ford_1{
    	public static void main(String args[]) throws Exception {
    		//shortest path in negative weighted graph

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		int vertex = Integer.parseInt(st[0]);//n
		int edge = Integer.parseInt(st[1]);//m

		int[][] arr = new int[edge][3];
		
		for (int i = 0; i < edge; i++) {
			st = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(st[0]) - 1;// u
			arr[i][1] = Integer.parseInt(st[1]) - 1;// v
			arr[i][2] = Integer.parseInt(st[2]);	// wt
		}

		int[] path = new int[vertex];
		Arrays.fill(path, Integer.MAX_VALUE);
		path[0] = 0;
		
		for(int i = 0; i < vertex - 1; i++)  {// v - 1 times
			for(int j = 0; j < edge; j++) {
				int u = arr[j][0];
				int v = arr[j][1];
				int wt = arr[j][2];
				
				if(path[u] == Integer.MAX_VALUE) {
					continue;
				}
				if(path[u] + wt < path[v]) {
					path[v] = path[u] + wt;
				}
			}
		}
		
		for(int i = 1; i < vertex; i++) {
			if(path[i] != Integer.MAX_VALUE) {
				System.out.print(path[i] + " ");
			}else {
				System.out.print("1000000000");
				
			}
		}
		System.out.println();
	}
    
}