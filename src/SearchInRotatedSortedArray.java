//Suppose a sorted array is rotated at some pivot unknown to you beforehand.
//
//(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//
//You are given a target value to search. If found in the array return its index, 
//otherwise return -1.
//
//You may assume no duplicate exists in the array.

public class SearchInRotatedSortedArray {
	public class Solution {
		public int search(int[] A, int target) {
			int n = A.length;
			int low = 0;
			int high = n - 1;
			while (low <= high) {
				int mid = low + ((high - low) >> 1);
				if (A[mid] == target) {
					return mid;
				}
				if (A[mid] >= A[low]) {
					if (target < A[mid] && target >= A[low])
						high = mid - 1;
					else
						low = mid + 1;
				} else if (A[mid] <= A[high]) {
					if (target > A[mid] && target <= A[high])
						low = mid + 1;
					else
						high = mid - 1;
				}
			}
			return -1;
		}
	}
}
