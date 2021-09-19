package trees_6;
import java.util.*;

public class Diag_Order_Sum_Using_Shadow_Technique_25 {
  public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }
  public static void dfs(TreeNode root, int diagNo, ArrayList<Integer> ans) {
	  if(root == null) return;
	  
	  if(diagNo == ans.size()) ans.add(0);
	  ans.set(diagNo, ans.get(diagNo) + root.val);
	  
	  dfs(root.left, diagNo + 1, ans);
	  dfs(root.right, diagNo, ans);
	  
  }

  public static ArrayList<Integer> diagonalOrderSum(TreeNode root) {
	  ArrayList<Integer> ans = new ArrayList<>();
	  dfs(root, 0, ans);

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

    ArrayList<Integer> ans = diagonalOrderSum(root);
    for (Integer j : ans)
      System.out.print(j + " ");

  }

  public static void main(String[] args) {
    solve();
  }
}

