//Given a linked list, swap every two adjacent nodes and return its head.
//
//For example,
//Given 1->2->3->4, you should return the list as 2->1->4->3.
//
//Your algorithm should use only constant space. 
//You may not modify the values in the list, only nodes itself can be changed.

public class L024SwapNodesInPairs {
	public class Solution {
		public ListNode swapPairs(ListNode head) {
			if (head == null)
				return null;
			ListNode prevHead = new ListNode(0);
			prevHead.next = head;
			ListNode prev = prevHead;
			ListNode left = head;
			ListNode right = head.next;
			while (left != null && right != null) {
				left.next = right.next;
				prev.next = right;
				right.next = left;
				prev = left;
				left = prev.next;
				if (left != null)
					right = left.next;
				else
					right = null;
			}
			return prevHead.next;
		}
	}
}
