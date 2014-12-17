//Compare two version numbers version1 and version1.
//If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
//
//You may assume that the version strings are non-empty and contain only digits 
//and the . character.
//The . character does not represent a decimal point and is used to separate number 
//sequences.
//For instance, 2.5 is not "two and a half" or "half way to version three", 
//it is the fifth second-level revision of the second first-level revision.

//Here is an example of version numbers ordering:
//
//0.1 < 1.1 < 1.2 < 13.37
public class CompareVersionNumbers {
	public static void main(String[] args) {
		String version1 = "10.3";
		String version2 = "11";
		System.out.println(new CompareVersionNumbers().new Solution()
				.compareVersion1(version1, version2));
	}

	public class Solution {
		class Pair {
			int begin;
			int len;

			Pair(int begin, int len) {
				super();
				this.begin = begin;
				this.len = len;
			}
		}

		public int compareVersion1(String version1, String version2) {
			int len1 = version1.length();
			int len2 = version2.length();
			for (int begin1 = 0, begin2 = 0; begin1 < len1 || begin2 < len2; begin1++, begin2++) {
				Pair p1 = give(version1, begin1);
				Pair p2 = give(version2, begin2);
				begin1 = p1.begin;
				begin2 = p2.begin;
				int l1 = p1.len;
				int l2 = p2.len;
				if (l1 > l2)
					return 1;
				if (l1 < l2)
					return -1;
				for (int i = 0; i < l1; i++) {
					if (version1.charAt(begin1) > version2.charAt(begin2))
						return 1;
					if (version1.charAt(begin1) < version2.charAt(begin2))
						return -1;
					begin1++;
					begin2++;
				}
			}
			return 0;
		}

		Pair give(String s, int begin) {
			while (begin < s.length() && s.charAt(begin) == '0')
				begin++;
			int end = begin;
			while (end < s.length() && s.charAt(end) != '.')
				end++;
			return new Pair(begin, end - begin);
		}

		public int compareVersion2(String version1, String version2) {
			String s1[] = version1.split("\\.");
			String s2[] = version2.split("\\.");
			int len1 = s1.length;
			int len2 = s2.length;
			int minlen = Math.min(len1, len2);
			int i = 0;
			int a = 0;
			int b = 0;
			while (i < minlen) {
				a = Integer.valueOf(s1[i]);
				b = Integer.valueOf(s2[i]);
				if (compare(a, b) != 0)
					return compare(a, b);
				else
					i++;
			}
			if (len1 > len2)
				return 1;
			else if (len1 < len2)
				return -1;
			else
				return 0;
		}

		int compare(int a, int b) {
			if (a > b)
				return 1;
			else if (a < b)
				return -1;
			else
				return 0;
		}
	}
}
