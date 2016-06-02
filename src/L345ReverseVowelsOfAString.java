import java.util.HashSet;
import java.util.Set;

public class L345ReverseVowelsOfAString {
    public class Solution {
        public String reverseVowels(String s) {
            Set<Character> vowels = new HashSet<Character>();
            vowels.add('a');
            vowels.add('A');
            vowels.add('e');
            vowels.add('E');
            vowels.add('i');
            vowels.add('I');
            vowels.add('o');
            vowels.add('O');
            vowels.add('u');
            vowels.add('U');
            char[] cs = new char[s.length()];
            int i = 0, j = s.length() - 1;
            while (i < j) {
                if (vowels.contains(s.charAt(i)) && vowels.contains(s.charAt(j))) {
                    cs[i] = s.charAt(j);
                    cs[j] = s.charAt(i);
                    ++i;
                    --j;
                } else if (vowels.contains(s.charAt(i))) {
                    cs[j] = s.charAt(j--);
                } else if (vowels.contains(s.charAt(j))) {
                    cs[i] = s.charAt(i++);
                } else {
                    cs[i] = s.charAt(i++);
                    cs[j] = s.charAt(j--);
                }
            }
            if (i == j) {
                cs[i] = s.charAt(i);
            }
            return String.valueOf(cs);
        }
    }
}
