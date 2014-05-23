import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

//Given a binary tree, return the zigzag level order traversal of its nodes' values. 
//(ie, from left to right, then right to left for the next level and alternate between).
//
//For example:
//Given binary tree {3,9,20,#,#,15,7},
//    3
//   / \
//  9  20
//    /  \
//   15   7
//return its zigzag level order traversal as:
//[
//  [3],
//  [20,9],
//  [15,7]
//]

public class BinaryTreeZigzagLevelOrderTraversal {
	public class Solution {
		public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
			ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
			if (root == null)
				return re;
			LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
			queue.push(root);
			boolean reverse = false;
			while (!queue.isEmpty()) {
				int num = queue.size();
				ArrayList<Integer> level = new ArrayList<Integer>();
				for (int i = 1; i <= num; i++) {
					TreeNode node = queue.poll();
					level.add(node.val);
					if (node.left != null)
						queue.offer(node.left);
					if (node.right != null)
						queue.offer(node.right);
				}
				if (reverse) {
					Collections.reverse(level);
					reverse = false;
				} else
					reverse = true;
				re.add(level);
			}
			return re;
		}
	}

}
