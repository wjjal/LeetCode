//Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
//
//For example,
//Given:
//s1 = "aabcc",
//s2 = "dbbca",
//
//When s3 = "aadbbcbcac", return true.
//When s3 = "aadbbbaccc", return false.

public class InterleavingString {
	public class Solution {
		public boolean isInterleave(String s1, String s2, String s3) {
			int l1 = s1.length();
			int l2 = s2.length();
			int l3 = s3.length();
			if (l3 != l1 + l2)
				return false;
			boolean temp[][] = new boolean[l1 + 1][l2 + 1];
			temp[0][0] = true;
			for (int i = 1; i <= l1; i++) {
				if (s3.charAt(i - 1) == s1.charAt(i - 1)) {
					temp[i][0] = true;
				} else
					break;
			}
			for (int j = 1; j <= l2; j++) {
				if (s3.charAt(j - 1) == s2.charAt(j - 1)) {
					temp[0][j] = true;
				} else
					break;
			}
			for (int i = 1; i <= l1; i++) {
				char c1 = s1.charAt(i - 1);
				for (int j = 1; j <= l2; j++) {
					char c2 = s2.charAt(j - 1);
					int k = i + j;
					char c3 = s3.charAt(k - 1);
					if (c1 == c3)
						temp[i][j] |= temp[i - 1][j];
					if (c2 == c3)
						temp[i][j] |= temp[i][j - 1];
				}
			}
			return temp[l1][l2];
		}
	}
}
