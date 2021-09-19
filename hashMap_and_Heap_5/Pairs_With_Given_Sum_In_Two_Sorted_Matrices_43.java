 package hashMap_and_Heap_5;
import java.util.*;

public class Pairs_With_Given_Sum_In_Two_Sorted_Matrices_43 {
	
    public static int solve(int[][] num1, int[][] num2, int k) {
		// write your code here
    	HashMap<Integer, Integer> map = new HashMap<>();
    	for(int i = 0; i < num1.length; i++) {
    		for(int j = 0; j < num1[0].length; j++) {
    			map.put(num1[i][j], map.getOrDefault(num1[i][j], 0) + 1);
    		}
    	}
    	int count = 0;
    	
    	for(int i = 0; i < num2.length; i++) {
    		for(int j = 0; j < num2[0].length; j++) {
    			
    			int comp = k - num2[i][j];
    			if(map.containsKey(comp)) {
    				count += map.get(comp);
    			}
    			
    		}
    	}

		return count;
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int N = sc.nextInt();
			int[][] mat1 = new int[N][N];
			for (int i = 0; i < mat1.length; i++) {
				for (int j = 0; j < mat1[0].length; j++) {
					mat1[i][j] = sc.nextInt();
				}
			}

			int[][] mat2 = new int[N][N];
			for (int i = 0; i < mat2.length; i++) {
				for (int j = 0; j < mat2[0].length; j++) {
					mat2[i][j] = sc.nextInt();
				}
			}
			int K = sc.nextInt();
			System.out.println(solve(mat1, mat2, K));
		}

	}

}
