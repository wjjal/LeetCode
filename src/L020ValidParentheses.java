import java.util.LinkedList;

//Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
//determine if the input string is valid.
//
//The brackets must close in the correct order, 
//"()" and "()[]{}" are all valid but "(]" and "([)]" are not.

public class L020ValidParentheses {
	public static void main(String[] args) {
		String s = "([)]";
		System.out.println(new L020ValidParentheses().new Solution().isValid1(s));
	}

	public class Solution {
		public boolean isValid1(String s) {
			LinkedList<Character> stack = new LinkedList<Character>();
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (c == '(' || c == '[' || c == '{')
					stack.push(c);
				else if (stack.isEmpty())
					return false;
				else {
					char pre = stack.pop();
					if ((c == ')' && pre != '(') || (c == ']' && pre != '[')
							|| (c == '}' && pre != '{'))
						return false;
				}
			}
			if (stack.isEmpty())
				return true;
			return false;
		}

		public boolean isValid2(String s) {
			LinkedList<Character> stack = new LinkedList<Character>();
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (stack.isEmpty()) {
					stack.push(c);
					continue;
				}
				switch (c) {
				case ')':
					if (stack.peek() == '(') {
						stack.pop();
						break;
					}
				case ']':
					if (stack.peek() == '[') {
						stack.pop();
						break;
					}
				case '}':
					if (stack.peek() == '{') {
						stack.pop();
						break;
					}
				default:
					stack.push(c);
				}
			}
			if (stack.isEmpty())
				return true;
			else
				return false;
		}
	}
}
