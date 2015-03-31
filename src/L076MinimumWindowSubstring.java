//Given a string S and a string T, find the minimum window in S which will contain 
//all the characters in T in complexity O(n).
//
//For example,
//S = "ADOBECODEBANC"
//T = "ABC"
//Minimum window is "BANC".
//
//Note:
//If there is no such window in S that covers all characters in T, 
//return the emtpy string "".
//
//If there are multiple such windows, you are guaranteed that 
//there will always be only one unique minimum window in S.

public class L076MinimumWindowSubstring {
	public class Solution {
		public String minWindow(String S, String T) {
			if (S == null || T == null || S.length() == 0 || T.length() == 0) {
				return "";
			}
			int[] needToFind = new int[256];
			int[] hasFound = new int[256];
			for (int i = 0; i < T.length(); i++) {
				needToFind[T.charAt(i)]++;
			}
			int minWinLen = Integer.MAX_VALUE;
			int count = 0, tLen = T.length();
			int winBeg = 0, winEnd = 0;
			for (int begin = 0, end = 0; end < S.length(); end++) {
				if (needToFind[S.charAt(end)] == 0)
					continue;
				hasFound[S.charAt(end)]++;
				if (hasFound[S.charAt(end)] <= needToFind[S.charAt(end)])
					count++;
				if (count == tLen) {
					while (needToFind[S.charAt(begin)] == 0
							|| hasFound[S.charAt(begin)] > needToFind[S
									.charAt(begin)]) {
						if (hasFound[S.charAt(begin)] > needToFind[S
								.charAt(begin)]) {
							hasFound[S.charAt(begin)]--;
						}
						begin++;
					}
					int winLen = end - begin + 1;
					if (winLen < minWinLen) {
						winBeg = begin;
						winEnd = end;
						minWinLen = winLen;
					}
				}
			}
			if (count == T.length()) {
				return S.substring(winBeg, winEnd + 1);
			}
			return "";
		}
	}
}
