//Given an integer n, return the number of trailing zeroes in n!.
//
//Note: Your solution should be in polynomial time complexity.

public class FactorialTrailingZeroes {
	public class Solution {
		public int trailingZeroes(int n) {
			int total = 0;
			while (n >= 5) {
				total += n / 5;
				n /= 5;
			}
			return total;
		}
	}
}
