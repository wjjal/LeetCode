//Given a sorted linked list, delete all nodes that have duplicate numbers,
//leaving only distinct numbers from the original list.
//
//For example,
//Given 1->2->3->3->4->4->5, return 1->2->5.
//Given 1->1->1->2->3, return 2->3.

public class RemoveDuplicatesFromSortedListII {
	public class Solution {
		public ListNode deleteDuplicates(ListNode head) {
			ListNode pre_head = new ListNode(0);
			pre_head.next = head;
			ListNode pre = pre_head;
			if (head == null || head.next == null)
				return head;
			subdel(pre, head);
			return pre_head.next;
		}

		public void subdel(ListNode pre, ListNode head) {
			ListNode p = head;
			while (p.next != null && p.val == p.next.val)
				p = p.next;
			if (p != head) {
				pre.next = p.next;
				if (p.next != null)
					subdel(pre, p.next);
			}
			if (p.next != null) {
				pre = p;
				subdel(pre, p.next);
			}
		}
	}
}
