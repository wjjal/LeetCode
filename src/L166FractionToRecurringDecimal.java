import java.util.HashMap;
import java.util.LinkedList;

//Given two integers representing the numerator and denominator of a fraction, 
//return the fraction in string format.
//
//If the fractional part is repeating, enclose the repeating part in parentheses.
//
//For example,
//
//Given numerator = 1, denominator = 2, return "0.5".
//Given numerator = 2, denominator = 1, return "2".
//Given numerator = 2, denominator = 3, return "0.(6)".

public class L166FractionToRecurringDecimal {
	public static void main(String[] args) {
		System.out.println(new L166FractionToRecurringDecimal().new Solution()
				.fractionToDecimal(7, -12));
	}

	public class Solution {
		public String fractionToDecimal(int numerator, int denominator) {
			String re = "";
			long a = Math.abs((long) numerator);
			long b = Math.abs((long) denominator);
			if ((denominator < 0 && numerator > 0)
					|| (denominator > 0 && numerator < 0))
				re += "-";
			long left = a / b;
			re += left;
			if (a % b == 0)
				return re;
			else {
				re += ".";
				long remainder = a % b;
				HashMap<Long, Integer> map = new HashMap<Long, Integer>();
				int i = 1;
				map.put(remainder, 1);
				LinkedList<Long> queue = new LinkedList<Long>();
				int begin = 0;
				while (remainder != 0) {
					i++;
					long tmp = remainder * 10 / b;
					remainder = remainder * 10 % b;
					if (map.containsKey(remainder)) {
						begin = map.get(remainder);
						queue.offer(tmp);
						break;
					} else {
						map.put(remainder, i);
						queue.offer(tmp);
					}
				}
				if (remainder == 0) {
					while (!queue.isEmpty()) {
						re += queue.poll();
					}
				} else {
					int j = 1;
					while (!queue.isEmpty()) {
						long cur = queue.poll();
						if (j != begin)
							re += cur;
						else
							re = re + "(" + cur;
						j++;
					}
					re += ")";
				}
				return re;
			}
		}
	}
}
