package dynamic_Programming_3;

import java.util.Scanner;

public class Probability_Of_Knight_In_The_Chessboard_41 {
	
	public static boolean isValid(int ni, int nj, int n) {
		if(ni >= 0 && nj >= 0 && ni < n && nj < n) {
			return true;
		}else {
			return false;
		}
	}

	public static void solution(int r, int c, int n, int k) {
		double[][] curr = new double[n][n];
		double[][] next = new double[n][n];
		
		curr[r][c] = 1;
		
		for(int m = 1; m <= k; m++) {//moves
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					
					int ni = 0;
					int nj = 0;
					
					ni = i - 2;
					nj = j + 1;
					if(isValid(ni, nj, n)) {
						next[ni][nj] += curr[i][j] / 8.0;
					}
					
					ni = i - 1;
					nj = j + 2;
					if(isValid(ni, nj, n)) {
						next[ni][nj] += curr[i][j] / 8.0;
					}
					
					ni = i + 1;
					nj = j + 2;
					if(isValid(ni, nj, n)) {
						next[ni][nj] += curr[i][j] / 8.0;
					}
					
					ni = i + 2;
					nj = j + 1;
					if(isValid(ni, nj, n)) {
						next[ni][nj] += curr[i][j] / 8.0;
					}
					
					ni = i + 2;
					nj = j - 1;
					if(isValid(ni, nj, n)) {
						next[ni][nj] += curr[i][j] / 8.0;
					}
					
					ni = i + 1;
					nj = j - 2;
					if(isValid(ni, nj, n)) {
						next[ni][nj] += curr[i][j] / 8.0;
					}
					
					ni = i - 1;
					nj = j - 2;
					if(isValid(ni, nj, n)) {
						next[ni][nj] += curr[i][j] / 8.0;
					}
					
					ni = i - 2;
					nj = j - 1;
					if(isValid(ni, nj, n)) {
						next[ni][nj] += curr[i][j] / 8.0;
					}	
				}
			}
			curr = next;
			next = new double[n][n];
		}
		double sum = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j<n; j++) {
				sum += curr[i][j];
			}
		}
		System.out.println(sum);
		
	}
	
	public static void main(String[] args) {
		try (Scanner scn = new Scanner(System.in)) {
			int n = scn.nextInt();
			int k = scn.nextInt();
			int r = scn.nextInt();
			int c = scn.nextInt();
			solution(r, c, n, k);
		}

	}

}
