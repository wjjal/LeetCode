import java.util.ArrayList;
import java.util.LinkedList;

//Given a binary tree, return the preorder traversal of its nodes' values.
//
//For example:
//Given binary tree {1,#,2,3},
//   1
//    \
//     2
//    /
//   3
//return [1,2,3].
//
//Note: Recursive solution is trivial, could you do it iteratively?
public class BinaryTreePreorderTraversal {
	public class Solution {
		public ArrayList<Integer> preorderTraversal(TreeNode root) {
			ArrayList<Integer> re = new ArrayList<Integer>();
			LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
			if (root == null)
				return re;
			stack.push(root);
			while (!stack.isEmpty()) {
				TreeNode node = stack.pop();
				re.add(node.val);
				if (node.right != null)
					stack.push(node.right);
				if (node.left != null)
					stack.push(node.left);
			}
			return re;
		}
	}
}
