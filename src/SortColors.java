//Given an array with n objects colored red, white or blue, sort them 
//so that objects of the same color are adjacent, with the colors in the order red, 
//white and blue.
//
//Here, we will use the integers 0, 1, and 2 to represent the color red, white, 
//and blue respectively.
//
//Note:
//You are not suppose to use the library's sort function for this problem.

public class SortColors {
	public class Solution {
		public void sortColors(int[] A) {
			int begin = 0;
			int cur = 0;
			int end = A.length - 1;
			while (cur <= end) {
				if (A[cur] == 0) {
					swap(A, cur, begin);
					cur++;
					begin++;
				} else if (A[cur] == 1)
					cur++;
				else {
					swap(A, cur, end);
					end--;
				}
			}
		}

		void swap(int array[], int a, int b) {
			int temp = array[a];
			array[a] = array[b];
			array[b] = temp;
		}
	}
}
