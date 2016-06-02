public class L304RangeSumQuery2DImmutable {
    public class NumMatrix {
        int arr[][];
        int sum[][];

        public NumMatrix(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) {
                return;
            }
            int m = matrix.length;
            int n = matrix[0].length;
            arr = new int[m][n];
            sum = new int[m][n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    arr[i][j] = matrix[i][j];
                    sum[i][j] = arr[i][j];
                    if (i > 0) {
                        sum[i][j] += sum[i - 1][j];
                    }
                    if (j > 0) {
                        sum[i][j] += sum[i][j - 1];
                    }
                    if (i > 0 && j > 0) {
                        sum[i][j] -= sum[i - 1][j - 1];
                    }
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int re = sum[row2][col2];
            if (row1 > 0) {
                re -= sum[row1 - 1][col2];
            }
            if (col1 > 0) {
                re -= sum[row2][col1 - 1];
            }
            if (row1 > 0 && col1 > 0) {
                re += sum[row1 - 1][col1 - 1];
            }
            return re;
        }
    }

    public class NumMatrix1 {
        int arr[][];
        int sum[][];

        public NumMatrix1(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) {
                return;
            }
            int m = matrix.length;
            int n = matrix[0].length;
            arr = new int[m][n];
            sum = new int[m + 1][n + 1];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    arr[i][j] = matrix[i][j];
                    sum[i + 1][j + 1] = sum[i][j + 1] + sum[i + 1][j] - sum[i][j] + arr[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return sum[row2 + 1][col2 + 1] - sum[row1][col2 + 1] - sum[row2 + 1][col1] + sum[row1][col1];
        }
    }

// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);
}
