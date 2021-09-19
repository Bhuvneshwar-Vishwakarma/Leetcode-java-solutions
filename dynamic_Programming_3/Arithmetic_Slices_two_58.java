package dynamic_Programming_3;
import java.io.*;
import java.util.*;

public class Arithmetic_Slices_two_58 {

	public static int solution(int[] arr) {
		
		HashMap<Integer, Integer>[] maps = new HashMap[arr.length];
		int ans = 0;
		for(int i = 0; i < arr.length; i++) {
			maps[i] = new HashMap<>();
		}
		
		for(int i = 0; i < maps.length; i++) {
			for(int j = 0; j < i; j++) {
				long cd = (long)arr[i] - (long)arr[j];// curr diff
				if(cd <= Integer.MIN_VALUE || cd >= Integer.MAX_VALUE) {
					continue;
				}
				int apsEndingOnJ = maps[j].getOrDefault((int)cd, 0);
				int apsEndingOnI = maps[i].getOrDefault((int)cd, 0);
				
				ans += apsEndingOnJ;
				maps[i].put((int)cd, apsEndingOnI + apsEndingOnJ + 1);
			}
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));
	}

}