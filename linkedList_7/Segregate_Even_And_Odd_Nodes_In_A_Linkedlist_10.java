package linkedList_7;
import java.util.*;

public class Segregate_Even_And_Odd_Nodes_In_A_Linkedlist_10 {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregateEvenOdd(ListNode head) {
    	if(head == null || head.next == null) return head;
    	
    	ListNode dummyEven = new ListNode(-1);
    	ListNode dummyOdd = new ListNode(-1);
    	ListNode evenTail = dummyEven;
    	ListNode oddTail = dummyOdd;
    	ListNode curr = head;
    	
    	while(curr != null) {
    		if(curr.val % 2 != 0) {// odd
    			oddTail.next = curr;
    			oddTail = oddTail.next;
    		}else {// even
    			evenTail.next = curr;
    			evenTail = evenTail.next;
    		}
    		curr = curr.next;
    	}
    	
    	evenTail.next = dummyOdd.next;
    	oddTail.next = null;
    			
        return dummyEven.next;
    }

    public static void main(String[] args) {
        try (Scanner scn = new Scanner(System.in)) {
			int n = scn.nextInt();
			ListNode dummy = new ListNode(-1);
			ListNode prev = dummy;
			while (n-- > 0) {
			    prev.next = new ListNode(scn.nextInt());
			    prev = prev.next;
			}

			ListNode head = segregateEvenOdd(dummy.next);
			while (head != null) {
			    System.out.print(head.val + " ");
			    head = head.next;
			}
		}
    }
}