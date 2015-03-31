//Say you have an array for which the ith element is the price of a given stock on day i.
//
//Design an algorithm to find the maximum profit. You may complete at most two transactions.
//
//Note:
//You may not engage in multiple transactions at the same time 
//(ie, you must sell the stock before you buy again).
public class L123BestTimeToBuyAndSellStockIII {
	public class Solution {
		public int maxProfit(int[] prices) {
			int n = prices.length;
			if (n == 0)
				return 0;
			int maxpro = 0;
			int maxltor[] = new int[n];
			int maxrtol[] = new int[n];
			int low = prices[0], high = prices[0];
			for (int i = 1; i < n; i++) {
				maxltor[i] = Math.max(maxltor[i - 1], prices[i] - low);
				if (prices[i] < low)
					low = prices[i];
			}
			low = prices[n - 1];
			high = prices[n - 1];
			for (int i = n - 2; i >= 0; i--) {
				maxrtol[i] = Math.max(maxrtol[i + 1], high - prices[i]);
				if (prices[i] > high)
					high = prices[i];
			}
			for (int i = 0; i < n; i++)
				maxpro = Math.max(maxpro, maxltor[i] + maxrtol[i]);
			return maxpro;
		}
	}
}
