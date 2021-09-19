 package linkedList_7;
import java.util.*;

public class Remove_Nth_Node_From_End_Of_Linkedlist_9 {
  public static Scanner scn = new Scanner(System.in);

  public static class ListNode {
    int val = 0;
    ListNode next = null;
    
    ListNode(){
    	
    }
    ListNode(int val) {
      this.val = val;
    }
    
  }

  public static ListNode removeNthFromEnd(ListNode head, int n) {
	  if(head == null || n == 0 || head.next == null) return head;
	  ListNode dummy = new ListNode();
	  dummy.next = head;
	  ListNode slow = dummy;
	  ListNode fast = dummy;
	  
	  for(int i = 1; i <= n; i++) {
		  fast = fast.next;
	  }
	  
	  while(fast.next != null) {
		  fast = fast.next;
		  slow = slow.next;
	  }
	  slow.next = slow.next.next;
	  
	  return dummy.next;
  }

  public static void printList(ListNode node) {
    while (node != null) {
      System.out.print(node.val + " ");
      node = node.next;
    }
  }

  public static ListNode createList(int n) {
    ListNode dummy = new ListNode(-1);
    ListNode prev = dummy;
    while (n-- > 0) {
      prev.next = new ListNode(scn.nextInt());
      prev = prev.next;
    }

    return dummy.next;
  }

  public static void main(String[] args) {
    int n = scn.nextInt();
    ListNode h1 = createList(n);

    int m = scn.nextInt();
    h1 = removeNthFromEnd(h1, m);
    printList(h1);
  }
}