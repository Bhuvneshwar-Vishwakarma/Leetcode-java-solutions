package trees_6;
import java.util.*;

public class Node_To_Root_Path_BinaryTree_By_Return_Type29 {
  public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }

  public static ArrayList<TreeNode> nodeToRootPathHelper(TreeNode node, int data) {
	  if(node == null) return null;
	  
	  if(node.val == data) {
		  ArrayList<TreeNode> list = new ArrayList<>();
		  list.add(node);
		  return list;
	  }
	  
	  ArrayList<TreeNode> left = nodeToRootPathHelper(node.left, data);
	  if(left != null) {
		  left.add(node);
		  return left;
	  }
	  ArrayList<TreeNode> right = nodeToRootPathHelper(node.right, data);
	  if(right != null) {
		  right.add(node);
		  return right;
	  }
	  
	  return null;
  }
  public static ArrayList<TreeNode> nodeToRootPath(TreeNode node, int data) {
	  // write your code here
	  ArrayList<TreeNode> ans = nodeToRootPathHelper(node, data);
	  return ans != null ? ans : new ArrayList<>();
  }

  // input_section=================================================

  public static TreeNode createTree(int[] arr, int[] IDX) {
    if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
      IDX[0]++;
      return null;
    }
    TreeNode Treenode = new TreeNode(arr[IDX[0]++]);
    Treenode.left = createTree(arr, IDX);
    Treenode.right = createTree(arr, IDX);

    return Treenode;
  }

  public static void solve() {
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++)
      arr[i] = scn.nextInt();

    int[] IDX = new int[1];
    TreeNode root = createTree(arr, IDX);

    int data = scn.nextInt();
    ArrayList<TreeNode> ans = nodeToRootPath(root, data);
    if (ans.size() == 0)  System.out.println();
    for (TreeNode node : ans)
      System.out.print(node.val + " ");

  }

  public static void main(String[] args) {
    solve();
  }
}