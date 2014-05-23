//Given two binary strings, return their sum (also a binary string).
//
//For example,
//a = "11"
//b = "1"
//Return "100".

public class AddBinary {
	public class Solution {
		public String addBinary(String a, String b) {
			if (a.length() == 0)
				return b;
			if (b.length() == 0)
				return a;
			int i = a.length() - 1;
			int j = b.length() - 1;
			int carry = 0;
			StringBuilder sb = new StringBuilder();
			while (i >= 0 && j >= 0) {
				char ac = a.charAt(i--);
				char bc = b.charAt(j--);
				if (ac == '1' && bc == '1') {
					sb.insert(0, carry);
					carry = 1;
				} else if ((ac == '1' && bc == '0') || (ac == '0' && bc == '1')) {
					if (carry == 1) {
						sb.insert(0, 0);
						carry = 1;
					} else {
						sb.insert(0, 1);
						carry = 0;
					}
				} else {
					sb.insert(0, carry);
					carry = 0;
				}
			}
			while (i >= 0) {
				char ac = a.charAt(i--);
				if (carry == 1) {
					if (ac == '1') {
						sb.insert(0, 0);
						carry = 1;
					} else {
						sb.insert(0, 1);
						carry = 0;
					}
				} else {
					sb.insert(0, ac);
				}
			}
			while (j >= 0) {
				char bc = b.charAt(j--);
				if (carry == 1) {
					if (bc == '1') {
						sb.insert(0, 0);
						carry = 1;
					} else {
						sb.insert(0, 1);
						carry = 0;
					}
				} else {
					sb.insert(0, bc);
				}
			}
			if (carry == 1)
				sb.insert(0, 1);
			return sb.toString();
		}
	}
}
