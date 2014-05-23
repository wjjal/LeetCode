import java.util.LinkedList;

//Follow up for problem "Populating Next Right Pointers in Each Node".
//
//What if the given tree could be any binary tree? Would your previous solution still work?
//
//Note:
//
//You may only use constant extra space.
//For example,
//Given the following binary tree,
//         1
//       /  \
//      2    3
//     / \    \
//    4   5    7
//After calling your function, the tree should look like:
//         1 -> NULL
//       /  \
//      2 -> 3 -> NULL
//     / \    \
//    4-> 5 -> 7 -> NULL

public class PopulatingNextRightPointersInEachNodeII {
	public class Solution {
		public void connect(TreeLinkNode root) {
			if (root == null)
				return;
			LinkedList<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
			queue.offer(root);
			while (!queue.isEmpty()) {
				int num = queue.size();
				TreeLinkNode pre = null;
				for (int i = 0; i < num; i++) {
					TreeLinkNode cur = queue.poll();
					if (pre != null)
						pre.next = cur;
					pre = cur;
					if (cur.left != null)
						queue.offer(cur.left);
					if (cur.right != null)
						queue.offer(cur.right);
				}
				pre.next = null;
			}
		}
	}
}
