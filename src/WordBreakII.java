import java.util.ArrayList;
import java.util.List;
import java.util.Set;

//Given a string s and a dictionary of words dict, 
//add spaces in s to construct a sentence where each word is a valid dictionary word.
//
//Return all such possible sentences.
//
//For example, given
//s = "catsanddog",
//dict = ["cat", "cats", "and", "sand", "dog"].
//
//A solution is ["cats and dog", "cat sand dog"].
public class WordBreakII {
	public class Solution {
		public List<String> wordBreak(String s, Set<String> dict) {
			int len = s.length();
			boolean dp[] = new boolean[len + 1];
			ArrayList<ArrayList<Integer>> prev = new ArrayList<ArrayList<Integer>>();
			for (int i = 0; i <= len; i++) {
				prev.add(new ArrayList<Integer>());
			}
			dp[0] = true;
			for (int i = 1; i <= len; i++) {
				for (int j = i - 1; j >= 0; j--) {
					if (dp[j] && dict.contains(s.substring(j, i))) {
						prev.get(i).add(j);
						dp[i] = true;
					}
				}
			}
			List<String> result = new ArrayList<String>();
			buildResult(s, prev, len, result, "");
			return result;
		}

		private void buildResult(String s, List<ArrayList<Integer>> prev,
				int end, List<String> result, String current) {
			ArrayList<Integer> prevs = prev.get(end);
			for (int i = 0; i < prevs.size(); i++) {
				int n = prevs.get(i);
				String sub = s.substring(n, end);
				String r = sub;
				if (!current.equals("")) {
					r = r + " " + current;
				}
				if (n == 0) {
					result.add(r);
				} else {
					buildResult(s, prev, n, result, r);
				}
			}
		}
	}
}
