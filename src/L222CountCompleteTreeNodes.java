public class L222CountCompleteTreeNodes {
	public int countNodes(TreeNode root) {
		if (root == null)
			return 0;
		TreeNode node = root;
		int depth = 0;
		while (node != null) {
			depth++;
			node = node.left;
		}
		int start = 0;
		int end = (1 << (depth - 1)) - 1;
		while (start <= end) {
			if (start == end) {
				if (isLeafNode(root, start, depth - 1)) {
					start++;
				}
				break;
			}
			int mid = start + (end - start) / 2;
			if (isLeafNode(root, mid, depth - 1))
				start = mid + 1;
			else
				end = mid;
		}
		return (1 << (depth - 1)) + start - 1;
	}

	boolean isLeafNode(TreeNode node, int index, int depth) {
		while (depth > 0) {
			if ((index & (1 << (depth - 1))) == 0) {
				node = node.left;
			} else {
				node = node.right;
			}
			depth--;
		}
		return node != null;
	}
}
