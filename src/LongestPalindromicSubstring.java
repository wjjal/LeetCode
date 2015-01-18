//Given a string S, find the longest palindromic substring in S. 
//You may assume that the maximum length of S is 1000, 
//and there exists one unique longest palindromic substring.

public class LongestPalindromicSubstring {
	public static void main(String[] args) {
		String s = "c";
		System.out.println(new LongestPalindromicSubstring().new Solution()
				.longestPalindrome1(s));
	}

	public class Solution {
		public String longestPalindrome1(String s) {
			StringBuffer sb = new StringBuffer();
			sb.append("$");
			for (int i = 0; i < s.length(); i++) {
				sb.append("#");
				sb.append(s.charAt(i));
			}
			sb.append("#");
			int len = sb.length();
			int[] p = new int[len];
			int mx = 0;
			int id = 0;
			for (int i = 1; i < len; i++) {
				if (mx > i)
					p[i] = Math.min(p[2 * id - i], mx - i);
				else
					p[i] = 1;
				while (i + p[i] < len
						&& sb.charAt(i + p[i]) == sb.charAt(i - p[i]))
					p[i]++;
				if (i + p[i] > mx) {
					mx = i + p[i];
					id = i;
				}
			}
			int maxlen = 0;
			int center = 0;
			for (int i = 0; i < len; i++) {
				if (p[i] > maxlen) {
					maxlen = p[i];
					center = i;
				}
			}
			return s.substring((center-maxlen) / 2 , (center + maxlen) / 2 - 1);
		}

		public String longestPalindrome2(String s) {
			if (s.isEmpty()) {
				return null;
			}
			if (s.length() == 1) {
				return s;
			}
			String longest = s.substring(0, 1);
			for (int i = 0; i < s.length(); i++) {
				// get longest palindrome with center of i
				String tmp = helper(s, i, i);
				if (tmp.length() > longest.length()) {
					longest = tmp;
				}
				// get longest palindrome with center of i, i+1
				tmp = helper(s, i, i + 1);
				if (tmp.length() > longest.length()) {
					longest = tmp;
				}
			}
			return longest;
		}

		// Given a center, either one letter or two letter,
		// Find longest palindrome
		public String helper(String s, int begin, int end) {
			while (begin >= 0 && end <= s.length() - 1
					&& s.charAt(begin) == s.charAt(end)) {
				begin--;
				end++;
			}
			return s.substring(begin + 1, end);
		}
	}
}
