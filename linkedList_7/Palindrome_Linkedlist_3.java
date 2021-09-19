package linkedList_7;
import java.util.*;

public class Palindrome_Linkedlist_3 {
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


    public static boolean isPalindrome(ListNode head) {
    	if(head == null || head.next == null) return true;
    	
    	ListNode mid = midNode(head);
    	ListNode nHead = mid.next;
    	mid.next = null;
    	
    	nHead = reverse(nHead);
    	
    	ListNode c1 = head;
    	ListNode c2 = nHead;
    	
    	boolean res = true;
    	while(c2 != null) {
    		if(c1.val != c2.val) {
    			res = false;
    			break;
    		}
    		c1 = c1.next;
    		c2 = c2.next;
    	}
    	
    	
    	//getting old list
    	nHead = reverse(nHead);
    	mid.next = nHead;
    	
        return res;
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

        System.out.println(isPalindrome(dummy.next));
    }
}