//Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
//
//Follow up:
//Can you solve it without using extra space?

public class LinkedListCycleII {
	public class Solution {
		public ListNode detectCycle(ListNode head) {
			ListNode fast = head;
			ListNode slow = head;
			while (fast != null) {
				slow = slow.next;
				if (fast.next != null)
					fast = fast.next.next;
				else
					fast = null;
				if (fast == slow)
					break;
			}
			if (fast == null)
				return null;
			slow = head;
			while (slow != fast) {
				slow = slow.next;
				fast = fast.next;
			}
			return slow;
		}
	}
}
