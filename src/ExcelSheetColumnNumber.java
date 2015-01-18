//Given a column title as appear in an Excel sheet, 
//return its corresponding column number.
//
//For example:
//
//    A -> 1
//    B -> 2
//    C -> 3
//    ...
//    Z -> 26
//    AA -> 27
//    AB -> 28 
public class ExcelSheetColumnNumber {
	public class Solution {
		public int titleToNumber(String s) {
			int n = s.length();
			int re = 0;
			for (int i = 0; i < n; i++) {
				char c = s.charAt(i);
				re = re * 26 + (c - 'A') + 1;
			}
			return re;
		}
	}
}
