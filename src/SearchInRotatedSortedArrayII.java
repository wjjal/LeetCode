//Follow up for "Search in Rotated Sorted Array":
//What if duplicates are allowed?
//
//Would this affect the run-time complexity? How and why?
//
//Write a function to determine if a given target is in the array.

public class SearchInRotatedSortedArrayII {
	public class Solution {
		public boolean search(int[] A, int target) {
			int n = A.length;
			int low = 0;
			int high = n - 1;
			while (low <= high) {
				int mid = low + ((high - low) >> 1);
				if (A[mid] == target) {
					return true;
				}
				if (A[mid] > A[low]) {
					if (target < A[mid] && target >= A[low])
						high = mid - 1;
					else
						low = mid + 1;
				} else if (A[mid] < A[low]) {
					if (target > A[mid] && target <= A[high])
						low = mid + 1;
					else
						high = mid - 1;
				} else
					low++;
			}
			return false;
		}
	}
}
