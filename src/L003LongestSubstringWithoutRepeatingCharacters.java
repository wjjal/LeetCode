//Given a string, find the length of the longest substring without repeating characters. 
//For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
//which the length is 3. 
//For "bbbbb" the longest substring is "b", with the length of 1.

public class L003LongestSubstringWithoutRepeatingCharacters {
	public class Solution {
		public int lengthOfLongestSubstring(String s) {
			int max = 0;
			boolean[] exist = new boolean[256];
			int begin = 0, end = 0;
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (!exist[c]) {
					exist[c] = true;
					end++;
				} else {
					max = Math.max(max, end - begin);
					while (s.charAt(begin) != c)
						exist[s.charAt(begin++)] = false;
					begin++;
					end++;
				}
			}
			max = Math.max(max, end - begin);
			return max;
		}
	}
}
