//Given a binary tree, check whether it is a mirror of itself 
//(ie, symmetric around its center).
//
//For example, this binary tree is symmetric:
//
//    1
//   / \
//  2   2
// / \ / \
//3  4 4  3
//But the following is not:
//    1
//   / \
//  2   2
//   \   \
//   3    3
//Note:
//Bonus points if you could solve it both recursively and iteratively.

public class SymmetricTree {
	public class Solution {
		public boolean isSymmetric(TreeNode root) {
			if (root == null)
				return true;
			return isSymmetric(root.left, root.right);
		}

		private boolean isSymmetric(TreeNode lt, TreeNode rt) {
			if (lt == null && rt == null)
				return true;
			if ((lt == null && rt != null) || (lt != null && rt == null)
					|| lt.val != rt.val)
				return false;
			return isSymmetric(lt.left, rt.right)
					&& isSymmetric(lt.right, rt.left);
		}
	}
}
