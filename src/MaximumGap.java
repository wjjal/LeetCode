//Given an unsorted array, find the maximum difference between the successive elements
//in its sorted form.
//
//Try to solve it in linear time/space.
//
//Return 0 if the array contains less than 2 elements.
//
//You may assume all elements in the array are non-negative integers and 
//fit in the 32-bit signed integer range.

//Õ∞≈≈–Ú
public class MaximumGap {
	public static void main(String[] args) {
		int num[] = { 1, 10000 };
		System.out.println(new MaximumGap().new Solution().maximumGap(num));
	}

	public class Solution {
		public int maximumGap(int[] num) {
			int len = num.length;
			if (len < 2) {
				return 0;
			}
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			for (int i : num) {
				max = Math.max(max, i);
				min = Math.min(min, i);
			}
			// º∆À„Õ∞º‰∏Ù
			int gap = (max - min) / (len - 1);
			gap++;

			int[] min_value = new int[len - 1];
			int[] max_value = new int[len - 1];
			for (int i = 0; i < len - 1; i++) {
				min_value[i] = Integer.MAX_VALUE;
				max_value[i] = Integer.MIN_VALUE;
			}
			for (int i : num) {
				int index = (i - min) / gap;
				min_value[index] = Math.min(min_value[index], i);
				max_value[index] = Math.max(max_value[index], i);
			}
			int re = max_value[0] - min_value[0];
			int prev = max_value[0];
			for (int i = 0; i < len - 1; i++) {
				// »ÙÕ∞≤ªŒ™ø’
				if (min_value[i] != Integer.MAX_VALUE) {
					re = Math.max(re, min_value[i] - prev);
					prev = max_value[i];
				}
			}
			return re;
		}
	}
}
