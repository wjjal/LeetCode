public class L234PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null)
			return true;
        ListNode fast = head;
        ListNode slow = head;
        ListNode mid = slow;
        while(fast.next!=null && fast.next.next!=null){
        	fast=fast.next.next;
        	mid = slow;
        	slow =slow.next;
        }
        //奇数个去除中间节点
        if(fast!=null){
        	mid = slow;
        	slow = slow.next;
        }
        mid.next = null;
        ListNode p = head;
        ListNode q = reverse(slow);
        boolean re = true;
        while(q!=null){
        	if(p.val !=q.val){
        		re = false;
        		break;
        	}else{
        		p=p.next;
        		q=q.next;
        	}
        }
        q = reverse(slow);
        mid.next = q;
        return re;
	}

	private ListNode reverse(ListNode node) {
		ListNode pre = null;
		while(node!=null){
			ListNode next = node.next;
			node.next = pre;
			pre = node;
			node = next;
		}
		return pre;
	}
}
