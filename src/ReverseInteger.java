//Reverse digits of an integer.
//
//Example1: x = 123, return 321
//Example2: x = -123, return -321

public class ReverseInteger {
	public class Solution {
		public int reverse(int x) {
			int flag = x > 0 ? 1 : -1;
			x *= flag;
			long re = 0;
			while (x != 0) {
				re = re * 10 + x % 10;
				x = x / 10;
			}
			if (re * flag > Integer.MAX_VALUE || re * flag < Integer.MIN_VALUE)
				return 0;
			return (int) re * flag;
		}
	}
}
