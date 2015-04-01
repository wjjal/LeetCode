//You are a professional robber planning to rob houses along a street. 
//Each house has a certain amount of money stashed, 
//the only constraint stopping you from robbing each of them is that 
//adjacent houses have security system connected and it will automatically contact 
//the police if two adjacent houses were broken into on the same night.
//
//Given a list of non-negative integers representing the amount of money of each house, 
//determine the maximum amount of money you can rob tonight without alerting the police.

public class L198HouseRobber {
	public static void main(String[] args) {
		int[] a = { 2, 1, 1, 2 };
		System.out.println(new L198HouseRobber().new Solution().rob(a));
	}

	public class Solution {
		public int rob(int[] num) {
			int len = num.length;
			if (len == 0)
				return 0;
			if (len == 1)
				return num[0];
			int dp[] = new int[len];
			dp[0] = num[0];
			dp[1] = Math.max(num[0], num[1]);
			for (int i = 2; i < len; i++) {
				dp[i] = Math.max(dp[i - 1], dp[i - 2] + num[i]);
			}
			return dp[len - 1];
		}

		public int rob2(int[] num) {
			int len = num.length;
			if (len == 0)
				return 0;
			if (len == 1)
				return num[0];
			int pre = num[0];
			int cur = Math.max(num[0], num[1]);
			for (int i = 2; i < len; i++) {
				int next = Math.max(cur, pre + num[i]);
				pre = cur;
				cur = next;
			}
			return cur;
		}

	}
}
