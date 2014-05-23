//Given an array of non-negative integers, you are initially positioned at the 
//first index of the array.
//
//Each element in the array represents your maximum jump length at that position.
//
//Determine if you are able to reach the last index.
//
//For example:
//A = [2,3,1,1,4], return true.
//
//A = [3,2,1,0,4], return false.

public class JumpGame {
	public class Solution {
		public boolean canJump(int[] A) {
			int n = A.length;
			int max = 0;
			for (int i = 0; i < n && i <= max; i++) {
				max = Math.max(max, A[i] + i);
			}
			return (max >= n - 1);
		}
	}

	public class Solution2 {
		public boolean canJump(int[] A) {
			int len = A.length;
			int max = 0;
			for (int i = 0; i < len; i++) {
				if (i + A[i] > max)
					max = i + A[i];
				if (i + 1 < len && max < i + 1)
					return false;
				if (max >= len - 1)
					return true;
			}
			return false;
		}
	}
}
