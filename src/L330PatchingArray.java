import java.util.Arrays;

public class L330PatchingArray {
    public class Solution {
        public int minPatches(int[] nums, int n) {
            Arrays.sort(nums);
            int re = 0, i = 0;
            for (long covered = 1; covered <= n; ) {
                if ((i < nums.length && nums[i] > covered) || i >= nums.length) {
                    re++;
                    covered *= 2;
                } else {
                    covered += nums[i];
                    ++i;
                }
            }
            return re;
        }
    }
}
