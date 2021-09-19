package dynamic_Programming_3;
import java.io.*;
import java.util.*;

public class Minimum_Delta_In_Partitions_68 {
	
	public static int solution(int[] arr, int sum) {
		//write your code here

		return 0;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		int sum = 0;
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
			sum += arr[i];
		}
		System.out.println(solution(arr,sum));
	}

}