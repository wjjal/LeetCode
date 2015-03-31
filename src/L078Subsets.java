import java.util.ArrayList;
import java.util.Arrays;

//Given a set of distinct integers, S, return all possible subsets.
//
//Note:
//Elements in a subset must be in non-descending order.
//The solution set must not contain duplicate subsets.
//For example,
//If S = [1,2,3], a solution is:
//
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//]

public class L078Subsets {
	public class Solution {
		public ArrayList<ArrayList<Integer>> subsets(int[] S) {
			ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
			Arrays.sort(S);
			int len = S.length;
			int max = 1 << len;
			for (int i = 0; i < max; i++) {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				for (int j = 0; j < len; j++) {
					if ((i & (1 << j)) != 0)
						temp.add(S[j]);
				}
				re.add(temp);
			}
			return re;
		}
	}

	public class Solution2 {
		public ArrayList<ArrayList<Integer>> subsets(int[] S) {
			ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			Arrays.sort(S);
			res.add(tmp);
			dfs(res, tmp, S, 0);
			return res;
		}

		public void dfs(ArrayList<ArrayList<Integer>> res,
				ArrayList<Integer> tmp, int[] S, int pos) {
			for (int i = pos; i <= S.length - 1; i++) {
				tmp.add(S[i]);
				res.add(new ArrayList<Integer>(tmp));
				dfs(res, tmp, S, i + 1);
				tmp.remove(tmp.size() - 1);
			}
		}
	}
}
