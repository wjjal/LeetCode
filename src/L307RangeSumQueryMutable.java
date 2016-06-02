import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class L307RangeSumQueryMutable {
    public static void main(String[] args) {
        int a[] = {1, 3, 5};
        NumArray na = new L307RangeSumQueryMutable().new NumArray(a);
        System.out.println(na.sumRange(0, 2));
        na.update(1, 2);
        System.out.println(na.sumRange(0, 2));
    }

    public class NumArray {
        class SegmentTreeNode {
            int start, end;
            SegmentTreeNode left, right;
            int sum;

            public SegmentTreeNode(int start, int end) {
                this.start = start;
                this.end = end;
                this.left = null;
                this.right = null;
                sum = 0;
            }
        }

        SegmentTreeNode root = null;


        public NumArray(int[] nums) {
            root = buildTree(nums, 0, nums.length - 1);
        }

        void update(int i, int val) {
            update(root, i, val);
        }

        public int sumRange(int i, int j) {
            return sumRange(root, i, j);
        }

        private SegmentTreeNode buildTree(int[] nums, int start, int end) {
            if (start > end) {
                return null;
            } else {
                SegmentTreeNode ret = new SegmentTreeNode(start, end);
                if (start == end) {
                    ret.sum = nums[start];
                } else {
                    int mid = start + ((end - start) >> 1);
                    ret.left = buildTree(nums, start, mid);
                    ret.right = buildTree(nums, mid + 1, end);
                    ret.sum = ret.left.sum + ret.right.sum;
                }
                return ret;
            }
        }

        private void update(SegmentTreeNode node, int pos, int val) {
            if (node.start == node.end) {
                node.sum = val;
            } else {
                int mid = node.start + ((node.end - node.start) >> 1);
                if (pos <= mid) {
                    update(node.left, pos, val);
                } else {
                    update(node.right, pos, val);
                }
                node.sum = node.left.sum + node.right.sum;
            }
        }


        private int sumRange(SegmentTreeNode node, int start, int end) {
            if (node == null) {
                return 0;
            }
            if (node.start == start && node.end == end) {
                return node.sum;
            } else {
                int mid = node.start + ((node.end - node.start) >> 1);
                if (start > mid) {
                    return sumRange(node.right, start, end);
                } else if (end < mid) {
                    return sumRange(node.left, start, end);
                } else {
                    return sumRange(node.left, start, mid) + sumRange(node.right, mid + 1, end);
                }
            }
        }
    }
}
