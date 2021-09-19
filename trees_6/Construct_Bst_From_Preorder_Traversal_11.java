package trees_6;
import java.util.Scanner;

public class Construct_Bst_From_Preorder_Traversal_11 {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    public static int idx = 0;
    
    public static TreeNode bstFromPreorder(int[] preOrder, int lr, int rr) { // left range, right range
    	if(idx >= preOrder.length || preOrder[idx] < lr || preOrder[idx] > rr) {
    		return null;
    	}
    	TreeNode node = new TreeNode(preOrder[idx++]);
    	node.left = bstFromPreorder(preOrder, lr, node.val);
    	node.right = bstFromPreorder(preOrder, node.val, rr);
    	
        return node;
    }
    public static TreeNode bstFromPreorder(int[] preOrder) {
//    	int n = preOrder.length;
    	int lr = -(int)1e9 - 1;
    	int rr = (int)1e9 + 1;
    	return bstFromPreorder(preOrder, lr, rr);
    }

    // input_section=================================================

    public static void display(TreeNode node) {
        if (node == null)
            return;

        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append(" -> " + node.val + " <- ");
        sb.append((node.right != null ? node.right.val : "."));

        System.out.println(sb.toString());

        display(node.left);
        display(node.right);

    }

    public static void solve() {
        int n = scn.nextInt();
        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = scn.nextInt();

        TreeNode root = bstFromPreorder(pre);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}