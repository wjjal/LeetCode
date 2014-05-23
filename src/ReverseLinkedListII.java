//Reverse a linked list from position m to n. Do it in-place and in one-pass.
//
//For example:
//Given 1->2->3->4->5->NULL, m = 2 and n = 4,
//
//return 1->4->3->2->5->NULL.
//
//Note:
//Given m, n satisfy the following condition:
//1 ¡Ü m ¡Ü n ¡Ü length of list.

public class ReverseLinkedListII {
	public class Solution {
		public ListNode reverseBetween(ListNode head, int m, int n) {
			ListNode prev_head = new ListNode(0);
			prev_head.next = head;
			ListNode prev = prev_head;
			ListNode current = head;
			for (int i = 1; i < m; i++) {
				prev = prev.next;
				current = current.next;
			}
			ListNode end = current;
			for (int i = m; i <= n; i++) {
				ListNode next = current.next;
				current.next = prev.next;
				prev.next = current;
				current = next;
			}
			end.next = current;
			return prev_head.next;
		}
	}
}
