import java.util.LinkedList;

//Given a 2D binary matrix filled with 0's and 1's, 
//find the largest rectangle containing all ones and return its area.

public class MaximalRectangle {
	public class Solution {
		public int maximalRectangle(char[][] matrix) {
			if (matrix.length == 0)
				return 0;
			int col = matrix[0].length;
			int row = matrix.length;
			int result = 0;
			int height[] = new int[col];
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if (matrix[i][j] == '1')
						height[j]++;
					else
						height[j] = 0;
				}
				int rect = getLargestRectInHistogram(height, col);
				result = Math.max(result, rect);
			}
			return result;
		}

		public int getLargestRectInHistogram(int[] height, int n) {
			int area = 0;
			if (n == 1)
				area = height[0] * 1;
			LinkedList<Integer> stack = new LinkedList<Integer>();
			for (int i = 0; i < n; i++) {
				if (stack.isEmpty() || height[stack.peek()] < height[i]) {
					stack.push(i);
				} else {
					int t = stack.pop();
					int width = stack.isEmpty() ? i : i - stack.peek() - 1;
					area = Math.max(area, height[t] * width);
					i--;
				}
			}
			while (!stack.isEmpty()) {
				int start = stack.pop();
				int width = stack.isEmpty() ? n : n - stack.peek() - 1;
				area = Math.max(area, height[start] * width);
			}
			return area;
		}
	}

	public class Solution2 {
		public int maximalRectangle(char[][] matrix) {
			int m = matrix.length;
			int n = m == 0 ? 0 : matrix[0].length;
			int[][] height = new int[m][n + 1];
			// 用0做flag 所以多一列
			int maxArea = 0;
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (matrix[i][j] == '0') {
						height[i][j] = 0;
					} else {
						height[i][j] = i == 0 ? 1 : height[i - 1][j] + 1;
					}
				}
			}
			for (int i = 0; i < m; i++) {
				int area = maxAreaInHist(height[i]);
				if (area > maxArea) {
					maxArea = area;
				}
			}
			return maxArea;
		}

		private int maxAreaInHist(int[] height) {
			LinkedList<Integer> stack = new LinkedList<Integer>();
			int i = 0;
			int maxArea = 0;
			while (i < height.length) {
				if (stack.isEmpty() || height[stack.peek()] <= height[i]) {
					stack.push(i++);
				} else {
					int t = stack.pop();
					maxArea = Math.max(maxArea, height[t]
							* (stack.isEmpty() ? i : i - stack.peek() - 1));
				}
			}
			return maxArea;
		}
	}
}
