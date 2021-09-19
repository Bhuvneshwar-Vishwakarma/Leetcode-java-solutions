package dynamic_Programming_3;

import java.util.Scanner;

public class Boolean_Parenthesization_32 {
											// oprator
	public static int solution(String str1, String str2) {
		int n = str1.length();
		
		int[][] tdp = new int[n][n];// true dp
		int[][] fdp = new int[n][n];// false dp
		
		for(int g = 0; g < n; g++) {
			for(int i = 0, j = g; j < n; i++, j++) {
				if(g == 0) {
					char ch = str1.charAt(i);
					
					if(ch == 'T') {
						tdp[i][j] = 1;
						fdp[i][j] = 0;
					}else {
						tdp[i][j] = 0;
						fdp[i][j] = 1;
					}
					
				} else {
					for(int k = i; k < j; k++) {
						char oprtr = str2.charAt(k);
						int ltc = tdp[i][k];// left true count;
						int rtc = tdp[k + 1][j];// right true count;
						int lfc = fdp[i][k];// left false count;
						int rfc = fdp[k + 1][j];// right false count;
						
						if(oprtr == '&') {
							tdp[i][j] += ltc * rtc;
							fdp[i][j] += lfc * rtc + ltc * rfc + lfc * rfc; 
						}else if(oprtr == '|') {
							tdp[i][j] += ltc * rtc + lfc * rtc + ltc * rfc;
							fdp[i][j] += lfc * rfc; 
						}else {// xor
							tdp[i][j] += ltc * rfc + lfc * rtc;
							fdp[i][j] += lfc * rfc + ltc * rtc;
						}
						
					}
				}
			}
		}
		
		
		return tdp[0][n - 1];
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			String s1 = sc.next();
			String s2 = sc.next();
			System.out.println(solution(s1, s2));
		}

	}

}
