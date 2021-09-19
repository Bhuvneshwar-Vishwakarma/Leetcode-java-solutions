package dynamic_Programming_3;
import java.util.Scanner;

public class Minimum_Deletions_To_Make_Sorted_Array_73{
    public static int minimumDeletionsToSorted(int []arr){
       // write your code here
       return -1;
    }
    public static void main(String []args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];

        for(int i = 0 ;i < n;i++){
            arr[i] = scn.nextInt();
        }

        System.out.println(minimumDeletionsToSorted(arr));
    }
}