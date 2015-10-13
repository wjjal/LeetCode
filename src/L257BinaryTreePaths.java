import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L257BinaryTreePaths {
    public class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
            List<String> re = new ArrayList<String>();
            if (root == null)
                return re;
            dfs(root, "", re);
            return re;
        }

        public void dfs(TreeNode cur, String tmp, List<String> re) {
            if (cur.left == null && cur.right == null) {
                tmp += cur.val;
                re.add(tmp);
                return;
            }
            tmp += +cur.val + "->";
            if (cur.left != null) {
                dfs(cur.left, tmp, re);
            }
            if (cur.right != null) {
                dfs(cur.right, tmp, re);
            }
        }
    }
}
