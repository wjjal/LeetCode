import java.util.LinkedList;

//Given a string containing just the characters '(' and ')', 
//find the length of the longest valid (well-formed) parentheses substring.
//
//For "(()", the longest valid parentheses substring is "()", which has length = 2.
//
//Another example is ")()())", where the longest valid parentheses 
//substring is "()()", which has length = 4.

public class LongestValidParentheses {
	public class Solution {
		public int longestValidParentheses(String s) {
			int max = 0, last = -1;
			LinkedList<Integer> stack = new LinkedList<Integer>();
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '(')
					stack.push(i);
				else {
					if (stack.isEmpty())
						last = i;
					else {
						stack.pop();
						if (stack.isEmpty())
							max = Math.max(max, i - last);
						else {
							max = Math.max(max, i - stack.peek());
						}
					}
				}
			}
			return max;
		}
	}

}
