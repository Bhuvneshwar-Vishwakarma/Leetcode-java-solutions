package trees_6;
import java.util.Scanner;

public class Maximum_Path_Sum_Of_BinaryTree_36 {
  public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }
  public static class Res {
	  public int val;
  }
  /*For each node there can be four ways that the max path goes through the node: 
1. Node only 
2. Max path through Left Child + Node 
3. Max path through Right Child + Node 
4. Max path through Left Child + Node + Max path through Right Child*/
  private static int findMaxUtil(TreeNode node, Res res) {
	  if(node == null) {
		  return 0;
	  }
	  int l = findMaxUtil(node.left, res);
	  int r = findMaxUtil(node.right, res);
	  
	  int maxSingle = Math.max(Math.max(l, r) + node.val, node.val);
	  int maxTop = Math.max(maxSingle, l + r + node.val);
	  
	  res.val = Math.max(res.val, maxTop);
	  
	return maxSingle;
	  
  }

  public static int maxPathSum(TreeNode root) {
	  Res res = new Res();
	  res.val = Integer.MIN_VALUE;
	  
	  findMaxUtil(root, res);
	  return res.val;
	  
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