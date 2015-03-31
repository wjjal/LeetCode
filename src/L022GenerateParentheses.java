import java.util.ArrayList;

//Given n pairs of parentheses, write a function to generate all combinations of 
//well-formed parentheses.
//
//For example, given n = 3, a solution set is:
//
//"((()))", "(()())", "(())()", "()(())", "()()()"

public class L022GenerateParentheses {
	public class Solution {
	    public ArrayList<String> generateParenthesis(int n) {
	        ArrayList<String> list =new ArrayList<String>();
	        char[] str = new char[n * 2];
			PrintPair(list, n, n, str, 0);
			return list;
	    }
	    
		public void PrintPair(ArrayList<String> list, int l, int r, char[] str, int count) {
			if (l < 0 || r < l)
				return;
			if (l == 0 && r == 0)
				list.add(new String(str));
			else {
				if (l > 0) {
					str[count] = '(';
					PrintPair(list, l - 1, r, str, count + 1);
				}
				if (r > l) {
					str[count] = ')';
					PrintPair(list, l, r - 1, str, count + 1);
				}
			}
		}
	}
}
