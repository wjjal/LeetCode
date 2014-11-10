//The count-and-say sequence is the sequence of integers beginning as follows:
//1, 11, 21, 1211, 111221, ...
//
//1 is read off as "one 1" or 11.
//11 is read off as "two 1s" or 21.
//21 is read off as "one 2, then one 1" or 1211.
//Given an integer n, generate the nth sequence.
//
//Note: The sequence of integers will be represented as a string.

public class CountAndSay {
	public static void main(String[] args){
		System.out.println(new CountAndSay().new Solution().countAndSay(5));
	}
	public class Solution {
		public String countAndSay(int n) {
			String re = "1";
			if (n == 1)
				return re;
			for (int i = 2; i <= n; i++) {
				String temp = "";
				int count = 1;
				for (int j = 0; j < re.length() - 1; j++) {
					if (re.charAt(j) == re.charAt(j + 1)) {
						count++;
					} else {
						temp += count;
						count = 1;
						temp += re.charAt(j);
					}
				}
				temp += count;
				temp += re.charAt(re.length() - 1);
				re = temp;
			}
			return re;
		}
	}
}
