package trees_6;
import java.util.*;

public class All_Single_Child_Parent_In_BinaryTree_By_Heap_Mover_31 {
  public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }

  public static void exactlyOneChild(TreeNode node, ArrayList<Integer> list) {
    
	  if(node == null || (node.left == null && node.right == null)) {// if Child
		  return;
	  }
	  if(node.left == null || node.right == null) {// having single child
		  list.add(node.val);
	  }
	  exactlyOneChild(node.left, list);
	  exactlyOneChild(node.right, list);
  }
  public static ArrayList<Integer> exactlyOneChild(TreeNode root) {
	  ArrayList<Integer> ans = new ArrayList<>();
	  exactlyOneChild(root, ans);
	  return ans;
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

    ArrayList<Integer> ans = exactlyOneChild(root);
    if (ans.size() == 0)
      System.out.println();
    for (Integer ele : ans)
      System.out.print(ele + " ");
  }

  public static void main(String[] args) {
    solve();
  }
}