//Given an array and a value, remove all instances of that value in place and 
//return the new length.
//
//The order of elements can be changed. It doesn't matter what you leave beyond 
//the new length.

public class L027RemoveElement {
	public class Solution {
		public int removeElement(int[] A, int elem) {
			int num = 0;
			for (int i = 0; i < A.length; i++) {
				if (A[i] != elem)
					A[num++] = A[i];
			}
			return num;
		}

		public int removeElement2(int[] A, int elem) {
			int i = 0, j = A.length - 1;
			while (i <= j) {
				if (A[i] == elem)
					A[i] = A[j--];
				else
					i++;
			}
			return j + 1;
		}

	}
}
