import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L199BinaryTreeRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> re = new ArrayList<Integer>();
		if(root==null)
			return re;
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()){
			int len = queue.size();
			for(int i=0;i<len;i++){
				TreeNode node = queue.poll();
				if(i==len-1)
					re.add(node.val);
				if(node.left!=null)
					queue.offer(node.left);
				if(node.right!=null)
					queue.offer(node.right);
			}
		}
		return re;
	}
}
