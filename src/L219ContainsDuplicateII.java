import java.util.*;

public class L219ContainsDuplicateII {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Set<Integer> hash = new HashSet<Integer>();
		int i = 0, j = 0;
		while (j - i <= k && j < nums.length) {
			if (!hash.contains(nums[j])) {
				hash.add(nums[j++]);
			} else {
				return true;
			}
		}
		while (j < nums.length) {
			hash.remove(nums[i++]);
			if (!hash.contains(nums[j])) {
				hash.add(nums[j++]);
			} else {
				return true;
			}
		}
		return false;
	}
}
