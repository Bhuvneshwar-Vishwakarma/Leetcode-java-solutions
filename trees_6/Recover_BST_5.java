 package trees_6;
import java.util.Scanner;
/*1. You are given a partially written function to solve(Refer question video).
2. You are given the root of a binary search tree (BST), where exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.

Follow up: You are Not Allowed To Use Extra Space(Example : Storing All Element In Arrays).*/
public class Recover_BST_5 {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    
    public static TreeNode first = null;
    public static TreeNode second = null;
    
    public static TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    
    public static void recoverTree(TreeNode root) {
    
    	inorder(root);
    	
    	int temp = first.val;
    	first.val = second.val;
    	second.val = temp;
    }
    public static void inorder(TreeNode root) {
    	if(root == null) return;
    	
    	inorder(root.left);
    	
    	if(first == null && prev.val > root.val) {
    		first = prev;
    	}
    	if(first != null && prev.val > root.val) {
    		second = root;
    	}
    	prev = root;
    	
    	inorder(root.right);
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
        recoverTree(root);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}