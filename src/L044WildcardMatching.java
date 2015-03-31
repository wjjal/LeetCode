//Implement wildcard pattern matching with support for '?' and '*'.
//
//'?' Matches any single character.
//'*' Matches any sequence of characters (including the empty sequence).
//
//The matching should cover the entire input string (not partial).
//
//The function prototype should be:
//bool isMatch(const char *s, const char *p)
//
//Some examples:
//isMatch("aa","a") ¡ú false
//isMatch("aa","aa") ¡ú true
//isMatch("aaa","aa") ¡ú false
//isMatch("aa", "*") ¡ú true
//isMatch("aa", "a*") ¡ú true
//isMatch("ab", "?*") ¡ú true
//isMatch("aab", "c*a*b") ¡ú false

public class L044WildcardMatching {
	public static void main(String[] args){
	   System.out.println(new L044WildcardMatching().new Solution().isMatch("aa", "*"));	
	}
	
	public class Solution {
		public boolean isMatch(String s, String p) {
			int i = 0;
			int j = 0;
			int star = -1;
			int mark = -1;
			while (i < s.length()) {
				if (j < p.length()
						&& (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))) {
					i++;
					j++;
				} else if (j < p.length() && p.charAt(j) == '*') {
					star = j++;
					mark = i;
				} else if (star != -1) {
					j = star + 1;
					i = ++mark;
				} else
					return false;
			}
			while (j < p.length() && p.charAt(j) == '*')
				j++;
			return j == p.length();
		}
	}
}
