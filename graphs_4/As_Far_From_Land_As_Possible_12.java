 package graphs_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class As_Far_From_Land_As_Possible_12 {
	
	public static int maxDistance(int[][] arr) {
		LinkedList<Pair> queue = new LinkedList<>();
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				if(arr[i][j] == 1) {
					queue.addLast(new Pair(i, j));
				}
			}
		}
		if(queue.size() == 0 || queue.size() == arr.length*arr[0].length) {
			return -1;
		}
		int level = -1;
		int[][] dir = {{-1, 0},{0, 1},{1, 0},{0, -1}};
		
		while(queue.size() > 0) {
			int size = queue.size();
			level++;
			while(size-- > 0 ) {
				Pair rem = queue.removeFirst();
				for(int i = 0; i < dir.length; i++) {
					int r = rem.row + dir[i][0];
					int c = rem.col + dir[i][1];
					
					if(r >= 0 && c >= 0 && r < arr.length && c < arr[0].length && arr[r][c] == 0) {
						queue.addLast(new Pair(r, c));
						arr[r][c] = 1;
					}
				}
			}
		}
		
		return level;
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

    System.out.println(maxDistance(arr));

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
