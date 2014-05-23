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
	public class Solution {
		public int largestRectangleArea(int[] height) {
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
