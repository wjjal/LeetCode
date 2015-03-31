import java.util.LinkedList;

//Given a binary tree
//
//    struct TreeLinkNode {
//      TreeLinkNode *left;
//      TreeLinkNode *right;
//      TreeLinkNode *next;
//    }
//Populate each next pointer to point to its next right node. 
//If there is no next right node, the next pointer should be set to NULL.
//
//Initially, all next pointers are set to NULL.
//
//Note:
//
//You may only use constant extra space.
//You may assume that it is a perfect binary tree 
//(ie, all leaves are at the same level, and every parent has two children).
//For example,
//Given the following perfect binary tree,
//         1
//       /  \
//      2    3
//     / \  / \
//    4  5  6  7
//After calling your function, the tree should look like:
//         1 -> NULL
//       /  \
//      2 -> 3 -> NULL
//     / \  / \
//    4->5->6->7 -> NULL

public class L116PopulatingNextRightPointersInEachNode {
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
