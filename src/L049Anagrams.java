import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

//Given an array of strings, return all groups of strings that are anagrams.
//
//Note: All inputs will be in lower-case.

public class L049Anagrams {
	public class Solution {
		public ArrayList<String> anagrams(String[] strs) {
			ArrayList<String> re = new ArrayList<String>();
			HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
			for (String str : strs) {
				String sorted = sorted(str);
				if (map.containsKey(sorted)) {
					ArrayList<String> val = map.get(sorted);
					val.add(str);
				} else {
					ArrayList<String> val = new ArrayList<String>();
					val.add(str);
					map.put(sorted, val);
				}
			}
			Set<String> set = map.keySet();
			for (String s : set) {
				ArrayList<String> val = map.get(s);
				if (val.size() > 1)
					re.addAll(val);
			}
			return re;
		}

		public String sorted(String a) {
			char[] achar = a.toCharArray();
			Arrays.sort(achar);
			return new String(achar);
		}
	}
}
