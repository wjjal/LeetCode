//Given two sorted integer arrays A and B, merge B into A as one sorted array.
//
//Note:
//You may assume that A has enough space (size that is greater or equal to m + n) to 
//hold additional elements from B. The number of elements initialized in A and B are m 
//and n respectively.

public class MergeSortedArray {
	public class Solution {
		public void merge(int A[], int m, int B[], int n) {
			for (int i = m - 1; i >= 0; i--) {
				A[i + n] = A[i];
			}
			int k = 0;
			int i = n;
			int j = 0;
			while (i < m + n && j < n) {
				if (A[i] <= B[j]) {
					A[k] = A[i];
					k++;
					i++;
				} else {
					A[k] = B[j];
					k++;
					j++;
				}
			}
			while (j < n) {
				A[k] = B[j];
				k++;
				j++;
			}
		}
	}
}
