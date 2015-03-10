//Say you have an array for which the ith element is the price of a given stock on day i.
//
//Design an algorithm to find the maximum profit. 
//You may complete at most k transactions.
//
//Note:
//You may not engage in multiple transactions at the same time 
//(ie, you must sell the stock before you buy again).
public class BestTimeToBuyAndSellStockIV {
	public class Solution {
		public int maxProfit(int k, int[] prices) {
			if (prices.length < 2)
				return 0;
			if (k > prices.length / 2)
				return quickSolve(prices);
			int days = prices.length;
			int local[][] = new int[days][k + 1];
			int global[][] = new int[days][k + 1];
			for (int i = 1; i < days; i++) {
				int diff = prices[i] - prices[i - 1];
				for (int j = 1; j <= k; j++) {
					local[i][j] = Math.max(
							global[i - 1][j - 1] + Math.max(0, diff),
							local[i - 1][j] + diff);
					global[i][j] = Math.max(local[i][j], global[i - 1][j]);
				}
			}
			return global[days - 1][k];
		}

		private int quickSolve(int[] prices) {
			int profit = 0;
			for (int i = 1; i < prices.length; i++)
				if (prices[i] > prices[i - 1])
					profit += prices[i] - prices[i - 1];
			return profit;
		}
	}
}
