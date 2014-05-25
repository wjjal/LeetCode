//Validate if a given string is numeric.
//
//Some examples:
//"0" => true
//" 0.1 " => true
//"abc" => false
//"1 a" => false
//"2e10" => true
//Note: It is intended for the problem statement to be ambiguous. 
//You should gather all requirements up front before implementing one.

public class ValidNumber {
	public class Solution {
		public boolean isNumber(String s) {
			if (s.trim().isEmpty()) {
				return false;
			}
			String regex = "[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?";
			if (s.trim().matches(regex)) {
				return true;
			} else {
				return false;
			}
		}
	}

	public class Solution2 {
		public boolean isNumber(String s) {
			int i = 0;
			while (s.charAt(i) == ' ') { // �Ƴ�ǰ��whitespace
				i++;
				if (i >= s.length()) {
					return false;
				}
			}
			if (s.charAt(i) == '+' || s.charAt(i) == '-') { // ���Է���λ
				i++;
			}
			int j = s.length() - 1;
			while (s.charAt(j) == ' ') { // �Ƴ���׺whitespace
				j--;
			}
			if (i <= j) {
				s = s.substring(i, j + 1);
			} else {
				return false;
			}

			int dot = -1; // ��¼���λ��
			int ee = -1; // ��¼e��λ��
			for (i = 0; i < s.length(); i++) {
				if (dot == -1 && s.charAt(i) == '.') {
					dot = i;
				} else if (ee == -1 && s.charAt(i) == 'e') {
					ee = i;
					if (i + 1 < s.length()
							&& (s.charAt(i + 1) == '-' || s.charAt(i + 1) == '+')) {
						i++;
					}
				} else {
					if (Character.isDigit(s.charAt(i))) {
						continue;
					} else {
						return false;
					}
				}
			}

			// xxx.xxexx
			String startStr, midStr, lastStr;
			if (dot == -1 && ee == -1) { // xxx
				startStr = s; // xxx
				if (startStr.length() < 1) {
					return false;
				}
			} else if (dot != -1 && ee == -1) { // xxx.yyy
				startStr = s.substring(0, dot); // xxx
				midStr = s.substring(dot + 1); // yyy
				if (startStr.length() < 1 && midStr.length() < 1) {
					return false;
				}
			} else if (dot == -1 && ee != -1) { // xxxeyyy
				startStr = s.substring(0, ee); // xxx
				if (startStr.length() < 1) {
					return false;
				}
				if (ee + 1 < s.length()
						&& (s.charAt(ee + 1) == '-' || s.charAt(ee + 1) == '+')) { // xxxe-zz
					lastStr = s.substring(ee + 2); // zz
				} else {
					lastStr = s.substring(ee + 1);
				}
				if (lastStr.length() < 1) {
					return false;
				}
			} else { // xxx.yyezz
				if (dot > ee) { // λ�ò���
					return false;
				}
				startStr = s.substring(0, dot); // xxx
				midStr = s.substring(dot + 1, ee); // yy
				if (startStr.length() < 1 && midStr.length() < 1) {
					return false;
				}
				if (ee + 1 < s.length()
						&& (s.charAt(ee + 1) == '-' || s.charAt(ee + 1) == '+')) {
					lastStr = s.substring(ee + 2); // zz
				} else {
					lastStr = s.substring(ee + 1);
				}
				if (lastStr.length() < 1) {
					return false;
				}
			}
			return true;
		}
	}
}