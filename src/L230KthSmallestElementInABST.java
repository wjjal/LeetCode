public class L230KthSmallestElementInABST {
	private int res;
	private int k;

	public int kthSmallest(TreeNode root, int k) {
		this.k = k;
		preorder(root);
		return this.res;
	}

	private void preorder(TreeNode node) {
		if (node == null)
			return;
		preorder(node.left);
		this.k--;
		if (this.k == 0) {
			this.res = node.val;
			return;
		}
		preorder(node.right);
	}
}
