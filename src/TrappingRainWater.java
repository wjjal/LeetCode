//Given n non-negative integers representing an elevation map where the 
//width of each bar is 1, compute how much water it is able to trap after raining.
//
//For example, 
//Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

public class TrappingRainWater {
	public class Solution {
		public int trap(int[] A) {
			int n = A.length;
			if (n < 3)
				return 0;
			int water = 0, left = 0, right = n - 1;
			int leftmax = A[0], rightmax = A[n - 1];
			while (left < right) {
				if (leftmax < rightmax) {
					left++;
					if (A[left] > leftmax)
						leftmax = A[left];
					else
						water += leftmax - A[left];
				} else {
					right--;
					if (A[right] > rightmax)
						rightmax = A[right];
					else
						water += rightmax - A[right];
				}
			}
			return water;
		}
	}
}
