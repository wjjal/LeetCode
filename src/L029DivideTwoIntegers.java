//Divide two integers without using multiplication, division and mod operator.

public class L029DivideTwoIntegers {
	public static void main(String[] args) {
		System.out.println(new L029DivideTwoIntegers().new Solution().divide(
				-2147483648, -1));
	}

	public class Solution {
		public int divide(int dividend, int divisor) {
			long a = dividend;
			long b = divisor;
			long re = 0;
			boolean isNeg = ((dividend ^ divisor) >> 31 == 1) ? true : false;
			a = Math.abs(a);
			b = Math.abs(b);
			int digit = 0;
			while (b <= (a >> 1)) {
				b <<= 1;
				digit++;
			}
			while (digit >= 0) {
				if (a >= b) {
					a -= b;
					re += ((long)1 << digit);
				}
				b >>= 1;
				digit--;
			}
			if (isNeg)
				re *= -1;
			if (re > Integer.MAX_VALUE)
				return Integer.MAX_VALUE;
			else
				return (int) re;
		}
	}
}
