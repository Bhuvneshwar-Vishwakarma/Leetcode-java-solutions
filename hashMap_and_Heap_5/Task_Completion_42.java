package hashMap_and_Heap_5;
import java.util.*;

public class Task_Completion_42 {
	
    public static void completeTask(int n, int m, int[] arr) {
		// write your code here
    	HashSet<Integer> set = new HashSet<>();
    	for(int val: arr) {
    		set.add(val);
    	}
    	
    	ArrayList<Integer> one = new ArrayList<>();
    	ArrayList<Integer> two = new ArrayList<>();
    	
    	boolean flag = true;
    	for (int i = 1; i <= n; i++) {
			if(set.contains(i) == false) {
				if(flag) {
					one.add(i);
				}else {
					two.add(i);
				}
				flag = !flag;
			}
		}
    	
    	for(int val: one) {
    		System.out.print(val +" ");
    	}
    	System.out.println();
    	for(int val: two) {
    		System.out.print(val +" ");
    	}
    	System.out.println();

	}

	public static void main(String[] args) {
		try (Scanner scn = new Scanner(System.in)) {
			int n = scn.nextInt();
			int m = scn.nextInt();
			int[] num = new int[m];
			for (int i = 0; i < m; i++) {
				num[i] = scn.nextInt();
			}
			completeTask(n, m, num);
		}
	}

}
