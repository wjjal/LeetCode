import java.util.*;

public class L228SummaryRanges {
	public static void main(String[] args) {

		int[] nums = { -1 };
		new L228SummaryRanges().summaryRanges(nums);
	}

	public List<String> summaryRanges(int[] nums) {
		List<String> re = new ArrayList<String>();
		if (nums.length == 0)
			return re;
		String tmp = "";
		int begin = 0, end = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i + 1] - nums[i] == 1)
				continue;
			else {
				end = i;
				if (begin == end)
					tmp = "" + nums[end];
				else
					tmp = nums[begin] + "->" + nums[end];
				re.add(tmp);
				begin = i + 1;
			}
		}
		if (end == 0 || end != nums.length - 1) {
			end = nums.length - 1;
			if (begin == end)
				tmp = "" + nums[end];
			else
				tmp = nums[begin] + "->" + nums[end];
			re.add(tmp);
		}
		return re;
	}
}
