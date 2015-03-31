import java.util.ArrayList;

//Given an index k, return the kth row of the Pascal's triangle.
//
//For example, given k = 3,
//Return [1,3,3,1].
//
//Note:
//Could you optimize your algorithm to use only O(k) extra space?

public class L119PascalsTriangleII {
	public class Solution {
		public ArrayList<Integer> getRow(int rowIndex) {
			ArrayList<Integer> result = new ArrayList<Integer>(rowIndex + 1);
			for (int i = 0; i <= rowIndex; i++) {
				result.add(0);
			}
			result.set(0, 1);
			for (int i = 1; i <= rowIndex; i++) {
				result.set(i, 1);
				for (int j = i - 1; j > 0; j--) {
					result.set(j, result.get(j) + result.get(j - 1));
				}
			}
			return result;
		}
	}
}
