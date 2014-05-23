import java.util.LinkedList;

//Given a binary tree, find its minimum depth.
//
//The minimum depth is the number of nodes along the shortest path from the root node 
//down to the nearest leaf node.

public class MinimumDepthOfBinaryTree {
	public class Solution {
		public int minDepth(TreeNode root) {
			if (root == null)
				return 0;
			int mindepth = 0;
			LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
			queue.offer(root);
			while (queue != null) {
				int num = queue.size();
				mindepth++;
				for (int i = 0; i < num; i++) {
					TreeNode node = queue.poll();
					if (node.left == null && node.right == null)
						return mindepth;
					if (node.left != null)
						queue.offer(node.left);
					if (node.right != null)
						queue.offer(node.right);
				}
			}
			return mindepth;
		}
	}
}
