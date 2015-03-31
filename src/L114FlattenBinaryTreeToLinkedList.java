import java.util.LinkedList;

//Given a binary tree, flatten it to a linked list in-place.
//
//For example,
//Given
//
//         1
//        / \
//       2   5
//      / \   \
//     3   4   6
//The flattened tree should look like:
//   1
//    \
//     2
//      \
//       3
//        \
//         4
//          \
//           5
//            \
//             6

public class L114FlattenBinaryTreeToLinkedList {
	public class Solution {
		public void flatten(TreeNode root) {
			if (root == null)
				return;
			LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
			TreeNode flattened = null;
			TreeNode node = root;
			stack.push(root);
			while (!stack.isEmpty()) {
				node = stack.pop();
				if (node.right != null) {
					stack.push(node.right);
					node.right = null;
				}
				if (node.left != null) {
					stack.push(node.left);
					node.left = null;
				}
				if (flattened == null)
					flattened = node;
				else {
					flattened.right = node;
					flattened = flattened.right;
				}
			}
		}
	}
}
