//Given a linked list and a value x, partition it such that all nodes less 
//than x come before nodes greater than or equal to x.
//
//You should preserve the original relative order of the nodes in each of 
//the two partitions.
//
//For example,
//Given 1->4->3->2->5->2 and x = 3,
//return 1->2->2->4->3->5.

public class L086PartitionList {
	public class Solution {
		public ListNode partition(ListNode head, int x) {
			ListNode h1 = new ListNode(0);
			ListNode h2 = new ListNode(0);
			ListNode p = h1;
			ListNode q = h2;
			while (head != null) {
				if (head.val < x) {
					p.next = head;
					p = p.next;
				} else {
					q.next = head;
					q = q.next;
				}
				head = head.next;
			}
			q.next = null;
			p.next = h2.next;
			return h1.next;
		}
	}
}
