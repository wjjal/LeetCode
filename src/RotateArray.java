//Rotate an array of n elements to the right by k steps.
//
//For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to 
//[5,6,7,1,2,3,4].
//
//Note:
//Try to come up as many solutions as you can, 
//there are at least 3 different ways to solve this problem.
//
//Hint:
//Could you do it in-place with O(1) extra space?

public class RotateArray {
	public void rotate(int[] nums, int k) {
		int len = nums.length;
		k = k % len;
		for (int i = 0; i < (len - k) / 2; i++)
			swap(nums, i, len - 1 - k - i);
		for (int i = 0; i < k / 2; i++)
			swap(nums, len - k + i, len - 1 - i);
		for (int i = 0; i < len / 2; i++)
			swap(nums, i, len - 1 - i);
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
