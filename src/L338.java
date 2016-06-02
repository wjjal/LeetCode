public class L338 {
    public class Solution {
        public int[] countBits(int num) {
            int[] re = new int[num + 1];
            re[0] = 0;
            for (int i = 1; i <= num; ++i) {
                re[i] = re[i >> 1];
                if ((i & 1) == 1) {
                    re[i]++;
                }
            }
            return re;
        }
    }
}
