public class L237DeleteNodeInALinkedList {
    public class Solution {
        public void deleteNode(ListNode node) {
            ListNode pre = node;
            while (node.next != null) {
                ListNode next = node.next;
                node.val = next.val;
                pre = node;
                node = next;
            }
            pre.next = null;
        }
    }
}
