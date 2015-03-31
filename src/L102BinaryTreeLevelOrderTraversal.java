import java.util.ArrayList;
import java.util.LinkedList;

//Given a binary tree, return the level order traversal of its nodes' values.
//(ie, from left to right, level by level).
//
//For example:
//Given binary tree {3,9,20,#,#,15,7},
//    3
//   / \
//  9  20
//    /  \
//   15   7
//return its level order traversal as:
//[
//  [3],
//  [9,20],
//  [15,7]
//]

public class L102BinaryTreeLevelOrderTraversal {
	public class Solution {
		public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
			ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
			if (root == null)
				return re;
			LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
			queue.offer(root);
			while (!queue.isEmpty()) {
				int num = queue.size();
				ArrayList<Integer> temp = new ArrayList<Integer>();
				for (int i = 0; i < num; i++) {
					TreeNode node = queue.poll();
					temp.add(node.val);
					if (node.left != null)
						queue.offer(node.left);
					if (node.right != null)
						queue.offer(node.right);
				}
				re.add(temp);
			}
			return re;
		}
	}
}
