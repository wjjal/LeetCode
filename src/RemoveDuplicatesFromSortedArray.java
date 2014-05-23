//Given a sorted array, remove the duplicates in place such that 
//each element appear only once and return the new length.
//
//Do not allocate extra space for another array, you must do this 
//in place with constant memory.
//
//For example,
//Given input array A = [1,1,2],
//
//Your function should return length = 2, and A is now [1,2].

public class RemoveDuplicatesFromSortedArray {
	public class Solution {
		public int removeDuplicates(int[] A) {
			int len = A.length;
			if (len <= 1)
				return len;
			int re = len;
			int j = 0;
			for (int i = 1; i < len; i++) {
				if (A[i] == A[j]) {
					re--;
				}
				if (A[i] != A[j]) {
					A[j + 1] = A[i];
					j++;
				}
			}
			return re;
		}
	}
}
