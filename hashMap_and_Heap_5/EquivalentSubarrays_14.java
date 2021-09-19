 package hashMap_and_Heap_5;
/*1. You are given an array of integers(arr).
2. You have to find the count of equivalent subarrays.
3. A subarray is equivalent if,
   count of unique integers in the subarray = count of unique integers in the given array.*/
import java.util.*;

public class EquivalentSubarrays_14 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 0 ; i  < n; i++){
            arr[i] = scn.nextInt();
            set.add(arr[i]);
        }
		//write your code here
        int ans = 0;
        int k = set.size();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        
        int i = -1;
        int j = -1;
        
        while(true) {
        	boolean f1 = false;
        	boolean f2 = false;
        	
        	//acquire
        	while(i < arr.length - 1) {
        		f1 = true;
        		i++;
        		map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        		
        		if(map.size() == k) {
        			ans += arr.length - i;
        			break;
        		}
        	}
        	while(j < i) {
        		f2 = true;
        		j++;
        		if(map.get(arr[j]) == 1) {
        			map.remove(arr[j]);
        		}else {
        			map.put(arr[j], map.get(arr[j]) - 1);
        		}
        		
        		if(map.size() == k) {
        			ans += arr.length - i;
        		}else {
        			break;
        		}
        		
        	}
        	
        	
        	
        	
        	if(f1 == false && f2 == false) {
        		break;
        	}
        }
        System.out.println(ans);
		
	}


}
