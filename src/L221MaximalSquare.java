public class L221MaximalSquare {
	public int maximalSquare(char[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int re = 0;
		int dp[][] = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			dp[i][0] = (matrix[i][0] == '1' ? 1 : 0);
			re = Math.max(re, dp[i][0]);
		}
		for (int j = 0; j < matrix[0].length; j++) {
			dp[0][j] = (matrix[0][j] == '1' ? 1 : 0);
			re = Math.max(re, dp[0][j]);
		}
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				dp[i][j] = matrix[i][j] == '1' ? Math.min(
						Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1
						: 0;
				re = Math.max(re, dp[i][j]);
			}
		}
		return re * re;
	}
}
