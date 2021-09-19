package graphs_4;

import java.io.*;
import java.util.*;

public class Minimum_Cost_To_Connect_All_Cities_7 {
  static class Edge implements Comparable<Edge> {
    int v;
    int wt;

    Edge(int nbr, int wt) {
      this.v = nbr;
      this.wt = wt;
    }

    @Override
    public int compareTo(Edge o) {
      return this.wt - o.wt;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int vtces = Integer.parseInt(br.readLine());
    ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
    for (int i = 0; i < vtces; i++) {
      graph.add(new ArrayList<>());
    }

    int edges = Integer.parseInt(br.readLine());
    for (int i = 0; i < edges; i++) {
      String[] parts = br.readLine().split(" ");
      int v1 = Integer.parseInt(parts[0]);
      int v2 = Integer.parseInt(parts[1]);
      int wt = Integer.parseInt(parts[2]);
      graph.get(v1).add(new Edge(v2, wt));
      graph.get(v2).add(new Edge(v1, wt));
    }
    int ans = 0;
    
    PriorityQueue<Edge> pq = new PriorityQueue<>();
    boolean[] visited = new boolean[vtces];
    pq.add(new Edge(0, 0));   
    
    while(pq.size() > 0) {
    	Edge rem = pq.remove();
    	if(visited[rem.v] == true) {
    		continue;
    	}
    	visited[rem.v] = true;
    	ans += rem.wt;
    	for(Edge nbr: graph.get(rem.v)) {
    		if(visited[nbr.v] == false) {
    			pq.add(nbr);
    		}
    	}
    }
    System.out.println(ans);

  }

}
