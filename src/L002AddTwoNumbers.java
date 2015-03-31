//You are given two linked lists representing two non-negative numbers. 
//The digits are stored in reverse order and each of their nodes contain a single digit. 
//Add the two numbers and return it as a linked list.
//
//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8

public class L002AddTwoNumbers {
	public class Solution {
		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			ListNode re = new ListNode(0);
			ListNode head = re;
			int carry = 0;
			while (l1 != null && l2 != null) {
				int sum = l1.val + l2.val + carry;
				carry = 0;
				if (sum >= 10) {
					re.next = new ListNode(sum % 10);
					carry = 1;
					;
				} else
					re.next = new ListNode(sum);
				l1 = l1.next;
				l2 = l2.next;
				re = re.next;
			}
			while (l1 != null) {
				int sum = l1.val + carry;
				carry = 0;
				if (sum >= 10) {
					re.next = new ListNode(0);
					carry = 1;
				} else
					re.next = new ListNode(sum);
				l1 = l1.next;
				re = re.next;
			}
			while (l2 != null) {
				int sum = l2.val + carry;
				carry = 0;
				if (sum >= 10) {
					re.next = new ListNode(0);
					carry = 1;
				} else
					re.next = new ListNode(sum);
				l2 = l2.next;
				re = re.next;
			}
			if (carry == 1)
				re.next = new ListNode(1);
			return head.next;
		}
	}
}
