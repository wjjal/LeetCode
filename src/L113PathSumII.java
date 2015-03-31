import java.util.ArrayList;

//Given a binary tree and a sum, find all root-to-leaf paths where each path's 
//sum equals the given sum.
//
//For example:
//Given the below binary tree and sum = 22,
//              5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
//return
//[
//   [5,4,11,2],
//   [5,8,4,5]
//]

public class L113PathSumII {
	public class Solution {
		public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
			ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> path = new ArrayList<Integer>();
			dfs(root, sum, re, path);
			return re;
		}

		private void dfs(TreeNode node, int sum,
				ArrayList<ArrayList<Integer>> re, ArrayList<Integer> path) {
			if (node == null)
				return;
			if (node.left == null && node.right == null && node.val == sum) {
				path.add(node.val);
				ArrayList<Integer> clone = new ArrayList<Integer>(path);
				re.add(clone);
				path.remove(path.size() - 1);
				return;
			}
			path.add(node.val);
			dfs(node.left, sum - node.val, re, path);
			dfs(node.right, sum - node.val, re, path);
			path.remove(path.size() - 1);
		}
	}
}
