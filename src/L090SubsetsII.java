import java.util.ArrayList;
import java.util.Arrays;

//Given a collection of integers that might contain duplicates, S, 
//return all possible subsets.
//
//Note:
//Elements in a subset must be in non-descending order.
//The solution set must not contain duplicate subsets.
//For example,
//If S = [1,2,2], a solution is:
//
//[
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
//]

public class L090SubsetsII {
	public class Solution {
		public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
			ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			Arrays.sort(num);
			res.add(tmp);
			dfs(res, tmp, num, 0);
			return res;
		}

		public void dfs(ArrayList<ArrayList<Integer>> res,
				ArrayList<Integer> tmp, int[] num, int pos) {
			for (int i = pos; i <= num.length - 1; i++) {
				tmp.add(num[i]);
				res.add(new ArrayList<Integer>(tmp));
				dfs(res, tmp, num, i + 1);
				tmp.remove(tmp.size() - 1);
				while (i < num.length - 1 && num[i] == num[i + 1])
					i++;
			}
		}
	}

	public class Solution2 {
		public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {

			Arrays.sort(num);
			ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
			ArrayList<ArrayList<Integer>> prev = new ArrayList<ArrayList<Integer>>();

			for (int i = num.length - 1; i >= 0; i--) {
				// get existing sets
				if (i == num.length - 1 || num[i] != num[i + 1]
						|| prev.size() == 0) {
					prev = new ArrayList<ArrayList<Integer>>();
					for (int j = 0; j < result.size(); j++) {
						prev.add(new ArrayList<Integer>(result.get(j)));
					}
				}
				// add current number to each element of the set
				for (ArrayList<Integer> temp : prev) {
					temp.add(0, num[i]);
				}
				// add each single number as a set, only if current element is
				// different with previous
				if (i == num.length - 1 || num[i] != num[i + 1]) {
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.add(num[i]);
					prev.add(temp);
				}
				// add all set created in this iteration
				for (ArrayList<Integer> temp : prev) {
					result.add(new ArrayList<Integer>(temp));
				}
			}

			// add empty set
			result.add(new ArrayList<Integer>());

			return result;

		}
	}
}
