//Implement strStr().

//Returns the index of the first occurrence of needle in haystack, or -1 
//if needle is not part of haystack.

public class L028ImplementStrStr {
	public class Solution {
		public int strStr(String haystack, String needle) {
			if (needle.length() == 0)
				return 0;
			if (haystack.length() < needle.length())
				return -1;
			int[] next = new int[needle.length()];
			get_next(needle, next);
			int pos = Index_KMP(haystack, needle, next, 0);
			if (pos != -1)
				return pos;
			else
				return -1;
		}

		void get_next(String t, int[] next) {
			int len = t.length(), i = 0, j = -1;
			next[i] = -1;
			while (i < len - 1) {
				if (j == -1 || t.charAt(i) == t.charAt(j)) {
					++i;
					++j;
					if (t.charAt(i) != t.charAt(j))
						next[i] = j;
					else
						next[i] = next[j];
				} else
					j = next[j];
			}
		}

		int Index_KMP(String s, String t, int[] next, int pos) {
			int i = pos, j = 0;
			while (i < s.length() && j < t.length()) {
				if (j == -1 || s.charAt(i) == t.charAt(j)) {
					++i;
					++j;
				} else
					j = next[j];
			}
			if (j >= t.length())
				return i - t.length();
			else
				return -1;
		}
	}
}
