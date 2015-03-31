//Given a string s, partition s such that every substring of the partition is a palindrome.
//
//Return the minimum cuts needed for a palindrome partitioning of s.
//
//For example, given s = "aab",
//Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.

public class L132PalindromePartitioningII {
	public class Solution {
		public int minCut(String s) {
			if (s == null || s.length() == 0 || s.length() == 1) {
				return 0;
			}
			int[][] palindrome_map = new int[s.length()][s.length()];
			// cut_num_array[i]代表：string[i..n]字符串从i开始到末尾的最小划分数。
			int[] cut_num_array = new int[s.length() + 1];
			for (int i = s.length() - 1; i >= 0; i--) {
				cut_num_array[i] = s.length() - i;
				for (int j = i; j < s.length(); j++) {
					if (s.charAt(i) == s.charAt(j)) {
						if (j - i < 2 || palindrome_map[i + 1][j - 1] == 1) {
							palindrome_map[i][j] = 1;
							cut_num_array[i] = Math.min(cut_num_array[i],
									cut_num_array[j + 1] + 1);
						}
					}
				}
			}
			return cut_num_array[0] - 1;
		}
	}
}
