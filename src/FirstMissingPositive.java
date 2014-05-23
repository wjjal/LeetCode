//Given an unsorted integer array, find the first missing positive integer.
//
//For example,
//Given [1,2,0] return 3,
//and [3,4,-1,1] return 2.
//
//Your algorithm should run in O(n) time and uses constant space.

public class FirstMissingPositive {
	public class Solution {
		public int firstMissingPositive(int[] A) {
			int n = A.length, i = 0;
			while (i < n) {
				if (A[i] >= 0 && A[i] < n && A[A[i]] != A[i]) {
					int temp = A[A[i]];
					A[A[i]] = A[i];
					A[i] = temp;
				} else
					i++;
			}
			int k = 1;
			while (k < n && A[k] == k)
				k++;
			if (n == 0 || k < n)
				return k;
			else
				return A[0] == k ? k + 1 : k;
		}
	}
}
