//Say you have an array for which the ith element is the price of a given stock on day i.
//
//If you were only permitted to complete at most one transaction 
//(ie, buy one and sell one share of the stock), 
//design an algorithm to find the maximum profit.

public class L121BestTimeToBuyAndSellStock {
	public class Solution {
		public int maxProfit(int[] prices) {
			int n = prices.length;
			if (n == 0)
				return 0;
			int high = prices[n - 1];
			int maxpro = 0;
			for (int i = n - 2; i >= 0; i--) {
				if (prices[i] > high)
					high = prices[i];
				else
					maxpro = Math.max(maxpro, high - prices[i]);
			}
			return maxpro;
		}
	}
}
