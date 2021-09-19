package hashMap_and_Heap_5;
import java.util.*;

public class Rabbits_In_The_Forest_37 {

    public static int solution(int[] arr) {
        // write your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<arr.length; i++) {
        	map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        
        int ans = 0;
        for(int key: map.keySet()) {
        	int gs = key + 1; // group size
        	int reportees = map.get(key);
        	int ng = (int)Math.ceil(reportees * 1.0 / gs * 1.0);// Number of group
        	ans += ng * gs;
        	
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
		try (Scanner scn = new Scanner(System.in)) {
			int n = scn.nextInt();
			int[] arr = new int[n];
			for(int i = 0 ; i < n; i++){
				arr[i] = scn.nextInt();
			}
			System.out.println(solution(arr));
		}
	}

}
