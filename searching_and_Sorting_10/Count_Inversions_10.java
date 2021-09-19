package searching_and_Sorting_10;
import java.util.*;
import java.io.*;

public class Count_Inversions_10 {
	
	public static int[] mergeSort(int[] arr, int lo, int hi) {
		if(lo == hi) {
			int[] ba = new int[1];
			ba[0] = arr[lo];
			return ba;
		}
		int mid = (lo + hi) / 2;
		
		int[] left = mergeSort(arr, lo, mid);
		int[] right = mergeSort(arr, mid + 1, hi);
		
		int[] merged = merge2SortedArrays(left, right);
		
		return merged;
	}
	static int count = 0;
	public static int[] merge2SortedArrays(int[] left, int[] right) {
		int[] ans = new int[left.length + right.length];
		int i = 0;
		int j = 0;
		int k = 0;
		
		while(i < left.length && j < right.length) {
			if(left[i] <= right[j]) {
				ans[k] = left[i];
				i++;
				k++;
			}else {
				// main part ****************************************
				count += (left.length - i);
				ans[k] = right[j];
				//***************************************************
				j++;
				k++;
			}
		}
		while(i < left.length) {
			ans[k] = left[i];
			i++;
			k++;
		}
		while(j < right.length) {
			ans[k] = right[j];
			j++;
			k++;
		}
		return ans;
	}

    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i =0; i < arr.length; i++) {
        	arr[i] = sc.nextInt();
        }
        mergeSort(arr, 0, n - 1);
        System.out.println(count);
    }
}