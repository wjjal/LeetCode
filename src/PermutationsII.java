import java.util.ArrayList;

//Given a collection of numbers that might contain duplicates, 
//return all possible unique permutations.
//
//For example,
//[1,1,2] have the following unique permutations:
//[1,1,2], [1,2,1], and [2,1,1].

public class PermutationsII {
	public class Solution {
		public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
			ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> temp = new ArrayList<Integer>();
			permute(num, 0, re, temp);
			return re;
		}

		private void permute(int[] num, int start,
				ArrayList<ArrayList<Integer>> re, ArrayList<Integer> temp) {
			if (temp.size() == num.length) {
				re.add(new ArrayList<Integer>(temp));
				return;
			} else {
				for (int i = start; i < num.length; i++) {
					if (!sameNum(num, start, i)) {
						temp.add(num[i]);
						swap(num, start, i);
						permute(num, start + 1, re, temp);
						swap(num, start, i);
						temp.remove(temp.size() - 1);
					}
				}
			}
		}

		private boolean sameNum(int[] array, int i, int j) {
			for (; i < j; i++) {
				if (array[i] == array[j])
					return true;
			}
			return false;
		}

		private void swap(int[] array, int i, int j) {
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}

	}
}
