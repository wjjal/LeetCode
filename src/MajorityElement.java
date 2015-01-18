//Given an array of size n, find the majority element. 
//The majority element is the element that appears more than ⌊ n/2 ⌋ times.
//
//You may assume that the array is non-empty and 
//the majority element always exist in the array.

public class MajorityElement {
	public class Solution {
		public int majorityElement(int[] num) {
			int count = 1;
			int re = num[0];
			for (int i = 1; i < num.length; i++) {
				if (num[i] == re)
					count++;
				else {
					if (count == 0) {
						count = 1;
						re = num[i];
					} else
						count--;
				}
			}
			return re;
		}
	}
}
