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

public class L019RemoveNthNodeFromEndOfList {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		new L019RemoveNthNodeFromEndOfList().new Solution().removeNthFromEnd1(head,
				1);
	}

	public class Solution {
		public ListNode removeNthFromEnd1(ListNode head, int n) {
			ListNode pre_head = new ListNode(0);
			pre_head.next = head;
			ListNode pre_slow = pre_head;
			ListNode slow = head;
			ListNode fast = head;
			while (n > 0) {
				fast = fast.next;
				n--;
			}
			while (fast != null) {
				fast = fast.next;
				pre_slow = pre_slow.next;
				slow = slow.next;
			}
			pre_slow.next = slow.next;
			return pre_head.next;
		}

		public ListNode removeNthFromEnd2(ListNode head, int n) {
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
