import java.util.LinkedList;

//Given n non-negative integers representing the histogram's bar height where 
//the width of each bar is 1, find the area of largest rectangle in the histogram.
//
//
//Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
//
//
//The largest rectangle is shown in the shaded area, which has area = 10 unit.
//
//For example,
//Given height = [2,1,5,6,2,3],
//return 10.
public class LargestRectangleInHistogram {
	public static void main(String[] args) {
		int[] height = { 3, 6, 5, 7, 4, 8, 1, 0 };
		System.out.println(new LargestRectangleInHistogram().new Solution()
				.largestRectangleArea1(height));
	}

	public class Solution {
		public int largestRectangleArea1(int[] height) {
			int area = 0;
			if (height.length == 1)
				area = height[0] * 1;
			LinkedList<Integer> stack = new LinkedList<Integer>();
			for (int i = 0; i < height.length; i++) {
				while (!stack.isEmpty() && height[stack.peek()] > height[i]) {
					int t = stack.pop();
					int width = stack.isEmpty() ? i : i - stack.peek() - 1;
					area = Math.max(area, height[t] * width);
				}
				stack.push(i);
			}
			while (!stack.isEmpty()) {
				int start = stack.pop();
				int width = stack.isEmpty() ? height.length : height.length
						- stack.peek() - 1;
				area = Math.max(area, height[start] * width);
			}
			return area;
		}

		public int largestRectangleArea2(int[] height) {
			int area = 0;
			if (height.length == 1)
				area = height[0] * 1;
			LinkedList<Integer> stack = new LinkedList<Integer>();
			for (int i = 0; i < height.length; i++) {
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
				int width = stack.isEmpty() ? height.length : height.length
						- stack.peek() - 1;
				area = Math.max(area, height[start] * width);
			}
			return area;
		}
	}
}
