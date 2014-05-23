//A linked list is given such that each node contains an additional random pointer 
//which could point to any node in the list or null.
//
//Return a deep copy of the list.

public class CopyListWithRandomPointer {
	public class Solution {
		public RandomListNode copyRandomList(RandomListNode head) {
			if (head == null)
				return null;
			RandomListNode node = head;
			while (node != null) {
				RandomListNode newnode = new RandomListNode(node.label);
				newnode.next = node.next;
				node.next = newnode;
				node = node.next.next;
			}
			node = head;
			while (node != null) {
				RandomListNode newnode = node.next;
				if (node.random != null)
					newnode.random = node.random.next;
				node = node.next.next;
			}
			RandomListNode newhead = head.next;
			RandomListNode p = head;
			RandomListNode q = newhead;
			while (p != null) {
				p.next = q.next;
				p = p.next;
				if (p != null) {
					q.next = p.next;
					q = q.next;
				}
			}
			return newhead;
		}
	}
}
