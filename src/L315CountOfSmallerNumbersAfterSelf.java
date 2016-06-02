import java.util.LinkedList;
import java.util.List;

public class L315CountOfSmallerNumbersAfterSelf {
    public class Solution {
        public List<Integer> countSmaller(int[] nums) {
            TreeNode root = null;
            LinkedList<Integer> re = new LinkedList<Integer>();
            for (int i = nums.length - 1; i >= 0; --i) {
                root = add(root, nums[i]);
                re.addFirst(rank(root, nums[i]));
            }
            return re;
        }

        private class TreeNode {
            private int size, val;
            private TreeNode left, right;

            public TreeNode(int val) {
                this.val = val;
                size = 1;
            }
        }

        private TreeNode add(TreeNode x, int val) {
            if (x == null) {
                return new TreeNode(val);
            }
            if (x.val < val) {
                x.right = add(x.right, val);
            } else if (x.val > val) {
                x.left = add(x.left, val);
            }
            x.size++;
            return x;
        }

        private int rank(TreeNode x, int val) {
            if (x == null) {
                return 0;
            }
            if (x.val < val) {
                return x.size - size(x.right) + rank(x.right, val);
            } else if (x.val == val) {
                return size(x.left);
            } else {
                return rank(x.left, val);
            }
        }

        private int size(TreeNode x) {
            if (x == null) {
                return 0;
            }
            return x.size;
        }
    }
}
