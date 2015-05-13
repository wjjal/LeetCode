public class L200NumberOfIslands {
	public static void main(String[] args) {
		char[][] grid = { { '1', '1', '1' }, { '0', '1', '0' },
				{ '1', '1', '1' } };
		System.out.println(new L200NumberOfIslands().numIslands(grid));
	}

	public int numIslands(char[][] grid) {
		int m = grid.length;
		if (m == 0)
			return 0;
		int n = grid[0].length;
		int re = 0;
		boolean[][] visit = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1' && !visit[i][j]) {
					bfs(i, j, m, n, grid, visit);
					re++;
				}
			}
		}
		return re;
	}

	private void bfs(int i, int j, int m, int n, char[][] grid,
			boolean[][] visit) {
		if (i < 0 || j < 0 || i == m || j == n || grid[i][j] == '0'
				|| visit[i][j] || grid[i][j] == '0')
			return;
		visit[i][j] = true;
		bfs(i - 1, j, m, n, grid, visit);
		bfs(i + 1, j, m, n, grid, visit);
		bfs(i, j - 1, m, n, grid, visit);
		bfs(i, j + 1, m, n, grid, visit);
	}
}
