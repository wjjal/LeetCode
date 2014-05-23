//You are climbing a stair case. It takes n steps to reach to the top.
//
//Each time you can either climb 1 or 2 steps. 
//In how many distinct ways can you climb to the top?

public class ClimbingStairs {
	public class Solution {
		public int climbStairs(int n) {
			if (n == 0)
				return 1;
			int dp[] = new int[n + 1];
			dp[0] = 1;
			dp[1] = 1;
			int i = 2;
			while (i <= n) {
				dp[i] = dp[i - 1] + dp[i - 2];
				i++;
			}
			return dp[n];
		}
	}
}
