package dynamic_Programming_3;
import java.io.*;
import java.util.*;

public class Min_Max_Value_Expression_74 {

	public static int[] solution(String str1, String str2) {
		//write your code here

		return null;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		String str1 = "";
		String str2 = "";
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '+' || ch == '*') {
				str2 += ch;
			} else {
				str1 += ch;
			}
		}
		int[] arr = solution(str1, str2);
		System.out.println("Minimum Value -> " + arr[0]);
		System.out.println("Maximum Value -> " + arr[1]);
	}

}