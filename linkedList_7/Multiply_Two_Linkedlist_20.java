package linkedList_7;
import java.util.*;

public class Multiply_Two_Linkedlist_20 {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode reverse(ListNode head) {
    	ListNode curr =head;
    	ListNode prev = null;
    	ListNode frwd = null;
    	
    	while(curr != null) {
    		frwd = curr.next;
    		curr.next = prev;
    		prev = curr;
    		curr = frwd;
    	}
    	return prev;
    }
    public static void addTwoLinkedList(ListNode head, ListNode ansItr) {
    	ListNode c1 = head;
    	ListNode c2 = ansItr;
    	int carry = 0;
    	while(c1 != null || carry != 0) {
    		int sum = carry + (c1 != null ? c1.val : 0) + (c2.next != null ? c2.next.val : 0);
    		int digit = sum % 10;
    		carry = sum / 10;
    		
    		if(c2.next != null) c2.next.val = digit;
    		else c2.next = new ListNode(digit);
    		
    		if(c1 != null) c1 = c1.next;
    		c2 = c2.next;
    	}
    }
    
    public static ListNode multiplyWithDigit(ListNode head, int dig) {
    	ListNode dummy = new ListNode(-1);
    	ListNode ac = dummy; // answer current
    	ListNode c1 = head;
    	int carry = 0;
    	
    	while(c1 != null || carry != 0) {
    		int sum = carry + (c1 != null ? c1.val * dig: 0);
    		int digit = sum % 10;
    		carry = sum / 10;
    		
    		ac.next = new ListNode(digit);
    		if(c1 != null) c1 = c1.next;
    		ac = ac.next;
    	}
    	return dummy.next;
    }

    public static ListNode multiplyTwoLL(ListNode l1, ListNode l2) {
    	l1 = reverse(l1);
    	l2 = reverse(l2);
    	
    	ListNode dummy = new ListNode(-1);
    	ListNode ansItr = dummy;
    	ListNode l2_itr = l2;
    	
    	while(l2_itr != null) {
    		ListNode prod = multiplyWithDigit(l1, l2_itr.val);
    		l2_itr = l2_itr.next;
    		
    		addTwoLinkedList(prod, ansItr);
    		ansItr = ansItr.next;
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

        ListNode ans = multiplyTwoLL(head1, head2);
        printList(ans);
    }

}