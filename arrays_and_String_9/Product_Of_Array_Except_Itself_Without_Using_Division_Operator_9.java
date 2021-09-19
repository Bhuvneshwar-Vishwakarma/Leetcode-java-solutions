package arrays_and_String_9;
import java.util.*;

public class Product_Of_Array_Except_Itself_Without_Using_Division_Operator_9 {
    
    //~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~
    public static int[] productExceptSelf(int[] arr) {
        int[] ans = new int[arr.length];
    	int[] right = new int[arr.length];
        int prod = 1; // product
        for(int i = arr.length - 1; i >= 0; i--) {
        	prod *= arr[i];
        	right[i] = prod;
        }
        
        int leftProd = 1;
        for(int i = 0; i < arr.length - 1; i++) {
        	ans[i] = leftProd * right[i + 1];
        	
        	leftProd *= arr[i];
        	
        }
        ans[arr.length - 1] = leftProd;
    	return ans;
    }

    //~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int[] res = productExceptSelf(arr);
        for(int i = 0; i < arr.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}