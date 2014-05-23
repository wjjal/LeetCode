import java.util.ArrayList;
import java.util.LinkedList;

//Given a binary tree, return the postorder traversal of its nodes' values.
//
//For example:
//Given binary tree {1,#,2,3},
//   1
//    \
//     2
//    /
//   3
//return [3,2,1].
//
//Note: Recursive solution is trivial, could you do it iteratively?
public class BinaryTreePostorderTraversal {
	public class Solution {
	    public ArrayList<Integer> postorderTraversal(TreeNode root) {
	        ArrayList<Integer> re = new ArrayList<Integer>();
	        if(root == null)
	           return re;
	        //LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
	        reverse(root,re);
	        return re;
	    }
	    public void reverse(TreeNode node,ArrayList<Integer> re){
	        if(node == null)
	           return;
	        reverse(node.left,re);
	        reverse(node.right,re);
	        re.add(node.val);
	    }
	}
	
	public class Solution2 {
	    public ArrayList<Integer> postorderTraversal(TreeNode root) {
	        ArrayList<Integer> re = new ArrayList<Integer>();
	        if(root == null)
	           return re;
	        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
	        stack.push(root);
	        while(!stack.isEmpty()){
	            TreeNode node = stack.pop();
	            re.add(0,node.val);
	            if(node.left != null)
	               stack.push(node.left);
	            if(node.right != null)
	               stack.push(node.right);
	        }
	        return re;
	    }
	}
}
