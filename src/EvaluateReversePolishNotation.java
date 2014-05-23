import java.util.LinkedList;

//Evaluate the value of an arithmetic expression in Reverse Polish Notation.
//
//Valid operators are +, -, *, /. Each operand may be an integer or another expression.
//
//Some examples:
//  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
//  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
public class EvaluateReversePolishNotation {
	public class Solution {
	    public int evalRPN(String[] tokens) {
				if (tokens.length == 0)
					return 0;
				LinkedList<Integer> stack = new LinkedList<Integer>();
				for (int i = 0; i < tokens.length; i++) {
					if (tokens[i].equals("+")) {
						int b = stack.pop();
						int a = stack.pop();
						stack.push(a + b);
					} else if (tokens[i].equals("-")) {
						int b = stack.pop();
						int a = stack.pop();
						stack.push(a - b);
					} else if (tokens[i].equals("*")) {
						int b = stack.pop();
						int a = stack.pop();
						stack.push(a * b);
					} else if (tokens[i].equals("/")) {
						int b = stack.pop();
						int a = stack.pop();
						stack.push(a / b);
					} else
						stack.push(Integer.valueOf(tokens[i]));
				}
				return stack.pop();
			}
	}
}
