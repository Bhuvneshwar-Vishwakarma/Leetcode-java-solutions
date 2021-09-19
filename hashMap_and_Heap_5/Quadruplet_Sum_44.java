 package hashMap_and_Heap_5;
import java.util.*;
/*1. You are given an array(arr) of N integers and an integer X.
2. You have to find all unique quadruplets(a,b,c,d) which satisfies this condition - 
   a+b+c+d = X.*/

/*https://youtu.be/Wj79ILvJ3Qc*/
public class Quadruplet_Sum_44 {
	
	public static void createRes(ArrayList<ArrayList<Integer>> res, ArrayList<ArrayList<Integer>> smallAns, int val) {
		
		for(ArrayList<Integer> sa: smallAns) {
			sa.add(0, val);
			res.add(sa);
		}
	}
	
    public static ArrayList<ArrayList<Integer>> twoSum(int[] arr, int target, int si, int ei) {
		// write your code here
    	ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    	
    	while(si < ei) {
    		int sum = arr[si] + arr[ei];
    		
    		if(sum > target) {
    			ei--;
    		}else if(sum < target) {
    			si++;
    		}else {
    			res.add(new ArrayList<Integer>(Arrays.asList(arr[si], arr[ei])));
    			si++;
    			ei--;
    			while(si < ei && arr[si] == arr[si - 1]) si++;
    			while(si < ei && arr[ei] == arr[ei + 1]) ei--;;
    		}
    	}
		return res;
	}
    public static ArrayList<ArrayList<Integer>> threeSum(int[] arr, int target, int si, int ei) {
    	// write your code here
    	
    	ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    	for(int i = si; i <= ei; i++) {
    		if(i != si && arr[i] == arr[i - 1]) continue;
    		
    		ArrayList<ArrayList<Integer>> smallAns = twoSum(arr, target - arr[i], i + 1, ei);
    		createRes(res, smallAns, arr[i]);
    	}
    	
    	return res;
    }
    public static ArrayList<ArrayList<Integer>> fourSum(int[] arr, int target, int n) {
    	// write your code here
    	Arrays.sort(arr);
    	
    	ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    	int si = 0;
    	int ei = n - 1;
    	for(int i = si; i <= ei; i++) {
    		if(i != si && arr[i] == arr[i - 1]) continue;
    		
    		ArrayList<ArrayList<Integer>> smallAns = threeSum(arr, target - arr[i], i + 1, ei);
    		createRes(res, smallAns, arr[i]);
    	}
    	
    	return res;
    }
    
    /* Time Complexity
     * twoSum -> n
     * threeSum -> n^2
     * fourSum -> n^2 * n => n^3 + t
     * */

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			int target = sc.nextInt();
			ArrayList<ArrayList<Integer>> ans = fourSum(arr, target, n);
			Collections.sort(ans,(a,b)->{
			    int i = 0;
			    int j = 0;
			    
			    while(i < a.size()){
			        if(a.get(i) == b.get(j)){
			            i++;
			            j++;
			        }else{
			            return a.get(i) - b.get(j);
			        }
			    }
			    
			    return 0;
			}); 
			for (ArrayList<Integer> a : ans) {
				for (int element : a) {
					System.out.print(element + " ");
				}
				System.out.println();
			}
		}
	}

}
