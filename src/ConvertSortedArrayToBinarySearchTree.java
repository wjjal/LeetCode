//Given an array where elements are sorted in ascending order, 
//convert it to a height balanced BST.

public class ConvertSortedArrayToBinarySearchTree {
	public class Solution {
		public TreeNode sortedArrayToBST(int[] num) {
			int len = num.length;
			if (len == 0)
				return null;
			return subpro(num, 0, len - 1);
		}

		public TreeNode subpro(int[] num, int start, int end) {
			int mid = (start + end) >> 1;
			TreeNode node = new TreeNode(num[mid]);
			if (start <= mid - 1)
				node.left = subpro(num, start, mid - 1);
			if (mid + 1 <= end)
				node.right = subpro(num, mid + 1, end);
			return node;
		}
	}
}
