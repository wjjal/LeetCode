//Find the contiguous subarray within an array (containing at least one number) 
//which has the largest product.
//
//For example, given the array [2,3,-2,4],
//the contiguous subarray [2,3] has the largest product = 6.

public class MaximumProductSubarray {
	public class Solution {
		public int maxProduct(int[] A) {
			if (A.length <= 0)
				return 0;
			if (A.length == 1)
				return A[0];
			int cur_max = A[0];
			int cur_min = A[0];
			int re = A[0];
			for (int i = 1; i < A.length; i++) {
				int temp = cur_max;
				cur_max = Math.max(Math.max(temp * A[i], cur_min * A[i]), A[i]);
				cur_min = Math.min(Math.min(temp * A[i], cur_min * A[i]), A[i]);
				re = Math.max(re, cur_max);
			}
			return re;
		}
	}
}
