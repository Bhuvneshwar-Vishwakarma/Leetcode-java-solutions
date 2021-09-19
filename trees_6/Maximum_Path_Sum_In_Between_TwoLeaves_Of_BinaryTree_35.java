package trees_6;
import java.util.Scanner;

public class Maximum_Path_Sum_In_Between_TwoLeaves_Of_BinaryTree_35 {
  public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }
public static class Res{
	int val;
}
/*) Maximum root to leaf path sum for the subtree rooted under current node. 
2) The maximum path sum between leaves (desired output).
For every visited node X, we find the maximum root to leaf sum in left and right subtrees of X. 
We add the two values with X->data, and compare the sum with maximum path sum found so far.

Following is the implementation of the above O(n) solution.

*/
private static int maxPathSumUtil(TreeNode node, Res res) {
	if(node == null) return 0;
	
	if(node.left == null && node.right == null) {
		return node.val;
	}
	int ls = maxPathSumUtil(node.left, res);
	int rs = maxPathSumUtil(node.right, res);
	
	// If both left and right children exist
	if(node.left != null && node.right != null) {
		// Update result if needed
		res.val = Math.max(res.val, ls + rs + node.val);
		
		return Math.max(ls, rs) + node.val;
	}
	
	return (node.left == null) ? rs + node.val : ls + node.val;
	
	
}
  public static int maxPathSum(TreeNode root) {
	  Res res = new Res();
	  res.val = Integer.MIN_VALUE;
	  if(root.left == null || root.right == null) {
		  root = setTree(root);// //if tree is left most or right most
          //call setTree() method to adjust tree first
	  }
	  maxPathSumUtil(root, res);
    return res.val;
  }

  private static TreeNode setTree(TreeNode root) {
	// TODO Auto-generated method stub
	  TreeNode temp = new TreeNode(0);
	  //if tree is left most
	  if(root.right == null) {
		  root.right = temp;
	  }else {// if right most
		  root.left = temp;
	  }
	return root;
}
// input_Section=================================================

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
    System.out.println(maxPathSum(root));
  }

  public static void main(String[] args) {
    solve();
  }
}