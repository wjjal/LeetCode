import java.util.ArrayList;
import java.util.Arrays;

//Given a collection of candidate numbers (C) and a target number (T),
//find all unique combinations in C where the candidate numbers sums to T.
//
//Each number in C may only be used once in the combination.
//
//Note:
//All numbers (including target) will be positive integers.
//Elements in a combination (a1, a2, ¡­ , ak) must be in non-descending order. 
//(ie, a1 ¡Ü a2 ¡Ü ¡­ ¡Ü ak).
//The solution set must not contain duplicate combinations.
//For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
//A solution set is: 
//[1, 7] 
//[1, 2, 5] 
//[2, 6] 
//[1, 1, 6] 

public class L040CombinationSumII {
	public static void main(String[] args) {
		int a[] = { 1, 2 };
		int target = 1;
		new L040CombinationSumII().new Solution().combinationSum2(a, target);
	}

	public class Solution {
		public ArrayList<ArrayList<Integer>> combinationSum2(int[] a, int target) {
			ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> temp = new ArrayList<Integer>();
			Arrays.sort(a);
			solve(a, target, 0, temp, res);
			return res;
		}

		public void solve(int[] a, int target, int start,
				ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> res) {
			if (target == 0) {
				res.add(new ArrayList<Integer>(temp));
				return;
			}
			if (target < 0 || start >= a.length)
				return;
			for (int i = start; i < a.length; i++) {
				if (i > start && a[i] == a[i - 1])
					continue;
				temp.add(a[i]);
				solve(a, target - a[i], i + 1, temp, res);
				temp.remove(temp.size() - 1);
			}
		}
	}
}
