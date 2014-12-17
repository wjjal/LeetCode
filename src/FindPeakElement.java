//A peak element is an element that is greater than its neighbors.
//
//Given an input array where num[i] ¡Ù num[i+1], find a peak element and return its index.
//
//You may imagine that num[-1] = num[n] = -¡Þ.
//
//For example, in array [1, 2, 3, 1], 3 is a peak element and your function should 
//return the index number 2.

public class FindPeakElement {
	public class Solution {
		public int findPeakElement1(int[] num) {
			int n = num.length;
			int left = 0;
			int right = n - 1;
			while (left <= right) {
				int mid = left + ((right - left) >> 1);
				if ((mid == 0 || num[mid - 1] < num[mid])
						&& (mid == n - 1 || num[mid + 1] < num[mid]))
					return mid;
				else if (mid > 0 && num[mid - 1] > num[mid]) {
					right = mid - 1;
				} else if (mid < n - 1 && num[mid + 1] > num[mid]) {
					left = mid + 1;
				}
			}
			return -1;
		}

		public int findPeakElement2(int[] num) {
			return findPeakUtil(num, 0, num.length - 1, num.length);
		}

		public int findPeakUtil(int arr[], int low, int high, int n) {
			int mid = low + ((high - low) >> 1);
			// Compare middle element with its neighbours (if neighbours exist)
			if ((mid == 0 || arr[mid - 1] <= arr[mid])
					&& (mid == n - 1 || arr[mid + 1] <= arr[mid]))
				return mid;

			// If middle element is not peak and its left neighbor is greater
			// than it
			// then left half must have a peak element
			else if (mid > 0 && arr[mid - 1] > arr[mid])
				return findPeakUtil(arr, low, (mid - 1), n);

			// If middle element is not peak and its right neighbor is greater
			// than it
			// then right half must have a peak element
			else
				return findPeakUtil(arr, (mid + 1), high, n);
		}
	}
}
