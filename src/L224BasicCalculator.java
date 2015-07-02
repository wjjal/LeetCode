import java.util.*;

public class L224BasicCalculator {
	public int calculate(String s) {
		LinkedList<Integer> stack = new LinkedList<Integer>();
		int re = 0, num = 0, sign = 1;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				num = num * 10 + (c - '0');
			} else if (c == '+') {
				re += sign * num;
				num = 0;
				sign = 1;
			} else if (c == '-') {
				re += sign * num;
				num = 0;
				sign = -1;
			} else if (c == '(') {
				stack.push(re);
				stack.push(sign);
				sign = 1;
				re = 0;
			} else if (c == ')') {
				re += sign * num;
				num = 0;
				re *= stack.pop();
				re += stack.pop();
			}
		}
		if (num != 0)
			re += sign * num;
		return re;
	}
}
