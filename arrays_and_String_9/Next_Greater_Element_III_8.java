package arrays_and_String_9;

import java.util.*;
/*1. Given a positive number 'n' in form of String.
2. Find the smallest number which has exactly the same digits existing in the number 'n' and is greater in value than 'n'.
3. If no such positive number exists, return -1 as string.*/
public class Next_Greater_Element_III_8 {
    
    //~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~
    public static String nextGreaterElement(String str) {
    	char[] arr = str.toCharArray();
    	
    	//1. find first dip
        int i = arr.length - 2;
        while(i >= 0 && arr[i] >= arr[i + 1]) {
        	i--;
        }
        if(i == -1) {
        	return "-1";
        }
        
        // find just greater that ith index element
        int j = arr.length - 1;
        while(arr[i] >= arr[j]) {
        	j--;
        }
        //swap from i and k
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        
        // concatenate from 0 to i index
        StringBuilder res = new StringBuilder();
        for(int k = 0; k <= i; k++) {
        	res.append(arr[k]);
        }
        // concatenate from j to i + 1 index(reverse order)
        for(int k = arr.length - 1; k > i; k--) {
        	res.append(arr[k]);
        }
        
        return res.toString();
       
    }

    //~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String num = scn.next();
        String res = nextGreaterElement(num);

        System.out.println(res);
    }
}