public class L312BurstBalloons {
    public class Solution {
        public int maxCoins(int[] nums) {
            int length = nums.length;
            if (length == 0) {
                return 0;
            }
            int[] array = new int[length + 2];
            array[0] = 1;
            array[length + 1] = 1;
            for (int i = 0; i < length; ++i) {
                array[i + 1] = nums[i];
            }
            int[][] dp = new int[length + 2][length + 2];
            return help(array, dp, 0, length + 1);
        }

        private int help(int[] array, int[][] dp, int i, int j) {
            //i,j相邻
            if (i + 1 >= j) {
                return 0;
            }
            if (dp[i][j] > 0) {
                return dp[i][j];
            }
            int re = 0;
            for (int k = i + 1; k < j; ++k) {
                re = Math.max(re, help(array, dp, i, k) + help(array, dp, k, j) + array[i] * array[k] * array[j]);
            }
            dp[i][j] = re;
            return re;
        }
    }
}
