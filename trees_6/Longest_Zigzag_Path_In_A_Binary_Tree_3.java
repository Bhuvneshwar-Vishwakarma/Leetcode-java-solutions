package trees_6;
import java.util.Scanner;
/*1. You are given a partially written function to solve.
2. Given a binary tree root, a ZigZag path for a binary tree is defined as follow:
    a. Choose any node in the binary tree and a direction (right or left).
    b. If the current direction is right then move to the right child of the current node otherwise move to the left child.
    c. Change the direction from right to left or right to left.
    d. Repeat the second and third step until you can't move in the tree.

3.Zigzag length is defined in terms of edges. (A single node has a length of 0).
4. Return the longest ZigZag path contained in that tree.*/
public class Longest_Zigzag_Path_In_A_Binary_Tree_3 {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    public static class Pair{
    	int leftSlop = -1;
    	int rightSlop = -1;
    	int maxLen = 0;
    }
/*/*//*/***//*/*//*/**//*/*//*/*//**//************//*/*//*/*//*/*//*/*//***/
    public static Pair longestZigZagPathHelper(TreeNode root) {
    	if(root == null) return new Pair();
    	
    	Pair left = longestZigZagPathHelper(root.left);
    	Pair right = longestZigZagPathHelper(root.right);
    	
    	Pair myAns = new Pair();
    	myAns.maxLen = Math.max(Math.max(left.maxLen, right.maxLen), Math.max(left.rightSlop, right.leftSlop) + 1);
    	
    	myAns.leftSlop = left.rightSlop + 1;
    	myAns.rightSlop = right.leftSlop + 1;
    	
        return myAns;
    }
    public static int longestZigZagPath(TreeNode root) {
    	
    	Pair res = longestZigZagPathHelper(root);
    	return res.maxLen;
    }
    
    //we can also do this by array of size two and static variable maxLen
    //like similar to previous problem

    // input_Section_====================================================================

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1){
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

        System.out.println(longestZigZagPath(root));
    }

    public static void main(String[] args) {
        solve();
    }
}