import java.util.HashMap;
import java.util.Map;

public class L337HouseRobberIII {
    public class Solution {
        private Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();

        public int rob(TreeNode root) {
            if (root == null) {
                return 0;
            }
            if (root.left == null && root.right == null) {
                return root.val;
            }
            if (map.containsKey(root)) {
                return map.get(root);
            }
            // choose root
            int sum1 = root.val;
            if (root.left != null) {
                sum1 += rob(root.left.left) + rob(root.left.right);
            }
            if (root.right != null) {
                sum1 += rob(root.right.left) + rob(root.right.right);
            }

            //not choose root
            int sum2 = rob(root.left) + rob(root.right);
            int sum = Math.max(sum1, sum2);
            map.put(root, sum);
            return sum;
        }
    }
}
