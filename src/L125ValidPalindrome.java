import java.util.LinkedList;

//Given a string, determine if it is a palindrome, considering only alphanumeric 
//characters and ignoring cases.
//
//For example,
//"A man, a plan, a canal: Panama" is a palindrome.
//"race a car" is not a palindrome.
//
//Note:
//Have you consider that the string might be empty? This is a good question 
//to ask during an interview.
//
//For the purpose of this problem, we define empty string as valid palindrome.

public class L125ValidPalindrome {
	public class Solution {
		public boolean isPalindrome(String s) {

			s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

			int len = s.length();
			if (len < 2)
				return true;

			LinkedList<Character> stack = new LinkedList<Character>();

			int index = 0;
			while (index < len / 2) {
				stack.push(s.charAt(index));
				index++;
			}

			if (len % 2 == 1)
				index++;

			while (index < len) {
				if (stack.isEmpty())
					return false;

				char temp = stack.pop();
				if (s.charAt(index) != temp)
					return false;
				else
					index++;
			}

			return true;
		}
	}

	public class Solution2 {
		public boolean isPalindrome(String s) {

			if (s == null)
				return false;
			if (s.length() < 2)
				return true;

			char[] charArray = s.toCharArray();
			int len = s.length();

			int i = 0;
			int j = len - 1;

			while (i < j) {
				char left = charArray[i];
				char right = charArray[j];

				while (i < len - 1 && !isAlpha(left) && !isNum(left)) {
					i++;
					left = charArray[i];
				}

				while (j > 0 && !isAlpha(right) && !isNum(right)) {
					j--;
					right = charArray[j];
				}

				if (i >= j)
					break;

				left = charArray[i];
				right = charArray[j];

				if (!isSame(left, right)) {
					return false;
				}

				i++;
				j--;
			}
			return true;
		}

		public boolean isAlpha(char a) {
			if ((a >= 'a' && a <= 'z') || (a >= 'A' && a <= 'Z')) {
				return true;
			} else {
				return false;
			}
		}

		public boolean isNum(char a) {
			if (a >= '0' && a <= '9') {
				return true;
			} else {
				return false;
			}
		}

		public boolean isSame(char a, char b) {
			if (isNum(a) && isNum(b)) {
				return a == b;
			} else if (Character.toLowerCase(a) == Character.toLowerCase(b)) {
				return true;
			} else {
				return false;
			}
		}
	}
}
