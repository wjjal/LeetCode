//Write a function to find the longest common prefix string amongst an array of strings.
public class LongestCommonPrefix {
	public class Solution {
		public String longestCommonPrefix(String[] strs) {
			String result = "";
			int len = strs.length;
			int i, j;
			if (len == 0)
				return "";
			for (j = 0;; ++j) {
				for (i = 0; i < len; ++i) {
					if (j >= strs[i].length()
							|| strs[i].charAt(j) != strs[0].charAt(j))
						break;
				}
				if (i < len)
					break;
				result += strs[0].charAt(j);
			}
			return result;
		}
	}
}
