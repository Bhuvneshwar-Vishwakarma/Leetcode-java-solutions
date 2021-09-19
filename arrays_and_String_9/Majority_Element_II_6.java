package arrays_and_String_9;

import java.util.*;

public class Majority_Element_II_6 {

    // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~
	public static boolean isGreaterThanNb3(int[] arr, int val) {
		int count = 0;
		for(int ele: arr) {
			if(ele == val) {
				count++;
			}
		}
		return count > arr.length / 3;
	}
    public static ArrayList<Integer> majorityElement2(int[] arr) {
    	int val1 = arr[0];
    	int count1 = 1;
    	
    	int val2 = arr[0];
    	int count2 = 0;
    	
    	for(int ele: arr) {
    		if(val1 == ele) {
    			count1++;
    		}else if(val2 == ele) {
    			count2++;
    		}else {
    			if(count1 == 0) {
    				val1 = ele;
    				count1 = 1;
    			}else if(count2 == 0) {
    				val2 = ele;
    				count2 = 1;
    			}else {
    				count1--;
    				count2--;
    			}
    		}
    	}
    	ArrayList<Integer> ans = new ArrayList<>();
    	if(isGreaterThanNb3(arr, val1) == true) {
    		ans.add(val1);
    	}
    	if(isGreaterThanNb3(arr, val2) == true) {
    		ans.add(val2);
    	}
    	return ans;
    
    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        ArrayList<Integer> res = majorityElement2(arr);
        System.out.println(res);
    }
}