//Suppose a sorted array is rotated at some pivot unknown to you beforehand.
//
//(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//
//Find the minimum element.
//
//You may assume no duplicate exists in the array.

public class L153FindMinimumInRotatedSortedArray {
	public static void main(String[] args) {
		int num[] = { 2, 3, 4, 5, 1 };
		System.out.println(new L153FindMinimumInRotatedSortedArray().new Solution()
				.findMin1(num));
	}

	public class Solution {
		public int findMin1(int[] num) {
			int begin = 0;
			int end = num.length - 1;
			if (num[begin] < num[end])
				return num[begin];
			while (begin < end) {
				int mid = (begin + end) >> 1;
				if (mid == begin)
					return num[end];
				if (num[mid] > num[begin])
					begin = mid;
				else if (num[mid] < num[end])
					end = mid;
			}
			return num[end];
		}

		public int findMin2(int[] num) {
			if (num.length == 1)
				return num[0];
			int left = 0;
			int right = num.length - 1;
			while (num[left] > num[right]) {
				int mid = (left + right) >> 1;
				if (num[mid] > num[right])
					left = mid + 1;
				else
					right = mid;
			}
			return num[left];
		}
	}
}
