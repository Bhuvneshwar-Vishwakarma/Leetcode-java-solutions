package trees_6;
import java.util.*;

public class Right_View_Of_A_Binarytree_16 {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static ArrayList<Integer> rightView(TreeNode root) {
    	ArrayList<Integer> ans = new ArrayList<>();
    	LinkedList<TreeNode> que = new LinkedList<>();
    	que.addLast(root);
    	
    	while(que.size() != 0) {
    		int size = que.size();
    		ans.add(que.getFirst().val);
    		
    		while(size-- > 0) {
    			TreeNode rem = que.removeFirst();
    			if(rem.right != null) que.addLast(rem.right);
    			if(rem.left != null) que.addLast(rem.left);
    		}
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

        ArrayList<Integer> ans = rightView(root);
        for(Integer i : ans) System.out.println(i); 
    }

    public static void main(String[] args) {
        solve();
    }
}