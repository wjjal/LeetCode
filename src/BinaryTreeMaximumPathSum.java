//Given a binary tree, find the maximum path sum.
//
//The path may start and end at any node in the tree.
//
//For example:
//Given the below binary tree,
//
//       1
//      / \
//     2   3
//Return 6.

public class BinaryTreeMaximumPathSum {
	public class Solution {
		int maxsum = Integer.MIN_VALUE;

		public int maxPathSum(TreeNode root) {
			if (root == null) {
				return 0;
			}
			dfs(root);
			return maxsum;
		}

		public int dfs(TreeNode node) {
			if (node == null) {
				return 0;
			}
			int val = node.val;
			int left = dfs(node.left);
			int right = dfs(node.right);
			if (Math.max(left, right) > 0)
				val = val + Math.max(left, right);
			int sum = node.val;
			if (left > 0)
				sum += left;
			if (right > 0)
				sum += right;
			maxsum = Math.max(maxsum, sum);
			return val;
		}
	}
}
