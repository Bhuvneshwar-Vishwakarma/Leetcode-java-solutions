package arrays_and_String_9;

import java.util.*;



public class Merge_Intervals_36{
    public static int[][] mergeIntervals(int Intervals[][]){
        // write your code here
    	Arrays.sort(Intervals, (a, b) -> Integer.compare(a[0],b[0]));// sort on the base of starting point
    	
    	ArrayList<int[]> list = new ArrayList<>();
    	
    	for(int[] interval: Intervals) {
    		if(list.size() == 0) {
    			list.add(interval);
    		}else {
    			int[] preInterval = list.get(list.size() - 1);
    			if(interval[0] < preInterval[1]) {
    				preInterval[1] = Math.max(interval[1], preInterval[1]);
    			}else {
    				list.add(interval);
    			}
    		}
    	}
    	
    	return list.toArray(new int[list.size()][]);
    }
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);

        // Input Format
        int n = scn.nextInt();
        int input[][] = new int[n][2];

        for(int i = 0 ; i <  n ; i++){
            int sp = scn.nextInt();
            int ep = scn.nextInt();

            input[i][0] = sp;
            input[i][1] = ep;
        }

        // Output Format
        int [][]output = mergeIntervals(input);

        System.out.print("[");
        for(int arr[] : output){
            System.out.print(Arrays.toString(arr));
        }
        System.out.println("]");
    }
}