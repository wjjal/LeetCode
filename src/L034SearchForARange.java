//Given a sorted array of integers, find the starting and ending position of 
//a given target value.
//
//Your algorithm's runtime complexity must be in the order of O(log n).
//
//If the target is not found in the array, return [-1, -1].
//
//For example,
//Given [5, 7, 7, 8, 8, 10] and target value 8,
//return [3, 4].

public class L034SearchForARange {
	public class Solution {
		public int[] searchRange(int[] A, int target) {
			return searchRange(A, 0, A.length - 1, target);
		}

		public int[] searchRange(int[] A, int begin, int end, int target) {
			int[] re = { -1, -1 };
			if (end < begin)
				return re;
			int mid = begin + (end - begin) / 2;
			if (A[mid] == target) {
				re[0] = mid;
				re[1] = mid;
			}
			int[] left = searchRange(A, begin, mid - 1, target);
			int[] right = searchRange(A, mid + 1, end, target);
			if (left[0] != -1) {
				re[0] = left[0];
				if (re[1] == -1)
					re[1] = left[1];
			}
			if (right[1] != -1) {
				re[1] = right[1];
				if (re[0] == -1)
					re[0] = right[0];
			}
			return re;
		}
	}
}
