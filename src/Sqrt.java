//Implement int sqrt(int x).
//
//Compute and return the square root of x.

public class Sqrt {
	public class Solution {
		public int sqrt(int x) {
			if (x == 1)
				return 1;
			int half = x >> 1;
			int pre = x * x;
			for (int i = 1; i <= half; i++) {
				int cur = x - i * i;
				if (cur == 0)
					return i;
				if (pre > 0 && cur < 0)
					return i - 1;
				pre = cur;
			}
			return half;
		}
	}
}
