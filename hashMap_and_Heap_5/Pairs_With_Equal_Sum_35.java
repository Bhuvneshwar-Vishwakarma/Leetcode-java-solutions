package hashMap_and_Heap_5;
import java.util.*;

public class Pairs_With_Equal_Sum_35 {

    public static boolean solution(int[] arr) {
        // write your code here
    	HashSet<Integer> set = new HashSet<>();
    	for(int i = 0; i< arr.length; i++) {
    		for(int j = i + 1; j < arr.length; j++) {
    			int sum = arr[i] + arr[j];
    			
    			if(set.contains(sum)) {
    				return true;
    			}else {
    				set.add(sum);
    			}
    		}
    	}

        return false;
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }

}
