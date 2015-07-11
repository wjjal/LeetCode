public class L233NumberOfDigitOne {
	public int countDigitOne(int n) {
		int re = 0;
		int mask = 1;
		if (n <= 0)
			return 0;
		while (n >= mask) {
			int left = n / mask;
			int right = n % mask;
			if ((left % 10) >= 2) {
				re += (left / 10 + 1) * mask;
			} else if ((left % 10) == 1) {
				re += (left / 10) * mask + (right + 1);
			} else {
				re += (left / 10) * mask;
			}
			mask *= 10;
		}
		return re;
	}
}
