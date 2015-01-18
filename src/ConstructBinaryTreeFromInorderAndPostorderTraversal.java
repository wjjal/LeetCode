//Given inorder and postorder traversal of a tree, construct the binary tree.
//
//Note:
//You may assume that duplicates do not exist in the tree.

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	public class Solution {
		public TreeNode buildTree(int[] inorder, int[] postorder) {
			if (inorder.length == 0)
				return null;
			return dfs(inorder, 0, inorder.length - 1, postorder, 0,
					postorder.length - 1);
		}

		public TreeNode dfs(int[] inorder, int l1, int r1, int[] postorder,
				int l2, int r2) {
			if (l1 > r1) {
				return null;
			}
			TreeNode node = new TreeNode(postorder[r2]);
			for (int i = l1; i <= r1; i++) {
				if (inorder[i] == postorder[r2]) {
					node.left = dfs(inorder, l1, i - 1, postorder, l2, l2 + i
							- 1 - l1);
					node.right = dfs(inorder, i + 1, r1, postorder,
							l2 + i - l1, r2 - 1);
				}
			}
			return node;
		}
	}
}
