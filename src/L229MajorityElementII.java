import java.util.*;

public class L229MajorityElementII {
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> re = new ArrayList<Integer>();
		int a = 0, b = 0;
		int counta = 0, countb = 0;
		for (int i = 0; i < nums.length; i++) {
			if (counta > 0 && a == nums[i]) {
				counta++;
			} else if (countb > 0 && b == nums[i]) {
				countb++;
			} else if (counta == 0) {
				a = nums[i];
				counta++;
			} else if (countb == 0) {
				b = nums[i];
				countb++;
			} else {
				counta--;
				countb--;
			}
		}
		counta = 0;
		countb = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == a) {
				counta++;
			} else if (nums[i] == b) {
				countb++;
			}
		}
		if (counta > nums.length / 3) {
			re.add(a);
		}
		if (countb > nums.length / 3) {
			re.add(b);
		}
		return re;
	}
}
