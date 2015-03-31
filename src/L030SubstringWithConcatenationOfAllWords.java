import java.util.ArrayList;
import java.util.HashMap;

//You are given a string, S, and a list of words, L, 
//that are all of the same length. Find all starting indices of substring(s) in S 
//that is a concatenation of each word in L exactly once and without any intervening characters.
//
//For example, given:
//S: "barfoothefoobarman"
//L: ["foo", "bar"]
//
//You should return the indices: [0,9].
//(order does not matter).

public class L030SubstringWithConcatenationOfAllWords {
	public class Solution {
		public ArrayList<Integer> findSubstring(String S, String[] L) {
			ArrayList<Integer> re = new ArrayList<Integer>();
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			for (String str : L) {
				if (map.containsKey(str)) {
					map.put(str, map.get(str) + 1);
				} else {
					map.put(str, 1);
				}
			}
			int wordlen = L[0].length();
			int wordnumber = L.length;
			int totallen = wordlen * wordnumber;
			for (int i = 0; i <= S.length() - totallen; i++) {
				HashMap<String, Integer> temp = new HashMap<String, Integer>(
						map);
				int count = 0;
				for (int j = i; j <= i + totallen - wordlen; j += wordlen) {
					String sub = S.substring(j, j + wordlen);
					if (temp.containsKey(sub)) {
						int times = temp.get(sub);
						if (times == 1) {
							temp.remove(sub);
						} else {
							temp.put(sub, times - 1);
						}
						count++;
					} else {
						break;
					}
				}
				if (count == wordnumber) {
					re.add(i);
				}
			}
			return re;
		}
	}
}
