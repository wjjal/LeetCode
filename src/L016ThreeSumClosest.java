import java.util.Arrays;

//Given an array S of n integers, find three integers in S such that 
//the sum is closest to a given number, target. Return the sum of the three integers. 
//You may assume that each input would have exactly one solution.
//
//For example, given array S = {-1 2 1 -4}, and target = 1.
//
//The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

public class L016ThreeSumClosest {
	public static void main(String[] args) {
		int[] num = { 1, 1, 1, 0 };
		int t = 100;
		System.out.println(new L016ThreeSumClosest().new Solution()
				.threeSumClosest(num, t));
	}

	public class Solution {
		public int threeSumClosest(int[] num, int target) {
			int min = Integer.MAX_VALUE;
			int result = 0;
			int len = num.length;
			Arrays.sort(num);
			for (int i = 0; i < len - 2; i++) {
				int left = i + 1;
				int right = len - 1;
				while (left < right) {
					int sum = num[i] + num[left] + num[right];
					int diff = Math.abs(sum - target);
					if (diff == 0)
						return target;
					if (diff < min) {
						min = diff;
						result = sum;
					}
					if (sum < target)
						left++;
					else
						right--;
				}
			}
			return result;
		}
	}
}
