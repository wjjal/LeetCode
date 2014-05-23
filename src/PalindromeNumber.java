//Determine whether an integer is a palindrome. Do this without extra space.

public class PalindromeNumber {
	public class Solution {
		public boolean isPalindrome(int x) {
			int temp = x;
			if (temp < 0)
				return false;
			int other = 0;
			while (temp != 0) {
				other = other * 10 + temp % 10;
				temp = temp / 10;
			}
			if (x == other)
				return true;
			return false;
		}
	}
}
