//Implement pow(x, n).

public class L050Pow {
	public class Solution {
		public double pow(double x, int n) {
			if (n < 0)
				return 1 / power(x, -n);
			else
				return power(x, n);
		}

		private double power(double x, int n) {
			if (n == 0)
				return 1;
			double v = power(x, n >>> 1);
			if ((n & 1) == 1)
				return v * v * x;
			else
				return v * v;
		}
	}
}
