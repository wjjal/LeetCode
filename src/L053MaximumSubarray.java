//Find the contiguous subarray within an array (containing at least one number) 
//which has the largest sum.
//
//For example, given the array [?6?12,1,?6?13,4,?6?11,2,1,?6?15,4],
//the contiguous subarray [4,?6?11,2,1] has the largest sum = 6.

public class L053MaximumSubarray {
	public class Solution {
		public int maxSubArray(int[] A) {
			int max = Integer.MIN_VALUE;
			int sum = 0;
			for (int i = 0; i < A.length; i++) {
				sum += A[i];
				if (sum > max)
					max = sum;
				if (sum < 0)
					sum = 0;
			}
			return max;
		}
	}
}
