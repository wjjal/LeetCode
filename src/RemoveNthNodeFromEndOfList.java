//Given a linked list, remove the nth node from the end of list and return its head.
//
//For example,
//
//   Given linked list: 1->2->3->4->5, and n = 2.
//
//   After removing the second node from the end, the linked list becomes 1->2->3->5.
//Note:
//Given n will always be valid.
//Try to do this in one pass.

public class RemoveNthNodeFromEndOfList {
	public class Solution {
		public ListNode removeNthFromEnd(ListNode head, int n) {
			ListNode pre_head = new ListNode(0);
			pre_head.next = head;
			ListNode slow = pre_head;
			ListNode fast = pre_head;
			for (int i = 0; i < n; i++)
				fast = fast.next;
			while (fast.next != null) {
				fast = fast.next;
				slow = slow.next;
			}
			slow.next = slow.next.next;
			return pre_head.next;
		}
	}
}
