//Given a sorted array and a target value, return the index if the target is found. 
//If not, return the index where it would be if it were inserted in order.
//
//You may assume no duplicates in the array.
//
//Here are few examples.
//[1,3,5,6], 5 ¡ú 2
//[1,3,5,6], 2 ¡ú 1
//[1,3,5,6], 7 ¡ú 4
//[1,3,5,6], 0 ¡ú 0

public class SearchInsertPosition {
	public static void main(String[] args) {
		int[] A = { 3, 5, 7, 9, 10 };
		int target = 8;
		System.out.println(new SearchInsertPosition().new Solution()
				.searchInsert(A, target));
	}

	public class Solution {
		public int searchInsert(int[] A, int target) {
			int n = A.length;
			int start = 0, end = n - 1;
			while (start <= end) {
				int mid = start + ((end - start) >> 1);
				if (A[mid] == target)
					return mid;
				else if (A[mid] < target) {
					if (start == end)
						return start + 1;
					start = mid + 1;
				} else {
					if (end == start)
						return end;
					end = mid - 1;
				}
			}
			return start;
		}
	}
}
