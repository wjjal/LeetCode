import java.util.ArrayList;
import java.util.LinkedList;

//Given a binary tree, return the inorder traversal of its nodes' values.
//
//For example:
//Given binary tree {1,#,2,3},
//   1
//    \
//     2
//    /
//   3
//return [1,3,2].
//
//Note: Recursive solution is trivial, could you do it iteratively?

public class BinaryTreeInorderTraversal {
	public class Solution {
		public ArrayList<Integer> inorderTraversal(TreeNode root) {
			ArrayList<Integer> re = new ArrayList<Integer>();
			LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
			TreeNode node = root;
			while (node != null || !stack.isEmpty()) {
				if (node != null) {
					stack.push(node);
					node = node.left;
				} else {
					node = stack.pop();
					re.add(node.val);
					node = node.right;
				}
			}
			return re;
		}
	}
}
