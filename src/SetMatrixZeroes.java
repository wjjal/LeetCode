//Given a m x n matrix, if an element is 0, set its entire row and column to 0. 
//Do it in place.

public class SetMatrixZeroes {
	public class Solution {
		public void setZeroes(int[][] matrix) {
			int row = matrix.length;
			int col = matrix[0].length;
			boolean firstrow = false;
			boolean firstcol = false;
			for (int j = 0; j < col; j++) {
				if (matrix[0][j] == 0) {
					firstrow = true;
					break;
				}
			}
			for (int i = 0; i < row; i++) {
				if (matrix[i][0] == 0) {
					firstcol = true;
					break;
				}
			}
			for (int i = 1; i < row; i++) {
				for (int j = 1; j < col; j++) {
					if (matrix[i][j] == 0) {
						matrix[i][0] = 0;
						matrix[0][j] = 0;
					}
				}
			}
			for (int i = 1; i < row; i++) {
				for (int j = 1; j < col; j++) {
					if (matrix[i][0] == 0 || matrix[0][j] == 0)
						matrix[i][j] = 0;
				}
			}

			if (firstrow) {
				for (int j = 0; j < col; j++) {
					matrix[0][j] = 0;
				}
			}

			if (firstcol) {
				for (int i = 0; i < row; i++) {
					matrix[i][0] = 0;
				}
			}
		}
	}

	public class Solution2 {
		public void setZeroes(int[][] matrix) {
			int row = matrix.length;
			int col = matrix[0].length;
			boolean flagrow[] = new boolean[row];
			boolean flagcol[] = new boolean[col];
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if (matrix[i][j] == 0) {
						flagrow[i] = true;
						flagcol[j] = true;
					}
				}
			}
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if (flagrow[i] || flagcol[j])
						matrix[i][j] = 0;
				}
			}
		}
	}
}
