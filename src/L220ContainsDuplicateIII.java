import java.util.Arrays;

public class L220ContainsDuplicateIII {
	class Pair implements Comparable<Pair> {
		int index;
		int val;

		Pair(int index, int val) {
			this.index = index;
			this.val = val;
		}

		@Override
		public int compareTo(Pair o) {
			if (this.val > o.val)
				return 1;
			else if (this.val > o.val)
				return 0;
			else
				return -1;
		}
	}

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		int len = nums.length;
		if (len < 2)
			return false;
		Pair[] p = new Pair[len];
		for (int i = 0; i < len; i++) {
			p[i] = new Pair(i, nums[i]);
		}
		Arrays.sort(p);
		int j = 0;
		for (int i = 1; i < len;) {
			if ((long) p[i].val - p[j].val > t) {
				j++;
				if (i == j)
					i++;
			} else if ((long) p[i].val - p[j].val <= t
					&& Math.abs(p[i].index - p[j].index) <= k) {
				return true;
			} else {
				i++;
			}
		}
		return false;
	}
}
