import java.util.ArrayList;
import java.util.List;

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
public class L095UniqueBinarySearchTreesII {
	public class Solution {
		public List<TreeNode> generateTrees(int n) {
			return dfs(1, n);
		}

		private List<TreeNode> dfs(int start, int end) {
			List<TreeNode> result = new ArrayList<TreeNode>();
			if (start > end) {
				result.add(null);
				return result;
			}
			for (int i = start; i <= end; i++) {
				List<TreeNode> lefts = dfs(start, i - 1);
				List<TreeNode> rights = dfs(i + 1, end);
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
