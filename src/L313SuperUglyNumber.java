public class L313SuperUglyNumber {
    public class Solution {
        public int nthSuperUglyNumber(int n, int[] primes) {
            int[] index = new int[primes.length];
            int[] uglyNum = new int[n];
            uglyNum[0] = 1;
            for (int i = 1; i < n; ++i) {
                int min = uglyNum[index[0]] * primes[0];
                for (int j = 1; j < primes.length; ++j) {
                    min = Math.min(min, uglyNum[index[j]] * primes[j]);
                }
                uglyNum[i] = min;
                for (int j = 0; j < primes.length; ++j) {
                    if (uglyNum[index[j]] * primes[j] == min) {
                        ++index[j];
                    }
                }
            }
            return uglyNum[n - 1];
        }
    }
}
