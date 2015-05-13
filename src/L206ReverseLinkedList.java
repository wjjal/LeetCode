public class L206ReverseLinkedList {
	ListNode pre_head = new ListNode(0);

	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		a.next = b;
		b.next = c;
		ListNode p = new L206ReverseLinkedList().reverseList2(a);
		System.out.println(p.val);
	}

	public ListNode reverseList1(ListNode head) {
		if (head == null || head.next == null)
			return head;
		pre_head = new ListNode(0);
		pre_head.next = head;
		ListNode p;
		ListNode q;
		while (head.next != null) {
			p = head.next;
			q = pre_head.next;
			head.next = p.next;
			pre_head.next = p;
			p.next = q;
		}
		return pre_head.next;
	}

	public ListNode reverseList2(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		pre_head.next = head;
		reverse(head);
		head.next = null;
		return pre_head.next;
	}

	public ListNode reverse(ListNode node) {
		if (node.next == null) {
			pre_head.next = node;
			return node;
		}
		ListNode p = reverse(node.next);
		p.next = node;
		return node;
	}
}
