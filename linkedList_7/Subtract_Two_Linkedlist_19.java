 package linkedList_7;
import java.util.*;

public class Subtract_Two_Linkedlist_19 {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    private static ListNode reverse(ListNode head) {
    	if(head == null || head.next == null) return head;
    	ListNode curr = head;
    	ListNode prev = null;
    	ListNode frwd = null;
    	
    	while(curr != null) {
    		frwd = curr.next; // backup
    		curr.next = prev;
    		
    		prev = curr;
    		curr = frwd;
    	}
    	return prev;
    }

    public static ListNode subtractTwoNumbers(ListNode l1, ListNode l2) {
    	if(l2 == null) return l1;
    	if(l1 == null) {
    		l2.val = -l2.val;
    		return l2;
    	}
    	ListNode c1 = reverse(l1);
    	ListNode c2 = reverse(l2);
    	ListNode dummy = new ListNode(-1);
    	ListNode itr = dummy;
    	int borrow = 0;
    	
    	while(c1 != null || c2 != null) {
    		int diff = borrow + (c1 != null ? c1.val : 0) - (c2 != null ? c2.val : 0);
    		if(diff < 0) {
    			diff += 10;
    			borrow = -1;
    		}else {
    			borrow = 0;
    		}
    		itr.next = new ListNode(diff);
    		itr = itr.next;
    		
    		if(c1 != null) c1 = c1.next;
    		if(c2 != null) c2 = c2.next;
    		
    	}
        return reverse(dummy.next);
    }

    // InFput_code===================================================

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode makeList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head1 = makeList(scn.nextInt());
        ListNode head2 = makeList(scn.nextInt());

        ListNode ans = subtractTwoNumbers(head1, head2);
        printList(ans);
    }

}