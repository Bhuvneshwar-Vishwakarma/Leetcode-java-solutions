package trees_6;
import java.util.*;

public class Binary_Search_Tree_Iterator_Using_MorrisTraversal_28 {
  public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }

  public static class BSTIterator {
	  TreeNode curr = null;
	  public BSTIterator(TreeNode node) {
		 this.curr = node;
	  }
	  private TreeNode getRightMostNode(TreeNode leftNode) {
		  while(leftNode.right != null && leftNode.right != this.curr) {
			  leftNode = leftNode.right;
		  }
		  return leftNode;
	  }
	  
	  private TreeNode morrisTravarsal() {
		  TreeNode res = null;
		  
		  while(this.curr != null) {
			  TreeNode leftNode = this.curr.left;
			  
			  if(leftNode == null) {
				  res = this.curr;
				  this.curr = this.curr.right;
				  break;
			  }else {
				  TreeNode rightMostNode = getRightMostNode(leftNode);
				  if(rightMostNode.right == null) {
					  rightMostNode.right = this.curr;
					  this.curr = this.curr.left;
				  }else {
					  res = this.curr;
					  rightMostNode.right = null;
					  this.curr = this.curr.right;
					  break;
				  }
			  }
		  }
		  
		  return res;
	  }
	  
	  public int next() {
	    	TreeNode node = morrisTravarsal();
	    	return node.val;
	    }

    public boolean hasNext() {
    	return this.curr != null;

    }
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

  public static TreeNode constructFromInOrder_(int[] in, int si, int ei) {
    if (si > ei)
      return null;

    int mid = (si + ei) / 2;
    TreeNode node = new TreeNode(in[mid]);

    node.left = constructFromInOrder_(in, si, mid - 1);
    node.right = constructFromInOrder_(in, mid + 1, ei);

    return node;
  }

  public static void solve() {
    int n = scn.nextInt();
    int[] in = new int[n];
    for (int i = 0; i < n; i++)
      in[i] = scn.nextInt();

    TreeNode root = constructFromInOrder_(in, 0, in.length - 1);
    BSTIterator itr = new BSTIterator(root);
    while (itr.hasNext()) {
      System.out.println(itr.next());
    }
  }

  public static void main(String[] args) {
    solve();
  }
}