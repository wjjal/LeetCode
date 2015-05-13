public class L204CountPrimes {
	public class Solution {
		public int countPrimes(int n) {
			if (n < 2)
				return 0;

			boolean[] primes = new boolean[n + 1];
			for (int i = 2; i < n; ++i)
				primes[i] = true;

			int sqr = (int) Math.sqrt(n);
			for (int i = 2; i <= sqr; ++i) {
				if (primes[i]) {
					for (int j = i + i; j <= n; j += i)
						primes[j] = false;
				}
			}

			int sum = 0;
			for (int i = 2; i < n; ++i)
				sum += (primes[i]) ? 1 : 0;
			return sum;
		}
	}
}
