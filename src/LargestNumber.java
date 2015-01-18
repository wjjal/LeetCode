import java.util.Arrays;
import java.util.Comparator;

//Given a list of non negative integers, 
//arrange them such that they form the largest number.
//
//For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
//
//Note: The result may be very large, 
//so you need to return a string instead of an integer.

public class LargestNumber {
	public static void main(String[] args) {
		int[] num = { 1 };
		new LargestNumber().new Solution().largestNumber(num);
	}

	public class Solution {
		public String largestNumber(int[] num) {
			int len = num.length;
			String[] sn = new String[len];
			for (int i = 0; i < len; i++)
				sn[i] = String.valueOf(num[i]);
			Arrays.sort(sn, new Comparator<String>() {
				@Override
				public int compare(String a, String b) {
					return (a + b).compareTo(b + a);
				}
			});
			String re = "";
			for (int i = len - 1; i >= 0; i--) {
				re += sn[i];
			}
			int i = 0;
			while (i < re.length() - 1 && re.charAt(i) == '0') {
				i++;
			}
			re = re.substring(i);
			return re;
		}
	}
}
