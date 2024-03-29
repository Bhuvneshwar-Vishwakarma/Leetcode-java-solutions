package trees_6;
import java.util.*;

public class Diagonal_Order_anti_clock_Wise_Of_A_Binarytree_23 {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static ArrayList<ArrayList<Integer>> diagonalOrder(TreeNode root) {
    	ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    	LinkedList<TreeNode> que = new LinkedList<>();
    	
    	que.addLast(root);
    	while(que.size() != 0) {// diagonal
    		int size = que.size();
    		ArrayList<Integer> smallAns = new ArrayList<>();
    		
    		while(size-- > 0) {// help to traverse each component of that particular diagonal
    			TreeNode rn = que.removeFirst();
    			
    			while(rn != null) {// traverse a component
    				smallAns.add(rn.val);
    				if(rn.right != null) que.addLast(rn.right);
    				
    				rn = rn.left;
    			}
    		}
    		ans.add(smallAns);
    	}
        return ans;
    }

    // input_section=================================================

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
            IDX[0]++;
            return null;
        }
        TreeNode node = new TreeNode(arr[IDX[0]++]);
        node.left = createTree(arr, IDX);
        node.right = createTree(arr, IDX);

        return node;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);

        ArrayList<ArrayList<Integer>> ans = diagonalOrder(root);
        int idx = 0;
        for (ArrayList<Integer> i : ans) {
            System.out.print(idx++ + " -> ");
            for (Integer j : i)
                System.out.print(j + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solve();
    }
}