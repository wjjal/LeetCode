//Given preorder and inorder traversal of a tree, construct the binary tree.
//
//Note:
//You may assume that duplicates do not exist in the tree.

public class L105ConstructBinaryTreeFromPreorderAndInorderTraversal {
	public class Solution {
		public TreeNode buildTree(int[] preorder, int[] inorder) {
			if (inorder.length == 0)
				return null;
			return dfs(inorder, 0, inorder.length - 1, preorder, 0,
					preorder.length - 1);
		}

		private TreeNode dfs(int[] inorder, int l1, int r1, int[] preorder,
				int l2, int r2) {
			if (l1 > r1) {
				return null;
			}
			if (l1 == r1) {
				return new TreeNode(inorder[l1]);
			}
			TreeNode node = new TreeNode(preorder[l2]);
			for (int i = l1; i <= r1; i++) {
				if (inorder[i] == preorder[l2]) {
					node.left = dfs(inorder, l1, i - 1, preorder, l2 + 1, l2
							+ i - l1);
					node.right = dfs(inorder, i + 1, r1, preorder, l2 + i - l1
							+ 1, r2);
				}
			}
			return node;
		}
	}
}
