//Given a binary tree, find its maximum depth.
//
//The maximum depth is the number of nodes along the longest path from 
//the root node down to the farthest leaf node.

public class L104MaximumDepthOfBinaryTree {
	public class Solution {
		public int maxDepth(TreeNode root) {
			return maxDepth(root,0);
		}
		
		private int maxDepth(TreeNode node,int depth){
			if(node == null)
				return 0;
			return Math.max(maxDepth(node.left,depth),maxDepth(node.right,depth))+1;
		}
	}
}
