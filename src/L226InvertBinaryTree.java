import java.util.*;

public class L226InvertBinaryTree {
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(4);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(7);
		TreeNode n4 = new TreeNode(1);
		TreeNode n5 = new TreeNode(3);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(9);
		n1.left = n2;
		n1.right=n3;
		n2.left = n4;
		n2.right =n5;
		n3.left =n6;
		n3.right=n7;
		invertTree1(n1);
	}

	public TreeNode invertTree(TreeNode root) {
		if (root == null || (root.left == null && root.right == null))
			return root;
		TreeNode right = invertTree(root.left);
		TreeNode left = invertTree(root.right);
		root.left = left;
		root.right = right;
		return root;
	}

	public static TreeNode invertTree1(TreeNode root) {
		TreeNode cur = root, prev = null;
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		while (cur != null || !stack.isEmpty()) {
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			} else {
				TreeNode node = stack.peek();
				if (node.right != null && node.right != prev) {
					cur = node.right;
				} else {
					swapBranch(node);
					prev = stack.pop();
				}
			}
		}
		return root;
	}

	private static void swapBranch(TreeNode node) {
		TreeNode tmp = node.left;
		node.left = node.right;
		node.right = tmp;
	}
}
