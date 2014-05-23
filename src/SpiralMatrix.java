import java.util.ArrayList;

//Given a matrix of m x n elements (m rows, n columns), 
//return all elements of the matrix in spiral order.
//
//For example,
//Given the following matrix:
//
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//You should return [1,2,3,6,9,8,7,4,5].

public class SpiralMatrix {
	public class Solution {
		public ArrayList<Integer> spiralOrder(int[][] matrix) {
			ArrayList<Integer> re = new ArrayList<Integer>();
			int rows = matrix.length;
			if (rows < 1)
				return re;
			int cols = matrix[0].length;
			int xMin = 0;
			int yMin = 0;
			int xMax = rows - 1;
			int yMax = cols - 1;
			re.add(matrix[0][0]);
			int i = 0, j = 0;
			while (true) {
				while (j < yMax)
					re.add(matrix[i][++j]);
				if (++xMin > xMax)
					break;
				while (i < xMax)
					re.add(matrix[++i][j]);
				if (yMin > --yMax)
					break;
				while (j > yMin)
					re.add(matrix[i][--j]);
				if (xMin > --xMax)
					break;
				while (i > xMin)
					re.add(matrix[--i][j]);
				if (++yMin > yMax)
					break;
			}
			return re;
		}
	}
}
