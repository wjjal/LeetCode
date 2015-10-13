import java.util.Arrays;

public class L279PerfectSquares {
    public class Solution {
        public int numSquares(int n) {
            int[] dp = new int[n + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for (int i = 1; i <= n; ++i) {
                int min = Integer.MAX_VALUE;
                for (int j = 1; i - j * j >= 0; ++j) {
                    min = Math.min(dp[i - j * j] + 1, min);
                }
                dp[i] = min;
            }
            return dp[n];
        }

        public int numSquares2(int n) {
            if (n < 1)
                return 0;
            return squares(n, (int) Math.sqrt(n), 1, Integer.MAX_VALUE);
        }

        private int squares(int n, int root, int count, int sqmin) {
            if (count >= sqmin)
                return sqmin;
            int min = 0;
            for (; root > 0; --root) {
                int sqr = root * root;
                if (n < sqr) {
                    continue;
                } else if (n % sqr == 0) {
                    min = count + (n / sqr - 1);
                } else {
                    min = squares(n - sqr, root, count + 1, sqmin);
                }
                sqmin = Math.min(min, sqmin);
            }
            return sqmin;
        }
    }
}
