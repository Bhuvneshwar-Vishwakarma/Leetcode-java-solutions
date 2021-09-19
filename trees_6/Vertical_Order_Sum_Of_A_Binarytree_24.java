 package trees_6;
import java.util.*;

public class Vertical_Order_Sum_Of_A_Binarytree_24 {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    public static void width(TreeNode node, int hl, int[] arr) {
    	if(node == null) return;
    	
    	arr[0] = Math.min(arr[0], hl);
    	arr[1] = Math.max(arr[1], hl);
    	
    	width(node.left, hl - 1, arr);
    	width(node.right, hl + 1, arr);
    }
    public static class Pair{
    	TreeNode node = null;
    	int hl = 0;
    	
    	Pair(TreeNode node, int hl){
    		this.node = node;
    		this.hl = hl;
    	}
    }

    public static ArrayList<Integer> verticalOrderSum(TreeNode node) {
    	int[] minMax = new int[2];
    	width(node, 0, minMax);
    	int len = minMax[1] - minMax[0] + 1;
    	ArrayList<Integer> ans = new ArrayList<>();
    	for(int i = 0; i < len; i++) ans.add(0);
    	
    	LinkedList<Pair> que = new LinkedList<>(); 
    	que.addLast(new Pair(node, Math.abs(minMax[0])));
    	
    	while(que.size() != 0) {
    		int size = que.size();
    		while(size-- > 0) {
    			Pair rp = que.removeFirst();
    			
    			ans.set(rp.hl, ans.get(rp.hl) + rp.node.val);
    			
    			if(rp.node.left != null) que.addLast(new Pair(rp.node.left, rp.hl - 1));
    			if(rp.node.right != null) que.addLast(new Pair(rp.node.right, rp.hl + 1));
    			
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

        ArrayList<Integer> ans = verticalOrderSum(root);
        for (Integer j : ans)
            System.out.println(j);

    }

    public static void main(String[] args) {
        solve();
    }
}