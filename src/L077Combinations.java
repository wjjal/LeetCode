import java.util.ArrayList;

//Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
//
//For example,
//If n = 4 and k = 2, a solution is:
//
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]

public class L077Combinations {
	public class Solution {
		public ArrayList<ArrayList<Integer>> combine(int n, int k) {
			ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> temp = new ArrayList<Integer>();
			if (n < k)
				return re;
			combine(n, k, re, temp, 1);
			return re;
		}

		private void combine(int n, int k, ArrayList<ArrayList<Integer>> re,
				ArrayList<Integer> temp, int start) {
			if (temp.size() + n - start + 1 < k)
				return;
			if (temp.size() == k) {
				re.add(new ArrayList<Integer>(temp));
				return;
			} else {
				for (int i = start; i <= n; i++) {
					temp.add(i);
					combine(n, k, re, temp, i + 1);
					temp.remove(temp.size() - 1);
				}
			}
		}
	}
}
