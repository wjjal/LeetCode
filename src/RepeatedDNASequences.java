import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, 
//for example: "ACGAATTCCG". When studying DNA, 
//it is sometimes useful to identify repeated sequences within the DNA.
//
//Write a function to find all the 10-letter-long sequences (substrings) 
//that occur more than once in a DNA molecule.
//
//For example,
//
//Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
//
//Return:
//["AAAAACCCCC", "CCCCCAAAAA"].

//A=0x41, C=0x43, G=0x47, T=0x54
//A=0101, C=0103, G=0107, T=0124
//A,C,G,T最后一位不同，所以用直接取最后一位1,3,7,4即可，即与mask“0111”作与运算可唯一标识ACGT。
//We can simply use s[i] & 7 to get the last digit which are just the last 3 bits.
public class RepeatedDNASequences {
	public static void main(String[] args) {
		String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		new RepeatedDNASequences().new Solution().findRepeatedDnaSequences(s);
	}

	public class Solution {
		public List<String> findRepeatedDnaSequences(String s) {
			int mask = 0x7FFFFFF;
			List<String> re = new LinkedList<String>();
			if (s.length() <= 10)
				return re;
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			int cur = 0;
			int i = 0;
			while (i < 9) {
				cur = (cur << 3) | (s.charAt(i++) & 7);
			}
			while (i < s.length()) {
				cur = ((cur & mask) << 3) | (s.charAt(i++) & 7);
				if (map.containsKey(cur)) {
					int counts = map.get(cur);
					if (counts == 1)
						re.add(s.substring(i - 10, i));
					map.put(cur, ++counts);
				} else {
					map.put(cur, 1);
				}
			}
			return re;
		}
	}
}
