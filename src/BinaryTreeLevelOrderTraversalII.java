import java.util.ArrayList;
import java.util.LinkedList;

//Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
//(ie, from left to right, level by level from leaf to root).
//
//For example:
//Given binary tree {3,9,20,#,#,15,7},
//    3
//   / \
//  9  20
//    /  \
//   15   7
//return its bottom-up level order traversal as:
//[
//  [15,7]
//  [9,20],
//  [3],
//]
public class BinaryTreeLevelOrderTraversalII {
	public class Solution {
		public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
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
				re.add(0, temp);
			}
			return re;
		}
	}
}
