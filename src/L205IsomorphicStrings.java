import java.util.*;

public class L205IsomorphicStrings {
	public boolean isIsomorphic(String s, String t) {
		Map<Character, Character> hash = new HashMap<Character, Character>();
		for (int i = 0; i < s.length(); i++) {
			char sc = s.charAt(i);
			char tc = t.charAt(i);
			if (hash.containsKey(sc)) {
				if (hash.get(sc) != tc) {
					return false;
				}
			} else if (hash.containsValue(tc)) {
				return false;
			} else {
				hash.put(sc, tc);
			}
		}
		return true;
	}
}
