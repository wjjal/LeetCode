//A message containing letters from A-Z is being encoded to numbers using the following mapping:
//
//'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
//Given an encoded message containing digits, determine the total number of ways to decode it.
//
//For example,
//Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
//
//The number of ways decoding "12" is 2.

public class DecodeWays {
	public class Solution {
		public int numDecodings(String s) {
			if (s == null || s.length() == 0) {
				return 0;
			}
			if (s.charAt(0) == '0') {
				return 0;
			}
			int[] number = new int[s.length() + 1];
			number[0] = 1;
			number[1] = 1;
			int tmp;
			for (int i = 2; i <= s.length(); i++) {

				tmp = Integer.parseInt(s.substring(i - 1, i));
				if (tmp != 0) {
					number[i] = number[i - 1];
				}

				if (s.charAt(i - 2) != '0') {
					tmp = Integer.parseInt(s.substring(i - 2, i));
					if (tmp > 0 && tmp <= 26) {
						number[i] += number[i - 2];
					} else if (tmp > 26 && s.charAt(i - 1) == '0')
						return 0;
				}
			}
			return number[s.length()];
		}
	}
}
