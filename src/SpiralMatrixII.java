//Given an integer n, generate a square matrix filled with 
//elements from 1 to n2 in spiral order.
//
//For example,
//Given n = 3,
//
//You should return the following matrix:
//[
// [ 1, 2, 3 ],
// [ 8, 9, 4 ],
// [ 7, 6, 5 ]
//]

public class SpiralMatrixII {
	public class Solution {
		public int[][] generateMatrix(int n) {
			int matrix[][] = new int[n][n];
			int xmin = 0, xmax = n - 1, ymin = 0, ymax = n - 1;
			int num = 1;
			while (num <= n * n) {
				for (int i = ymin; i <= ymax; i++) {
					matrix[xmin][i] = num;
					num++;
				}
				xmin++;
				for (int i = xmin; i <= xmax; i++) {
					matrix[i][ymax] = num;
					num++;
				}
				ymax--;
				for (int i = ymax; i >= ymin; i--) {
					matrix[xmax][i] = num;
					num++;
				}
				xmax--;
				for (int i = xmax; i >= xmin; i--) {
					matrix[i][ymin] = num;
					num++;
				}
				ymin++;
			}
			return matrix;
		}
	}
}
