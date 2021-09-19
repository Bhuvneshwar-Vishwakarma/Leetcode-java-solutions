package linkedList_7;
import java.util.*;

public class Segregate01NodeOfLinkedlistOverSwappingNodes_23 {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregate01(ListNode head) {
    	if(head == null || head.next == null) return head;
    	
    	ListNode zero = new ListNode(-1);
    	ListNode p0 = zero;
    	ListNode one = new ListNode(-1);
    	ListNode p1 = one;
    	ListNode curr = head;
    	
    	while(curr != null) {
    		if(curr.val == 0) {
    			p0.next = curr;
    			p0 = p0.next;
    		}else {
    			p1.next = curr;
    			p1 = p1.next;
    		}
    		curr = curr.next;
    	}
    	p0.next = one.next;
    	p1.next = null;
    	
        return zero.next;
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
        h1 = segregate01(h1);
        printList(h1);
    }
}