package linkedList_7;
import java.util.*;

public class Fold_Of_Linkedlist_4 {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode midNode(ListNode head) {
    	if(head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    
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

    public static void fold(ListNode head) {
    	ListNode mid = midNode(head);
    	ListNode nHead = mid.next;
    	mid.next = null;
    	
    	nHead = reverse(nHead);
    	
    	ListNode c1 = head;
    	ListNode c2 = nHead;
    	ListNode f1 = null;
    	ListNode f2 = null;
    	
    	while(c2 != null) {
    		f1 = c1.next;
    		f2 = c2.next;
    		
    		c1.next = c2;
    		c2.next = f1;
    		
    		c1 = f1;
    		c2 = f2;
    	}
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
        fold(head);
        printList(head);
    }
}