import java.util.LinkedList;

//Given a binary tree and a sum, determine if the tree has a root-to-leaf path 
//such that adding up all the values along the path equals the given sum.
//
//For example:
//Given the below binary tree and sum = 22,
//              5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \      \
//        7    2      1
//return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

public class L112PathSum {

	public class Solution {
		public boolean hasPathSum(TreeNode root, int sum) {
			if (root == null)
				return false;

			LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
			LinkedList<Integer> values = new LinkedList<Integer>();

			nodes.push(root);
			values.push(root.val);

			while (!nodes.isEmpty()) {
				TreeNode curr = nodes.pop();
				int sumValue = values.pop();

				if (curr.left == null && curr.right == null && sumValue == sum) {
					return true;
				}

				if (curr.left != null) {
					nodes.push(curr.left);
					values.push(sumValue + curr.left.val);
				}

				if (curr.right != null) {
					nodes.push(curr.right);
					values.push(sumValue + curr.right.val);
				}
			}

			return false;
		}
	}
	
	public class Solution2 {
	    public boolean hasPathSum(TreeNode root, int sum) {
				if (root == null)
					return false;
				int leftsum = sum - root.val;
				// 找到sum，并且为叶子节点
				if (leftsum == 0 && root.left == null && root.right == null) {
					return true;
				}
				boolean left = hasPathSum(root.left, leftsum);
				boolean right = hasPathSum(root.right, leftsum);
				return left || right;
			}
	}

}
