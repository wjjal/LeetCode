public class L329LongestIncreasingPathInAMatrix {
    public class Solution {
        private int dfs(int[][] matrix, int i, int j, int[][] cache) {
            if (cache[i][j] > 0)
                return cache[i][j];
            int longest = 0;
            if (i > 0 && matrix[i][j] < matrix[i - 1][j])
                longest = Math.max(longest, dfs(matrix, i - 1, j, cache));
            if (j > 0 && matrix[i][j] < matrix[i][j - 1])
                longest = Math.max(longest, dfs(matrix, i, j - 1, cache));
            if (i < matrix.length - 1 && matrix[i][j] < matrix[i + 1][j])
                longest = Math.max(longest, dfs(matrix, i + 1, j, cache));
            if (j < matrix[0].length - 1 && matrix[i][j] < matrix[i][j + 1])
                longest = Math.max(longest, dfs(matrix, i, j + 1, cache));
            cache[i][j] = longest + 1;
            return cache[i][j];
        }

        public int longestIncreasingPath(int[][] matrix) {
            if (matrix.length == 0)
                return 0;
            int[][] cache = new int[matrix.length][matrix[0].length];
            int longest = 0;
            for (int i = 0; i < matrix.length; i++)
                for (int j = 0; j < matrix[0].length; j++)
                    longest = Math.max(longest, dfs(matrix, i, j, cache));
            return longest;
        }
    }
}
