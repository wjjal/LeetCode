public class L275HIndexII {
    public class Solution {
        public int hIndex(int[] citations) {
            int n = citations.length;
            if (n == 0) {
                return 0;
            }
            int re = 0;
            for (int i = n - 1; i >= 0; --i) {
                if (citations[i] >= n - i)
                    re = n - i;
                else
                    break;
            }
            return re;
        }
    }
}
