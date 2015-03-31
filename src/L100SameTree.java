//Given two binary trees, write a function to check if they are equal or not.
//
//Two binary trees are considered equal if they are structurally identical and 
//the nodes have the same value.

public class L100SameTree {
	public class Solution {
		public boolean isSameTree(TreeNode p, TreeNode q) {

			if (p == null && q == null)
				return true;
			if ((p == null && q != null) || (p != null && q == null)
					|| (p.val != q.val))
				return false;
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

		}
	}
}
