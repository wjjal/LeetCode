public class L213HouseRobberII {
	public int rob(int[] nums) {
		if (nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		return Math.max(help(nums, 0, nums.length - 2),
				help(nums, 1, nums.length - 1));
	}

	private int help(int[] nums, int start, int end) {
		int pre = 0;
		int cur = nums[start];
		for (int i = start + 1; i <= end; i++) {
			int tmp = Math.max(cur, pre + nums[i]);
			pre = cur;
			cur = tmp;
		}
		return cur;
	}
}
