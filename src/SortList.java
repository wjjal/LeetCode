//Sort a linked list in O(n log n) time using constant space complexity.
public class SortList {
	public class Solution {
	    public ListNode sortList(ListNode head) {
	        return mergeSort(head);
	    }

		private ListNode mergeSort(ListNode head) {
			 if(head == null || head.next == null)  
			        return head;  
			ListNode slow =head;
			ListNode fast =head;
			while(fast.next!=null && fast.next.next!=null){
				fast=fast.next.next;
				slow=slow.next;
			}
			ListNode head1 = head; 
			ListNode head2 = slow.next;  
		    slow.next = null;     
			head1 =mergeSort(head1);
			head2=mergeSort(head2);
			return mergeTwoLists(head1,head2);
		}

		private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
			ListNode head = new ListNode(0);
			ListNode p = head;
			while (l1 != null && l2 != null) {
				if (l1.val <= l2.val) {
					p.next = l1;
					l1 = l1.next;
					p = p.next;
				} else {
					p.next = l2;
					l2 = l2.next;
					p = p.next;
				}
			}
			if (l1 != null)
				p.next = l1;
			else if (l2 != null)
				p.next = l2;
			return head.next;
		}
	
	}
}
