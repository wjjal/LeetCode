import java.util.ArrayList;

//Given a string s, partition s such that every substring of the partition is a palindrome.
//
//Return all possible palindrome partitioning of s.
//
//For example, given s = "aab",
//Return
//
//  [
//    ["aa","b"],
//    ["a","a","b"]
//  ]

public class L131PalindromePartitioning {
	public class Solution {
		public ArrayList<ArrayList<String>> partition(String s) {
			ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
			ArrayList<String> array = new ArrayList<String>();
			if (s == null || s.length() == 0) {
				result.add(array);
				return result;
			}
			boolean dp[][] = new boolean[s.length()][s.length()];
			dynamic(s, dp);
			dfs(s, 0, dp, array, result);
			return result;
		}

		public void dfs(String s, int begin, boolean[][] dp,
				ArrayList<String> array, ArrayList<ArrayList<String>> result) {
			if (begin == s.length()) {
				result.add(array);
				return;
			}
			for (int i = begin; i < s.length(); i++) {
				if (dp[begin][i]) {
					ArrayList<String> tmp = new ArrayList<String>(array);
					tmp.add(s.substring(begin, i + 1));
					dfs(s, i + 1, dp, tmp, result);
				}
			}
		}

		public void dynamic(String s, boolean[][] dp) {
			for (int i = s.length() - 1; i >= 0; i--) {
				for (int j = i; j < s.length(); j++) {
					if (s.charAt(i) == s.charAt(j)) {
						if (j - i < 2 || dp[i + 1][j - 1])
							dp[i][j] = true;
					}
				}

			}
		}
	}
}
