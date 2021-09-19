package searching_and_Sorting_10;
import java.util.*;
import java.io.*;

public class Find_K_Closest_Elements_6 {

    /*find 'k' closest element to 'x' and return answer list*/
    /*elements in answer list should be in ascending order*/
    public static ArrayList<Integer> findClosest(int[]arr,int k,int x) {
        int mid = binarySearch(arr, x);
        int l = mid - 1;
        int r = mid;
        
        ArrayList<Integer> list = new ArrayList<>();
        while(l >= 0 && r < arr.length && k > 0) {
        	if(Math.abs(arr[l] - x) <= Math.abs(arr[r] - x)) {
        		list.add(arr[l]);
        		l--;
        	}else {
        		list.add(arr[r]);
        		r++;
        	}
        	k--;
        }
        while(k > 0 && l >= 0) {
        	list.add(arr[l]);
        	l--;
        	k--;
        }
        while(k > 0 && r < arr.length) {
        	list.add(arr[r]);
        	r++;
        	k--;
        }

        Collections.sort(list);
        return list;
    }
    public static int binarySearch(int[] arr, int x) {
    	int mid = 0;
    	int lo = 0;
    	int hi = arr.length - 1;
    	while(lo <= hi) {
    		mid = (lo + hi) / 2;
    		
    		if(arr[mid] == x) {
    			break;
    		}else if(arr[mid] < x) {
    			lo = mid + 1;
    		}else {
    			hi = mid - 1;
    		}
    	}
    	
    	return mid;
    }

    public static void main(String[]args) {

        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];

        for(int i=0; i < n;i++) {
            arr[i] = scn.nextInt();
        }

        int k = scn.nextInt();
        int x = scn.nextInt();

        ArrayList<Integer>ans = findClosest(arr,k,x);

        for(int val : ans) {
            System.out.print(val + " ");
        }

    }
}
