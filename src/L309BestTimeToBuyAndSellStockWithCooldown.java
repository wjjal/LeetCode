public class L309BestTimeToBuyAndSellStockWithCooldown {
    public class Solution {
        public int maxProfit(int[] prices) {
            int length = prices.length;
            if (length <= 1)
                return 0;
            int dp[][] = new int[3][length];
            //Rest state
            dp[0][0] = 0;
            //buy state
            dp[1][0] = -prices[0];
            //sell_state
            dp[2][0] = Integer.MIN_VALUE;
            for (int i = 1; i < length; ++i) {
                dp[0][i] = Math.max(dp[0][i - 1], dp[2][i - 1]);
                dp[1][i] = Math.max(dp[0][i - 1] - prices[i], dp[1][i - 1]);
                dp[2][i] = dp[1][i - 1] + prices[i];
            }
            return Math.max(dp[0][length - 1], dp[2][length - 1]);
        }
    }
}
