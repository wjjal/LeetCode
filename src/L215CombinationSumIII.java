import java.util.*;

public class L215CombinationSumIII {
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> re = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		dfs(re, 1, 0, k, n, tmp);
		return re;
	}

	private void dfs(List<List<Integer>> re, int cur, int sum, int k, int n,
			List<Integer> tmp) {
		if (sum > n || tmp.size() > k) {
			return;
		}
		if (tmp.size() == k && sum == n) {
			re.add(new ArrayList<Integer>(tmp));
		} else {
			for (int i = cur; i <= 9; i++) {
				tmp.add(i);
				dfs(re, i + 1, sum + i, k, n, tmp);
				tmp.remove(tmp.size() - 1);
			}
		}
	}
}
