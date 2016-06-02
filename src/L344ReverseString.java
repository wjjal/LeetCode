public class L344ReverseString {
    public class Solution {
        public String reverseString(String s) {
            char[] cs = new char[s.length()];
            int i = 0, j = s.length() - 1;
            while (i < j) {
                cs[i] = s.charAt(j);
                cs[j] = s.charAt(i);
                ++i;
                --j;
            }
            if (i == j) {
                cs[i] = s.charAt(i);
            }
            return String.valueOf(cs);
        }
    }
}
