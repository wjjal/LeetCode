import java.util.Arrays;

//Implement next permutation, which rearranges numbers into the lexicographically 
//next greater permutation of numbers.
//
//If such arrangement is not possible, it must rearrange it as the lowest possible order 
//(ie, sorted in ascending order).
//
//The replacement must be in-place, do not allocate extra memory.
//
//Here are some examples. Inputs are in the left-hand column and its corresponding 
//outputs are in the right-hand column.
//1,2,3 ¡ú 1,3,2
//3,2,1 ¡ú 1,2,3
//1,1,5 ¡ú 1,5,1

public class NextPermutation {
	public class Solution {
		public void nextPermutation(int[] num) {
			int len = num.length;
			for (int i = len - 2; i >= 0; --i) {
				if (num[i + 1] > num[i]) {
					int j;
					for (j = len - 1; j > i - 1; --j)
						if (num[j] > num[i])
							break;
					swap(num, i, j);
					Arrays.sort(num, i + 1, num.length);
					return;
				}
			}

			Arrays.sort(num, 0, num.length);
			return;
		}
	

	public void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
}
