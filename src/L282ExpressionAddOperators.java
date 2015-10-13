import java.util.ArrayList;
import java.util.List;

public class L282ExpressionAddOperators {
    public class Solution {
        public List<String> addOperators(String num, int target) {
            List<String> re = new ArrayList<String>();
            dfs(num, target, 0, 0, "", re);
            return re;
        }

        private void dfs(String num, int target, long diff, long curNum, String out, List<String> re) {
            if (num.length() == 0 && curNum == target) {
                re.add(out);
            }
            for (int i = 1; i <= num.length(); i++) {
                String curStr = num.substring(0, i);
                if (curStr.length() > 1 && curStr.charAt(0) == '0') {
                    return;
                }
                String next = num.substring(i);
                if (out.length() > 0) {
                    dfs(next, target, Long.valueOf(curStr), curNum + Long.valueOf(curStr), out + "+" + curStr, re);
                    dfs(next, target, -Long.valueOf(curStr), curNum - Long.valueOf(curStr), out + "-" + curStr, re);
                    dfs(next, target, diff * Long.valueOf(curStr), (curNum - diff) + diff * Long.valueOf(curStr),
                            out + "*" + curStr, re);
                } else {
                    dfs(next, target, Long.valueOf(curStr), Long.valueOf(curStr), curStr, re);
                }
            }
        }
    }
}
