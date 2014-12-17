//Write a program to find the node at which the intersection of two singly linked lists
//begins.
//
//
//For example, the following two linked lists:
//
//A:          a1 → a2
//                   ↘
//                     c1 → c2 → c3
//                   ↗            
//B:     b1 → b2 → b3
//begin to intersect at node c1.
//
//
//Notes:
//
//If the two linked lists have no intersection at all, return null.
//The linked lists must retain their original structure after the function returns.
//You may assume there are no cycles anywhere in the entire linked structure.
//Your code should preferably run in O(n) time and use only O(1) memory.

///**
// * Definition for singly-linked list.
// * public class ListNode {
// *     int val;
// *     ListNode next;
// *     ListNode(int x) {
// *         val = x;
// *         next = null;
// *     }
// * }
// */
public class IntersectionofTwoLinkedLists {
	public static void main(String[] args) {
		ListNode headA = new ListNode(1);
		ListNode headB = headA;
		getIntersectionNode1(headA, headB);
	}

	public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
		ListNode p = headA;
		ListNode q = headB;
		if (headA == null || headB == null)
			return null;
		int lenA = 1;
		while (p.next != null) {
			p = p.next;
			lenA++;
		}
		int lenB = 1;
		while (q.next != null) {
			q = q.next;
			lenB++;
		}
		if (p != q)
			return null;
		if (lenA >= lenB) {
			int diff = lenA - lenB;
			return getIntersectionNodeHelp(diff, headA, headB);
		} else {
			int diff = lenB - lenA;
			return getIntersectionNodeHelp(diff, headB, headA);
		}
	}

	public static ListNode getIntersectionNodeHelp(int diff, ListNode headA,
			ListNode headB) {
		ListNode p = headA;
		ListNode q = headB;
		for (int i = 1; i <= diff; i++) {
			p = p.next;
		}
		while (p != null) {
			if (p == q)
				return p;
			p = p.next;
			q = q.next;
		}
		return null;
	}

	public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
		ListNode p = headA;
		ListNode q = headB;
		if (headA == null || headB == null)
			return null;
		boolean flagA = false;
		boolean flagB = false;
		ListNode lastA = null;
		ListNode lastB = null;
		while (true) {
			if (p == q)
				return p;
			if (p.next != null) {
				p = p.next;
			} else {
				lastA = p;
				//若最后一个node不同，则不相交，否则一定有交点
				if (flagB && lastA != lastB)
					return null;
				p = headB;
				flagA = true;
			}
			if (q.next != null) {
				q = q.next;
			} else {
				lastB = q;
				//若最后一个node不同，则不相交，否则一定有交点
				if (flagA && lastA != lastB)
					return null;
				q = headA;
				flagB = true;
			}
		}
	}
}
