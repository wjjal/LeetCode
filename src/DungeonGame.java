public class DungeonGame {
	public static void main(String[] args) {
		int a[][] = { { 0, 0 }, { -5, -4 } };
		System.out.println(new DungeonGame().new Solution()
				.calculateMinimumHP(a));
	}

	public class Solution {
		public int calculateMinimumHP(int[][] dungeon) {
			int row = dungeon.length;
			int col = dungeon[0].length;
			int dp[][] = new int[row][col];
			if (dungeon[row - 1][col - 1] >= 0)
				dp[row - 1][col - 1] = 1;
			else
				dp[row - 1][col - 1] = 1 - dungeon[row - 1][col - 1];
			for (int i = row - 2; i >= 0; i--) {
				if (dungeon[i][col - 1] >= dp[i + 1][col - 1])
					dp[i][col - 1] = 1;
				else
					dp[i][col - 1] = dp[i + 1][col - 1] - dungeon[i][col - 1];
			}
			for (int j = col - 2; j >= 0; j--) {
				if (dungeon[row - 1][j] >= dp[row - 1][j + 1])
					dp[row - 1][j] = 1;
				else
					dp[row - 1][j] = dp[row - 1][j + 1] - dungeon[row - 1][j];
			}
			for (int i = row - 2; i >= 0; i--) {
				for (int j = col - 2; j >= 0; j--) {
					int right = dungeon[i][j] >= dp[i][j + 1] ? 1
							: dp[i][j + 1] - dungeon[i][j];
					int down = dungeon[i][j] >= dp[i + 1][j] ? 1 : dp[i + 1][j]
							- dungeon[i][j];
					dp[i][j] = Math.min(right, down);
				}
			}
			return dp[0][0];
		}
	}

	public class Solution2 {
		public int calculateMinimumHP(int[][] dungeon) {
			int m = dungeon.length;
			int n = dungeon[0].length;
			int dp[] = new int[n];
			dp[n - 1] = dungeon[m - 1][n - 1] >= 0 ? 1
					: 1 - dungeon[m - 1][n - 1];
			for (int i = m - 1; i >= 0; --i) {
				for (int j = n - ((i == m - 1) ? (2) : 1); j >= 0; --j) {
					if (i + 1 < m) {
						dp[j] = Math.max(1, dp[j] - dungeon[i][j]);
						if (j + 1 < n)
							dp[j] = Math.min(dp[j],
									Math.max(1, dp[j + 1] - dungeon[i][j]));
					} else {
						dp[j] = Math.max(1, dp[j + 1] - dungeon[i][j]);
					}
				}
			}
			return dp[0];
		}
	}
}
