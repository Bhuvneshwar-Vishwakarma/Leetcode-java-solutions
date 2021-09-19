package linkedList_7;
import java.util.*;

public class Unfold_Of_Linkedlist_5 {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void unfold(ListNode head) {
    	if(head == null && head.next == null) return;
    	
    	ListNode fHead = head; // First Head
    	ListNode fPrev = fHead; // First Previous
    	
    	ListNode sHead = head.next; // Second Head
    	ListNode sPrev = sHead; // Second Previous
    	ListNode frwd = null; // forward
    	
    	
    	while(sPrev != null && sPrev.next != null) {
    		frwd = sPrev.next; // backup
    		
    		//links
    		fPrev.next = frwd;
    		sPrev.next = frwd.next;
    		
    		//moves
    		fPrev = fPrev.next;
    		sPrev = sPrev.next;
    	}
    	fPrev.next = null;
    	
    	sHead = reverse(sHead);
    	fPrev.next = sHead;
    }
    public static ListNode reverse(ListNode head) {
    	if(head == null || head.next == null) return head;
    	
    	ListNode curr = head;
    	ListNode prev = null;
    	ListNode frwd = null;// forward
    	
    	while(curr != null) {
    		frwd = curr.next;// backup
    		curr.next = prev;// link reverse
    		
    		prev = curr;// update
    		curr = frwd;
    		
    	}
    	
        return prev;
    }

    static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        ListNode head = dummy.next;
        unfold(head);
        printList(head);
    }
}