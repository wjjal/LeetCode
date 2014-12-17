//Suppose a sorted array is rotated at some pivot unknown to you beforehand.
//
//(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//
//Find the minimum element.

//The array may contain duplicates.

public class FindMinimumInRotatedSortedArrayII {
	public class Solution {
		public int findMin1(int[] num) {
			if (num == null || num.length == 0)
				return 0;
			int min = Integer.MAX_VALUE;
			int begin = 0;
			int end = num.length - 1;
			while (begin <= end) {
				if (num[begin] == num[end]) {
					int temp = num[begin];
					min = Math.min(min, temp);
					while (begin < end && num[begin] == temp)
						begin++;
					while (begin < end && num[end] == temp)
						end--;
				}
				int mid = (begin + end) >> 1;
				min = Math.min(min, num[mid]);
				if (num[mid] < num[end])
					end = mid;
				else if (num[mid] == num[end])
					end = mid - 1;
				else
					begin = mid + 1;
			}
			return min;
		}

		public int findMin2(int[] num) {
			int start = 0;
			int end = num.length - 1;
			while (num[start] >= num[end]) {
				int mid = (start + end) >> 1;
				if (num[start] == num[mid] && num[mid] == num[end]) {
					int min = num[start];
					for (int i = start + 1; i <= end; i++) {
						min = Math.min(min, num[i]);
					}
					return min;
				}
				// if(num[mid]>=num[start]),最小值必在右边，倾向于向右夹逼
				if (num[mid] > num[end])
					start = mid + 1;
				else
					end = mid;
			}
			return num[start];
		}
	}
}
