import java.util.LinkedList;

public class L236LowestCommonAncestorOfABinaryTree {
    public class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            LinkedList<TreeNode> pancestor = new LinkedList<TreeNode>();
            LinkedList<TreeNode> qancestor = new LinkedList<TreeNode>();
            dfs(root, p, pancestor);
            dfs(root, q, qancestor);
            TreeNode re = root;
            while (!pancestor.isEmpty() && !qancestor.isEmpty()
                    && pancestor.getFirst() == qancestor.getFirst()) {
                re = pancestor.removeFirst();
                qancestor.removeFirst();
            }
            return re;
        }

        private boolean dfs(TreeNode cur, TreeNode node,
                            LinkedList<TreeNode> ancestor) {
            if (cur == null) {
                return false;
            }
            if (cur == node) {
                ancestor.add(node);
                return true;
            }
            ancestor.add(cur);
            if (dfs(cur.left, node, ancestor)) {
                return true;
            }

            if (dfs(cur.right, node, ancestor)) {
                return true;
            } else {
                ancestor.removeLast();
                return false;
            }
        }
    }
}
