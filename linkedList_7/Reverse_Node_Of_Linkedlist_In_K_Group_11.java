package linkedList_7;
import java.util.*;

public class Reverse_Node_Of_Linkedlist_In_K_Group_11 {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static int length(ListNode head) {
    	int len = 0;
    	ListNode curr = head;
    	while(curr != null) {
    		len++;
    		curr = curr.next;
    	}
    	return len;
    }
    public static ListNode th = null;// temporary head 
    public static ListNode tt = null;// temporary tail;
    public static void addFistNode(ListNode node) {
    	if(th == null) {
    		th = node;
    		tt = node;
    	}else {
    		node.next = th;
    		th = node;
    	}
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
    	if(head == null || head.next == null || k == 0) return head;
    	ListNode oh = null; // original head
    	ListNode ot = null; // original tail
    	ListNode curr = head;
    	int len = length(head);
    	while(len >= k) {
    		int tempK = k;
    		
    		while(tempK-- > 0) {
    			ListNode frwd = curr.next;
    			curr.next = null;
    			addFistNode(curr);
    			curr = frwd;
    		}
    		if(oh == null && ot == null) {
    			oh = th;
    			ot = tt;
    		}else {
    			ot.next = th;
    			ot = tt;
    		}
    		
    		th = null;
    		th = null;
    		len -= k;
    	}
    	ot.next = curr;
        return oh;
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

        int k = scn.nextInt();
        h1 = reverseKGroup(h1, k);
        printList(h1);
    }
}