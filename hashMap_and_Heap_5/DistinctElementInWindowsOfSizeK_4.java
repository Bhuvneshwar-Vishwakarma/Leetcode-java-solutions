package hashMap_and_Heap_5;

import java.util.*;

public class DistinctElementInWindowsOfSizeK_4 {
	
	public static ArrayList<Integer> solution(int[] arr, int k){
		ArrayList<Integer> list = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < k - 1; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		for(int j = 0, i = k - 1; i < arr.length; i++, j++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1); // Aquire
			
			list.add(map.size());
			
			int freq = map.get(arr[j]);
			
			if(freq == 1) {
				map.remove(arr[j]);
			}else {
				map.put(arr[j], freq - 1);
			}
		}
		
		return list;
	}

	public static void main(String[] args) {// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		ArrayList<Integer> ans = solution(arr,k);
		for(int a : ans){
			System.out.print(a + " ");
		}
	}

}
