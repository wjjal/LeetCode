public class L306AdditiveNumber {
    public class Solution {
        public boolean isAdditiveNumber(String num) {
            int n = num.length();
            for (int i = 1; i < n; ++i) {
                for (int j = i + 1; j < n; ++j) {
                    String first = num.substring(0, i);
                    String second = num.substring(i, j);
                    if ((!first.equals("0") && first.startsWith("0")) || (!second.equals("0") && second.startsWith("0"))) {
                        continue;
                    }
                    long a = Long.valueOf(first);
                    long b = Long.valueOf(second);
                    if (dfs(num.substring(j), a, b)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean dfs(String num, long a, long b) {
            if (num.length() == 0)
                return true;
            for (int i = 1; i <= num.length(); ++i) {
                String tmp = num.substring(0, i);
                if (!tmp.equals("0") && tmp.startsWith("0")){
                    continue;
                }
                long c = Long.valueOf(tmp);
                if (c - b == a) {
                    return dfs(num.substring(i), b, c);
                }
            }
            return false;
        }
    }
}
