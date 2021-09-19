package trees_6;
import java.util.*;

public class Root_To_All_Leaf_Path_In_BinaryTree_30 {
  public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }
  public static ArrayList<Integer> reverseArrayList(ArrayList<Integer> alist)
  {
      // Arraylist for storing reversed elements
      ArrayList<Integer> revArrayList = new ArrayList<Integer>();
      for (int i = alist.size() - 1; i >= 0; i--) {

          // Append the elements in reverse order
          revArrayList.add(alist.get(i));
      }

      // Return the reversed arraylist
      return revArrayList;
  }
  
  public static void getPaths(TreeNode node) {
	  LinkedList<Integer> list = new LinkedList<>();
	  addPathsRecurs(node, list);
  }
  public static void addPathsRecurs(TreeNode node, LinkedList<Integer> path) {
	  if(node == null) return;
	 
	  path.addFirst(node.val);
	  
	  addPathsRecurs(node.left, path);
	  
	  if(node.left == null && node.right == null) {
		  ArrayList<Integer> list = new ArrayList<>();
		  for(int i = 0; i < path.size(); i++) {
			  list.add(path.get(i));
		  }
		  ArrayList<Integer> reverseList = reverseArrayList(list);
		  paths.add(reverseList);
	  }
	  addPathsRecurs(node.right, path);
	  
	  path.removeFirst();
	  
	  
  }
  
  public static ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
  public static ArrayList<ArrayList<Integer>> rootToAllLeafPath(TreeNode root) {
	  if(root == null) return paths;
	  getPaths(root);
	  return paths;
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

    ArrayList<ArrayList<Integer>> ans = rootToAllLeafPath(root);
    if (ans.size() == 0)
      System.out.println();
    for (ArrayList<Integer> al : ans) {
      for (Integer ele : al)
        System.out.print(ele + " ");
      System.out.println();
    }
  }

  public static void main(String[] args) {
    solve();
  }
}