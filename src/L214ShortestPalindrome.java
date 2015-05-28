public class L214ShortestPalindrome {
	public String shortestPalindrome(String s) {
		int len = s.length();
		int n = 2 * len + 3;
		char[] cs = new char[n];
		cs[0] = '$';
		cs[1] = '#';
		for (int i = 0; i < len; i++) {
			cs[2 * i + 2] = s.charAt(i);
			cs[2 * i + 3] = '#';
		}
		cs[2 * len + 2] = '!';
		int mx = 0;
		int id = 0;
		int p[] = new int[n];
		int maxlenfrombegin = 0;
		for (int i = 1; i < n - 1; i++) {
			if (mx > i) {
				p[i] = Math.min(p[2 * id - i], mx - i);
			} else {
				p[i] = 1;
			}
			while (cs[i + p[i]] == cs[i - p[i]]) {
				p[i]++;
			}
			if (i + p[i] > mx) {
				mx = i + p[i];
				id = i;
				if (i - p[i] == 0) {
					maxlenfrombegin = mx;
				}
			}
		}
		maxlenfrombegin = maxlenfrombegin / 2 - 1;
		StringBuffer sb = new StringBuffer();
		for (int i = len - 1; i >= maxlenfrombegin; i--) {
			sb.append(s.charAt(i));
		}
		sb.append(s);
		return sb.toString();
	}
}
