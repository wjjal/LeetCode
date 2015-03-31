import java.util.ArrayList;

//Given a digit string, return all possible letter combinations that the number 
//could represent.
//
//A mapping of digit to letters (just like on the telephone buttons) is given below.

//Input:Digit string "23"
//Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

//Note:
//Although the above answer is in lexicographical order, 
//your answer could be in any order you want.
public class L017LetterCombinationsOfAPhoneNumber {
	public class Solution {
		public String array[] = { "", "", "abc", "def", "ghi", "jkl", "mno",
				"pqrs", "tuv", "wxyz" };

		public ArrayList<String> letterCombinations(String digits) {
			ArrayList<String> list = new ArrayList<String>();
			if (digits == null)
				return list;
			char numArr[] = digits.toCharArray();
			StringBuffer sb = new StringBuffer();
			dfs(list, sb, 0, numArr);
			return list;
		}

		private void dfs(ArrayList<String> list, StringBuffer sb, int start,
				char[] numArr) {
			if (start == numArr.length) {
				list.add(sb.toString());
				return;
			}
			if (numArr[start] >= '0' && numArr[start] <= '9') {
				String str = array[numArr[start] - '0'];
				int len = str.length();
				for (int i = 0; i < len; i++) {
					StringBuffer newsb = new StringBuffer(sb);
					newsb.append(String.valueOf(str.charAt(i)));
					dfs(list, newsb, start + 1, numArr);
				}
			}
		}
	}
}
