public class L227BasicCalculatorII {
	public int calculate(String s) {
		int res = 0, lastNum = 0, currNum = 0, op = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ')
				continue;

			if (Character.isDigit(s.charAt(i))) {
				currNum = 0;
				for (; i < s.length() && Character.isDigit(s.charAt(i)); i++) {
					currNum = currNum * 10 + (s.charAt(i) - '0');
				}
				i--;
				if (op == 0)
					lastNum = currNum;
				else if (op == 1)
					lastNum -= currNum;
				else if (op == 2)
					lastNum *= currNum;
				else if (op == 3)
					lastNum /= currNum;
			} else {
				if (s.charAt(i) == '+') {
					res += lastNum;
					lastNum = 0;
					op = 0;
				} else if (s.charAt(i) == '-') {
					res += lastNum;
					lastNum = 0;
					op = 1;
				} else if (s.charAt(i) == '*')
					op = 2;
				else if (s.charAt(i) == '/')
					op = 3;
			}
		}
		return res + lastNum;
	}
}
