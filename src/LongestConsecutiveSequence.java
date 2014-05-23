import java.util.HashSet;
import java.util.Set;

//Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
//
//For example,
//Given [100, 4, 200, 1, 3, 2],
//The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
//
//Your algorithm should run in O(n) complexity.

public class LongestConsecutiveSequence {
	public class Solution {
	    public int longestConsecutive(int[] num) {
				if (num.length == 0)
					return 0;
				int max = 1;
				Set<Integer> hash = new HashSet<Integer>();
				for (int i : num)
					hash.add(i);
				for (int e : num) {
					int left = e - 1;
					int right = e + 1;
					int count = 1;
					hash.remove(e);
					while(hash.contains(left)){
					    count++;
					    hash.remove(left);
					    left--;
					}
					while(hash.contains(right)){
						count++;
						hash.remove(right);
						right++;
					}
					max = Math.max(max, count);
				}
				return max;
			}
	}
}
