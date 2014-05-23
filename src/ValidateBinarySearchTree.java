//Given a binary tree, determine if it is a valid binary search tree (BST).
//
//Assume a BST is defined as follows:
//
//The left subtree of a node contains only nodes with keys less than the node's key.
//The right subtree of a node contains only nodes with keys greater than the node's key.
//Both the left and right subtrees must also be binary search trees.

public class ValidateBinarySearchTree {
	public class Solution {
		public boolean isValidBST(TreeNode root) {
			return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		}

		public boolean check(TreeNode node, int leftval, int rightval) {
			if (node == null)
				return true;
			return (leftval < node.val && rightval > node.val
					&& check(node.left, leftval, node.val) && check(node.right,
						node.val, rightval));
		}
	}
}
