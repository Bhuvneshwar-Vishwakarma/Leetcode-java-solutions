package trees_6;
import java.util.*;

public class Convert_Sorted_DoublyLinkedList_To_BinarySearchTree_34 {
  public static Scanner scn = new Scanner(System.in);

  public static class Node {
    int val = 0;
    Node left = null;
    Node right = null;

    Node(int val) {
      this.val = val;
    }
  }

   // left : prev, right : next
  static Node head;
  public static Node SortedDLLToBST(Node head) {
	  int n = countNodes(head);
	  
    return sortedListToBST(n);
  }
  private static Node sortedListToBST(int n) {
	// TODO Auto-generated method stub
	  if(n <= 0) return null;
	  
	  Node left = sortedListToBST(n/2);
	  Node root = head;
	  root.left = left;
	  
	  head = head.right;
	  
	  root.right = sortedListToBST(n - n/2 - 1);
	  
	return root;
}
public static int countNodes(Node head) {
	  int count = 0;
	  Node temp = head;
	  while(temp != null) {
		  temp = temp.right;
		  count++;
	  }
	  return count;
  }

  // Input_code===================================================

  public static void display(Node node) {
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

  public static Node makeList(int n) {
    Node dummy = new Node(-1);
    Node prev = dummy;
    while (n-- > 0) {
      Node node = new Node(scn.nextInt());
      prev.right = node;
      node.left = prev;
      prev = prev.right;
    }

    Node head = dummy.right;
    head.left = dummy.right = null;

    return head;
  }

  public static void main(String[] args) {
    Node head = makeList(scn.nextInt());

    head = SortedDLLToBST(head);
    display(head);
  }

}