package codeforces;

//package bit_Manipulation_2;
import java.io.*;
import java.util.*;
//import java.io.DataInputStream;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Scanner;
//import java.util.StringTokenizer;

public class One_1 {
	

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n < 1) {
			return;
		}
		while(n > 0) {
			String str = sc.next();
			int l = str.length();
			if(l < 10) {
				System.out.println(str);
			}else {
				solution(str, n);
			}
			n--;
		}

	}
	private static void solution(String str, int n) {

				char fch = str.charAt(0);
				char lch = str.charAt(str.length() - 1);
				String bch = (str.length() - 2) + "";
				String ans = fch + bch + lch;
				System.out.println(ans);
	}
}
