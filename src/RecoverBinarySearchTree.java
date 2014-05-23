//Two elements of a binary search tree (BST) are swapped by mistake.
//
//Recover the tree without changing its structure.
//
//Note:
//A solution using O(n) space is pretty straight forward. 
//Could you devise a constant space solution?

public class RecoverBinarySearchTree {
	public class Solution {
		TreeNode pre;
		TreeNode first;
		TreeNode second;

		public void inorder(TreeNode root) {
			if (root == null) {
				return;
			}
			inorder(root.left);
			if (pre == null) {
				pre = root;
			} else {
				if (pre.val > root.val) {
					if (first == null) {
						first = pre;
					}
					second = root;
				}
				pre = root;
			}
			inorder(root.right);
		}

		public void recoverTree(TreeNode root) {
			pre = null;
			first = null;
			second = null;
			inorder(root);
			if (first != null && second != null) {
				int tmp = first.val;
				first.val = second.val;
				second.val = tmp;
			}
		}
	}

	public class Solution2 {
		TreeNode p, q;
		TreeNode pre;

		public void recoverTree(TreeNode root) {
			if (root == null)
				return;
			getWrong(root);
			int tmp = p.val;
			p.val = q.val;
			q.val = tmp;
		}

		public void getWrong(TreeNode root) {
			if (root == null)
				return;
			getWrong(root.left);
			if (pre != null && root.val < pre.val) {
				if (p == null) {
					p = pre;
					q = root;
				} else
					q = root;
			}
			pre = root;
			getWrong(root.right);
		}
	}
}
