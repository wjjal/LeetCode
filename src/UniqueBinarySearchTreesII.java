import java.util.ArrayList;

//Given n, generate all structurally unique BST's (binary search trees) 
//that store values 1...n.
//
//For example,
//Given n = 3, your program should return all 5 unique BST's shown below.
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
public class UniqueBinarySearchTreesII {
	public class Solution {
		public ArrayList<TreeNode> generateTrees(int n) {
			return dfs(1, n);
		}

		private ArrayList<TreeNode> dfs(int start, int end) {
			ArrayList<TreeNode> result = new ArrayList<>();
			if (start > end) {
				result.add(null);
				return result;
			}
			for (int i = start; i <= end; i++) {
				// left和right至少会有一个元素null！
				ArrayList<TreeNode> lefts = dfs(start, i - 1);
				ArrayList<TreeNode> rights = dfs(i + 1, end);
				for (TreeNode left : lefts) {
					for (TreeNode right : rights) {
						TreeNode node = new TreeNode(i);
						node.left = left;
						node.right = right;
						result.add(node);
					}
				}
			}
			return result;
		}
	}
}
