//Given a linked list, determine if it has a cycle in it.
//
//Follow up:
//Can you solve it without using extra space?

public class LinkedListCycle {
	public class Solution {
	    public boolean hasCycle(ListNode head) {
	        if(head==null)
	           return false;
	        ListNode slow = head;
	        ListNode fast = head;
	        while(fast!=null){
	           if(fast.next!=null)
	              fast = fast.next.next;
	           else
	              return false;
	           slow = slow.next;
	           if(fast==slow)
	              return true;
	        }
	        return false;
	    }
	}
}
