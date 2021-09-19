package graphs_4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Shortest_Bridge_13 {
	
	 public static int shortestBridge(int[][] A) {
		 LinkedList<Pair> queue = new LinkedList<>();
		 boolean[][] vis = new boolean[A.length][A[0].length];
		 boolean flag = false;
		 
		 for(int i = 0; i < A.length && !flag; i++) {
			 for(int j = 0; j < A[0].length && !flag; j++) {
				 if(A[i][j] == 1) {
					 dfs(i, j, A, queue, vis);
					 flag = true; 	
				 }
			 }
		 }
		 int level = 0;
		 
		 while(queue.size() > 0) {
			 int size = queue.size();
			 
			 while(size-- > 0) {
				 Pair rem = queue.removeFirst();
				 
				 for(int i = 0; i< dir.length; i++) {
					 int r = rem.row + dir[i][0];
					 int c = rem.col + dir[i][1];
					 
					 if(r < 0 || c < 0 || r >= A.length || c >= A[0].length || vis[r][c] == true) {
						continue;
					 }
					 if(A[r][c] == 1) {
						 return level;
					 }
					 queue.addLast(new Pair(r, c));
					 vis[r][c] = true;
				 }
			 }
			 level++;
		 }
		 
		 
		 return -1;
	 }
	 static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	 
	 public static void dfs(int i, int j,int[][] A, LinkedList<Pair> queue, boolean[][] vis) {
		 vis[i][j] = true;
		 queue.addLast(new Pair(i, j));
		 for(int k = 0; k < dir.length; k++) {
			 int r = i + dir[k][0];
			 int c = j + dir[k][1];
			 
			 if(r < 0 || c < 0 || r >= A.length || c >= A[0].length || vis[r][c] == true || A[r][c] == 0) {
				 continue;
			 }
			 dfs(r, c, A, queue, vis);
		 }
	 }

	 
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[][] arr = new int[n][n];

    for (int i = 0; i < n; i++) {
      String[] st = br.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        arr[i][j] = Integer.parseInt(st[j]);
      }
    }

    System.out.println(shortestBridge(arr));

  }
  
  public static class Pair{
	  int row;
	  int col;
	  Pair(int row, int col){
		  this.row = row;
		  this.col = col;
	  }
  }

}
