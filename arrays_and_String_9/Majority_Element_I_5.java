 package arrays_and_String_9;
import java.util.*;

public class Majority_Element_I_5 {

    // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~
	public static int getValidateElement(int[] arr) {
		int val = arr[0];
		int count = 1;
		
		for(int i = 1; i < arr.length; i++){
			if(val == arr[i]) {
				count++;
			}else {
				count--;
			}
			
			if(count == 0) {
				val = arr[i];
				count = 1;
			}
		}
		return val;
	}

    public static void printMajorityElement(int[] arr) {
        int val = getValidateElement(arr);
        int count = 0;
        for(int ele: arr) {
        	if(val == ele) {
        		count++;
        	}
        }
        
        if(count > arr.length / 2) {
        	System.out.println(val);
        }else {
        	System.out.println("No Majority Element exist");
        }
    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        printMajorityElement(arr);
    }
}