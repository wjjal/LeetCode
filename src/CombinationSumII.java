import java.util.ArrayList;
import java.util.Arrays;

//Given a collection of candidate numbers (C) and a target number (T),
//find all unique combinations in C where the candidate numbers sums to T.
//
//Each number in C may only be used once in the combination.
//
//Note:
//All numbers (including target) will be positive integers.
//Elements in a combination (a1, a2, �� , ak) must be in non-descending order. 
//(ie, a1 �� a2 �� �� �� ak).
//The solution set must not contain duplicate combinations.
//For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
//A solution set is: 
//[1, 7] 
//[1, 2, 5] 
//[2, 6] 
//[1, 1, 6] 

public class CombinationSumII {
	public class Solution {
		public ArrayList<ArrayList<Integer>> combinationSum2(int[] a, int target) {
			ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> l = new ArrayList<Integer>();
			Arrays.sort(a);
			solve(a, target, 0, 0, l, res);
			return res;
		}

		public void solve(int[] a, int target, int sum, int i,
				ArrayList<Integer> l, ArrayList<ArrayList<Integer>> res) {
			if (sum == target) {
				if (res.contains(l))
					return;
				res.add(l);
				return;
			}
			if (sum > target || i >= a.length)
				return;
			if (a[i] + sum <= target) {
				ArrayList<Integer> tmp = new ArrayList<Integer>(l);
				tmp.add(a[i]);
				solve(a, target, sum + a[i], i + 1, tmp, res);
				solve(a, target, sum, i + 1, l, res);
			}
			return;
		}
	}
}
