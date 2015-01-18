//A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
//
//The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
//
//How many possible unique paths are there?

public class UniquePaths {
	public class Solution {
		public int uniquePaths(int m, int n) {
			int[][] paths = new int[m][n];
			for (int i = 0; i < m; i++)
				paths[i][0] = 1;
			for (int j = 0; j < n; j++)
				paths[0][j] = 1;
			for (int i = 1; i < m; i++) {
				for (int j = 1; j < n; j++) {
					paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
				}
			}
			return paths[m - 1][n - 1];
		}
	}

	public class Solution2 {
		public int uniquePaths(int m, int n) {
			int dp[] = new int[n];
			dp[0] = 1;
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (j > 0)
						dp[j] += dp[j - 1];
				}
			}
			return dp[n - 1];
		}
	}

	public class Solution3 {
		// 等价于m+n-2中选取m-1个
		public int uniquePaths(int m, int n) {
			double a = 1;
			double b = 1;
			int small = Math.min(m - 1, n - 1);
			int big = Math.max(m - 1, n - 1);
			for (int i = 1; i <= small; i++) {
				a *= big + i;
				b *= i;
			}
			return (int) (a / b);
		}
	}
}
