//Given a non-negative number represented as an array of digits, plus one to the number.
//
//The digits are stored such that the most significant digit is at the head of the list.

public class L066PlusOne {
	public class Solution {
		public int[] plusOne(int[] digits) {
			int len = digits.length;
			int carry = 1;
			boolean flag = true;
			for (int i : digits) {
				if (i != 9) {
					flag = false;
					break;
				}
			}
			int re[];
			if (flag)
				re = new int[len + 1];
			else
				re = new int[len];
			for (int i = len - 1; i >= 0; i--) {
				if (carry == 1) {
					if (digits[i] + carry == 10) {
						carry = 1;
						re[i] = 0;
					} else {
						re[i] = digits[i] + carry;
						carry = 0;
					}
				} else {
					re[i] = digits[i];
				}
			}
			if (carry == 1)
				re[0] = 1;
			return re;
		}
	}
}
