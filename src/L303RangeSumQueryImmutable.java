public class L303RangeSumQueryImmutable {
    public class NumArray {
        int arr[];
        int sum[];

        public NumArray(int[] nums) {
            int len = nums.length;
            arr = new int[len];
            sum = new int[len + 1];
            for (int i = 0; i < len; ++i) {
                arr[i] = nums[i];
                sum[i + 1] = sum[i] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return sum[j + 1] - sum[i];
        }
    }


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
}
