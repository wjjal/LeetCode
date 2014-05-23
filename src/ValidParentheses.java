import java.util.LinkedList;

//Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
//determine if the input string is valid.
//
//The brackets must close in the correct order, 
//"()" and "()[]{}" are all valid but "(]" and "([)]" are not.

public class ValidParentheses {
	public class Solution {
	    public boolean isValid(String s) {
			LinkedList<Character> stack = new LinkedList<Character>();
				for (int i = 0; i < s.length(); i++) {
					char c = s.charAt(i);
					if (stack.isEmpty()){
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
