package arrays_and_String_9;
import java.util.*;

public class Best_Meeting_Point_15 {

    // ~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~
    public static int minTotalDistance(int[][] grid) {
    	ArrayList<Integer> xcord = new ArrayList<>();// x coordinate
        // 1: get x-coordinate -> row wise
    	for(int r = 0; r < grid.length; r++) {
    		for(int c = 0; c < grid[0].length; c++) {
    			if(grid[r][c] == 1) {
    				xcord.add(r);
    			}
    		}
    	}
    	// 2: get y-coordinate -> column wise
    	ArrayList<Integer> ycord = new ArrayList<>();// y coordinate
    	for(int c = 0; c < grid[0].length; c++) {
    		for(int r = 0; r < grid.length; r++) {
    			if(grid[r][c] == 1) {
    				ycord.add(c);
    			}
    		}
    	}
    	//3: get mid -> best meeting point
    	int x = xcord.get(xcord.size() / 2);
    	int y = ycord.get(ycord.size() / 2);
    	
    	
    	//4: calculate distance -> min distance(because of median)
    	int dist = 0;
    	for(int xval: xcord) {
    		dist += Math.abs(x - xval);
    	}
    	for(int yval: ycord) {
    		dist += Math.abs(y - yval);
    	}
    	
    	return dist;
    }

    // ~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();


        int[][] grid = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                grid[i][j] = scn.nextInt();
            }
        }

        int dist = minTotalDistance(grid);
        System.out.println(dist);
    }
}