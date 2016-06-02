import java.util.LinkedList;

public class L316RemoveDuplicateLetters {
    public class Solution {
        public String removeDuplicateLetters(String s) {
            char[] cs = s.toCharArray();
            int[] count = new int[26];
            boolean[] re = new boolean[26];
            LinkedList<Character> stack = new LinkedList<Character>();
            for (char c : cs) {
                count[c - 'a']++;
            }
            for (char c : cs) {
                count[c - 'a']--;
                if (stack.isEmpty()) {
                    stack.add(c);
                    re[c - 'a'] = true;
                    continue;
                }
                if (re[c - 'a']) {
                    continue;
                }
                while (!stack.isEmpty() && c < stack.getLast() && count[stack.getLast() - 'a'] > 0) {
                    char tmp = stack.removeLast();
                    re[tmp - 'a'] = false;
                }
                stack.add(c);
                re[c - 'a'] = true;
            }
            String res = "";
            while (!stack.isEmpty()) {
                res += stack.removeFirst();
            }
            return res;
        }
    }
}
