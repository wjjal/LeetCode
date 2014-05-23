//Follow up for N-Queens problem.
//
//Now, instead outputting board configurations, 
//return the total number of distinct solutions.

public class NQueensII {
	public class Solution {
		int res;

		public int totalNQueens(int n) {
			res = 0;
			int[] loc = new int[n];
			dfs(loc, 0, n);
			return res;
		}

		private void dfs(int[] loc, int cur, int n) {
			if (cur == n)
				res++;
			else {
				for (int i = 0; i < n; i++) {
					loc[cur] = i;
					if (isValid(loc, cur))
						dfs(loc, cur + 1, n);
				}
			}
		}

		private boolean isValid(int[] loc, int cur) {
			for (int i = 0; i < cur; i++) {
				if (loc[i] == loc[cur]
						|| Math.abs(loc[i] - loc[cur]) == (cur - i))
					return false;
			}
			return true;
		}

	}
}
