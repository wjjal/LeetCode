import java.util.HashMap;

//Given an array of integers, find two numbers such that they add up to a specific
//target number.
//
//The function twoSum should return indices of the two numbers such that they add up to 
//the target, where index1 must be less than index2. Please note that your returned 
//answers (both index1 and index2) are not zero-based.
//
//You may assume that each input would have exactly one solution.
//
//Input: numbers={2, 7, 11, 15}, target=9
//Output: index1=1, index2=2

public class TwoSum {
	public static void main(String[] args) {
		int[] numbers = { 3, 2, 4 };
		new TwoSum().new Solution().twoSum1(numbers, 6);
	}

	public class Solution {
		public int[] twoSum1(int[] numbers, int target) {
	        int re[] = new int[2];
	        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	        for(int i =0;i<numbers.length;i++){
	            int tmp =target-numbers[i];
	            if(map.containsKey(tmp)){
	                re[0] = map.get(tmp)+1;
	                re[1] = i+1;
	            }else {
	                map.put(numbers[i],i);
	            }
	        }
	        return re;
	    }

		public int[] twoSum2(int[] numbers, int target) {
			int len = numbers.length;
			assert (len >= 2);
			int[] ret = new int[2];
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			for (int i = 0; i < len; i++) {
				if (!map.containsKey(numbers[i])) {
					map.put(target - numbers[i], i); // save another number
				}

				if (map.containsKey(numbers[i])) { // check is another number
					int idx = map.get(numbers[i]);
					if (idx < i) {
						ret[0] = idx + 1; // +1 for not zero-based
						ret[1] = i + 1;
					}
				}
			}
			return ret;
		}
	}
}
