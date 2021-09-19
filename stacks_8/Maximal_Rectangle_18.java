package stacks_8;
import java.io.*;
import java.util.*;

public class Maximal_Rectangle_18 {
	public static int largestRectangleArea(int[] heights) {
    	int maxArea = 0;
    	Stack<Integer> st = new Stack<>();
    	st.push(-1);
    	for(int i = 0; i <= heights.length; i++) {
    		int val = i == heights.length ? 0 : heights[i];
    		
    		while(st.peek() != -1 && heights[st.peek()] >= val) {
    			int rm = i; // right min
    			int h = heights[st.pop()];
    			int lm = st.peek();// left min
    			maxArea = Math.max(maxArea, h * (rm - lm - 1));
    		}
    		st.push(i);
    	}
        return maxArea;
    }

    public static int maximalRectangle(int[][] arr) {  
    	int[] heights = new int[arr[0].length];
    	
    	for(int i = 0; i < arr[0].length; i++) {
    		heights[i] = arr[0][i];
    	}
    	int area = largestRectangleArea(heights);
    	
    	for(int i = 1; i < arr.length; i++) {
    		for(int j = 0; j < arr[0].length; j++) {
    			if(arr[i][j] == 1) {
    				heights[j]++;
    			}else {
    				heights[j] = 0;
    			}
    		}
    		area = Math.max(area, largestRectangleArea(heights));
    	}
    	
        return area;
    }

    public static void main(String[] args) throws Exception {
    	BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int row = Integer.parseInt(read.readLine());
        int col = Integer.parseInt(read.readLine());
        
        int bmat[][] = new int[row][col];

        for(int i=0;i<row;i++){
            String s = read.readLine();
            for(int j=0;j<col;j++){
                bmat[i][j] = s.charAt(j)-'0';
            }
        }

        int result = maximalRectangle(bmat);
        System.out.println(result);
        
    }
}
