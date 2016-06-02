import java.util.Arrays;

public class L324WiggleSortII {
    public class Solution {
        public void wiggleSort(int[] nums) {
            int len = nums.length;
            Arrays.sort(nums);
            int[] temp = new int[nums.length];
            int mid = nums.length % 2 == 0 ? nums.length / 2 - 1 : nums.length / 2;

            int index = 0;
            for (int i = 0; i <= mid; i++) {
                temp[index] = nums[mid - i];
                if (index + 1 < nums.length)
                    temp[index + 1] = nums[nums.length - i - 1];
                index = index + 2;
            }
            for (int i = 0; i < nums.length; i++) {
                nums[i] = temp[i];
            }
        }
    }
}
