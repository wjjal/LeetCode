//Implement an iterator over a binary search tree (BST). 
//Your iterator will be initialized with the root node of a BST.
//
//Calling next() will return the next smallest number in the BST.
//
//Note: next() and hasNext() should run in O(1) time and uses O(h) memory, 
//where h is the height of the tree.


/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */

public class L173BinarySearchTreeIterator {
	public class BSTIterator {
		TreeNode cur;

		public BSTIterator(TreeNode root) {
			cur = root;
		}

		/** @return whether we have a next smallest number */
		public boolean hasNext() {
			return cur != null;
		}

		/** @return the next smallest number */
		public int next() {
			while (cur != null) {
				if (cur.left == null) {
					int num = cur.val;
					cur = cur.right;
					return num;
				} else {
					TreeNode pre = cur.left;
					while (pre.right != null && pre.right != cur) {
						pre = pre.right;
					}
					if (pre.right == null) {
						pre.right = cur;
						cur = cur.left;
					} else {
						int num = cur.val;
						pre.right = null;
						cur = cur.right;
						return num;
					}
				}
			}
			return -1;
		}
	}
}
