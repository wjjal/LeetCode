public class L299BullsAndCows {
    public class Solution {
        public String getHint(String secret, String guess) {
            int[] sh = new int[10];
            int[] gh = new int[10];
            int a = 0, b = 0;
            for (int i = 0; i < secret.length(); ++i) {
                int s = secret.charAt(i) - '0';
                int g = guess.charAt(i) - '0';
                if (g == s) {
                    ++a;
                } else {
                    ++sh[s];
                    ++gh[g];
                }
            }
            for (int i = 0; i < 10; i++) {
                b += Math.min(sh[i], gh[i]);
            }
            String re = a + "A" + b + "B";
            return re;
        }
    }
}
