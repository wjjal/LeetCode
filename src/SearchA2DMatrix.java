//Write an efficient algorithm that searches for a value in an m x n matrix. 
//This matrix has the following properties:
//
//Integers in each row are sorted from left to right.
//The first integer of each row is greater than the last integer of the previous row.
//For example,
//
//Consider the following matrix:
//
//[
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]

public class SearchA2DMatrix {
	public class Solution {
		public boolean searchMatrix(int[][] matrix, int target) {
			int rows = matrix.length;
			if (rows == 0)
				return false;
			int cols = matrix[0].length;
			int i = rows - 1, j = 0;
			while (i >= 0 && j < cols) {
				if (matrix[i][j] == target)
					return true;
				else if (matrix[i][j] < target)
					j++;
				else
					i--;
			}
			return false;
		}
	}
}
