public class L215KthLargestElementInAnArray {
	public int findKthLargest(int[] nums, int k) {
		int len = nums.length;
		for (int i = (len - 1) / 2; i >= 0; i--)
			heapAdjust(nums, i, len - 1);
		for (int i = len - 1; i > len - k; i--) {
			swap(nums, 0, i);
			heapAdjust(nums, 0, i - 1);
		}
		return nums[0];
	}

	private void heapAdjust(int[] nums, int root, int range) {
		int i = root;
		int temp = nums[i];
		for (int j = 2 * i + 1; j <= range; j = j * 2 + 1) {
			if (j < range && nums[j] < nums[j + 1])
				j++;
			if (temp < nums[j]) {
				nums[i] = nums[j];
				i = j;
			} else
				break;
		}
		nums[i] = temp;
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
