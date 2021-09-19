package searching_and_Sorting_10;
import java.util.*;
import java.io.*;

public class Search_A_2d_Matrix_3 {

    /*your task is to complete this function which returns true if target exists in the matrix
    else return false*/
	public static int binarySearchRowSelect(int[][] arr, int target) {
		int lo = 0;
		int hi = arr.length - 1;
		int lc = arr[0].length - 1;
		
		while(lo <= hi) {
			int mid = (lo + hi) / 2;
			
			if(arr[mid][0] <= target && target <= arr[mid][lc]) {
				return mid;
			}else if(arr[mid][0] < target){
				lo = mid + 1;
			}else if(arr[mid][0] > target){
				hi = mid - 1;
			}
		}
		return -1;
	}
	public static boolean binarySearch(int[][] arr,int row, int target) {
		int lo = 0;
		int hi = arr[0].length - 1;
		
		while(lo <= hi) {
			int mid = (lo + hi) / 2;
			
			if(arr[row][mid] == target) {
				return true;
			}else if(arr[row][mid] < target) {
				lo = mid + 1;
			}else {
				hi = mid - 1;
			}
		}
		return false;
	}
    public static boolean search(int[][]matrix,int target) {
       
    	int row = binarySearchRowSelect(matrix, target);
    	if(row == -1) return false;
    	boolean isFound = binarySearch(matrix, row, target);
        return isFound;
    }
    
    
    
    
    
    

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();

        int[][]matrix = new int[m][n];

        for(int i=0; i < m;i++) {
            for(int j=0; j < n;j++) {
                matrix[i][j] = scn.nextInt();
            }
        }

        int target = scn.nextInt();

        boolean isFound = search(matrix,target);
        System.out.println(isFound);

    }
}