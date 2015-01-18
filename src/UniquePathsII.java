//Follow up for "Unique Paths":
//
//Now consider if some obstacles are added to the grids.
//How many unique paths would there be?
//
//An obstacle and empty space is marked as 1 and 0 respectively in the grid.
//
//For example,
//There is one obstacle in the middle of a 3x3 grid as illustrated below.
//
//[
//  [0,0,0],
//  [0,1,0],
//  [0,0,0]
//]
//The total number of unique paths is 2.
public class UniquePathsII {
	public static void main(String[] args) {
		int[][] a = { { 1 }, { 0 } };
		System.out.println(new UniquePathsII().new Solution2()
				.uniquePathsWithObstacles(a));
	}

	public class Solution {
		public int uniquePathsWithObstacles(int[][] obstacleGrid) {
			int m = obstacleGrid.length;
			if (m == 0)
				return 0;
			int n = obstacleGrid[0].length;
			int[][] paths = new int[m][n];
			if (obstacleGrid[0][0] == 0)
				paths[0][0] = 1;
			else
				return 0;
			for (int i = 1; i < m; i++) {
				if (obstacleGrid[i][0] != 1)
					paths[i][0] = paths[i - 1][0];
			}
			for (int j = 1; j < n; j++) {
				if (obstacleGrid[0][j] != 1)
					paths[0][j] = paths[0][j - 1];
			}
			for (int i = 1; i < m; i++) {
				for (int j = 1; j < n; j++) {
					if (obstacleGrid[i][j] != 1)
						paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
				}
			}
			return paths[m - 1][n - 1];
		}
	}

	public class Solution2 {
		public int uniquePathsWithObstacles(int[][] obstacleGrid) {
			int m = obstacleGrid.length;
			int n = obstacleGrid[0].length;
			int dp[] = new int[n];
			dp[0] = 1;
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (obstacleGrid[i][j] == 1)
						dp[j] = 0;
					else {
						if (j > 0)
							dp[j] += dp[j - 1];
					}
				}
			}
			return dp[n - 1];
		}
	}
}
