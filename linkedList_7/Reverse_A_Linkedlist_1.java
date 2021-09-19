package linkedList_7;
import java.util.*;
/*You have given a pointer to the head node of a linked list, the task is to reverse the linked list. 
We need to reverse the list by changing the links between nodes.*/
public class Reverse_A_Linkedlist_1 {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
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

    public static void main(String[] args) {
        try (Scanner scn = new Scanner(System.in)) {
			int n = scn.nextInt();
			ListNode dummy = new ListNode(-1);
			ListNode prev = dummy;
			while (n-- > 0) {
			    prev.next = new ListNode(scn.nextInt());
			    prev = prev.next;
			}

			ListNode head = reverse(dummy.next);
			while (head != null) {
			    System.out.print(head.val + " ");
head = head.next;
			}
		}
    }
}