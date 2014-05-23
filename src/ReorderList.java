//Given a singly linked list L: L0¡úL1¡ú¡­¡úLn-1¡úLn,
//reorder it to: L0¡úLn¡úL1¡úLn-1¡úL2¡úLn-2¡ú¡­
//
//You must do this in-place without altering the nodes' values.
//
//For example,
//Given {1,2,3,4}, reorder it to {1,4,2,3}.
public class ReorderList {
	public class Solution {
		public void reorderList(ListNode head) {
			if (head == null || head.next == null)
				return;
			// partition the list into 2 sublists of equal length
			ListNode slowNode = head, fastNode = head;
			while (fastNode.next != null) {
				fastNode = fastNode.next;
				if (fastNode.next != null) {
					fastNode = fastNode.next;
				} else {
					break;
				}
				slowNode = slowNode.next;
			}
			// 2 sublist heads
			ListNode head1 = head, head2 = slowNode.next;
			// detach the two sublists
			slowNode.next = null;

			// reverse the second sublist
			ListNode pre = head2, cur = head2.next;
			while (cur != null) {
				ListNode temp = cur.next;
				cur.next = pre;
				pre = cur;
				cur = temp;
			}
			head2.next = null;
			head2 = pre;

			// merge the 2 sublists as required
			ListNode p = head1, q = head2;
			while (q != null) {
				ListNode p1 = p.next;
				ListNode q1 = q.next;
				p.next = q;
				q.next = p1;
				p = p1;
				q = q1;
			}

		}
	}
}
