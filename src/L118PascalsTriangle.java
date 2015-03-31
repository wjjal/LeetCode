import java.util.ArrayList;

//Given numRows, generate the first numRows of Pascal's triangle.
//
//For example, given numRows = 5,
//Return
//
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//]

public class L118PascalsTriangle {
	public class Solution {
		public ArrayList<ArrayList<Integer>> generate(int numRows) {
			// Start typing your Java solution below
			// DO NOT write main() function
			ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
			if (numRows == 0)
				return result;
			ArrayList<Integer> first = new ArrayList<Integer>();
			first.add(1);
			result.add(first);
			for (int i = 2; i <= numRows; i++) {
				ArrayList<Integer> row = new ArrayList<Integer>();
				ArrayList<Integer> last = result.get(result.size() - 1);
				for (int j = 0; j < last.size(); j++) {
					int value = last.get(j);
					if (j > 0)
						value += last.get(j - 1);
					row.add(value);
				}
				row.add(1);
				result.add(row);
			}
			return result;
		}
	}
}
