public class L203RemoveLinkedListElements {
	public class Solution {
		public ListNode removeElements(ListNode head, int val) {
			ListNode pre_head = new ListNode(0);
			pre_head.next = head;
			ListNode last = pre_head;
			ListNode cur = head;
			while (cur != null) {
				if (cur.val == val) {
					last.next = cur.next;
					cur = cur.next;
				} else {
					last = cur;
					cur = cur.next;
				}
			}
			return pre_head.next;
		}
	}
}
