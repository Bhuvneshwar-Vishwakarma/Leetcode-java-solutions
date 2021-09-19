package linkedList_7;
import java.util.*;

public class Add_Two_Linkedlist_18 {
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
    	
    	ListNode prev = null;
    	ListNode curr = head;
    	ListNode frwd = null;
    	
    	while(curr != null) {
    		frwd = curr.next;// backup
    		curr.next = prev;

    		prev = curr;
    		curr = frwd;
    	}
    	return prev;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	if(l1 == null || l2 == null) return l1 != null ? l1 : l2;
    	
    	ListNode c1 = reverse(l1);
    	ListNode c2 = reverse(l2);
    	ListNode dummy = new ListNode(-1);
    	ListNode itr = dummy;
    	
    	int carry = 0;
    	while(c1 != null || c2 != null || carry != 0) {
    		int sum = carry + (c1 != null ? c1.val : 0) + (c2 != null ? c2.val : 0);
    		
    		int lastDigit = sum % 10;
    		carry = sum / 10;
    		
    		itr.next = new ListNode(lastDigit);
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

        ListNode ans = addTwoNumbers(head1, head2);
        printList(ans);
    }

}