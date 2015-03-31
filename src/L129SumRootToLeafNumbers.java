import java.util.LinkedList;

//Given a binary tree containing digits from 0-9 only, each root-to-leaf path could 
//represent a number.
//
//An example is the root-to-leaf path 1->2->3 which represents the number 123.
//
//Find the total sum of all root-to-leaf numbers.
//
//For example,
//
//    1
//   / \
//  2   3
//The root-to-leaf path 1->2 represents the number 12.
//The root-to-leaf path 1->3 represents the number 13.
//
//Return the sum = 12 + 13 = 25.

public class L129SumRootToLeafNumbers {
	public class Solution {
		public int sumNumbers(TreeNode root) {
			int sum = 0;
			if (root == null)
				return 0;
			LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
			queue.offer(root);
			while (!queue.isEmpty()) {
				TreeNode node = queue.poll();
				if (node.left == null && node.right == null)
					sum += node.val;
				if (node.left != null) {
					node.left.val += 10 * node.val;
					queue.offer(node.left);
				}
				if (node.right != null) {
					node.right.val += 10 * node.val;
					queue.offer(node.right);
				}
			}
			return sum;
		}
	}
}
