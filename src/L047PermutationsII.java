import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given a collection of numbers that might contain duplicates, 
//return all possible unique permutations.
//
//For example,
//[1,1,2] have the following unique permutations:
//[1,1,2], [1,2,1], and [2,1,1].

public class L047PermutationsII {
	public static void main(String[] args) {
		int num[] = { 1, 1, 2 };
		new L047PermutationsII().new Solution().permuteUnique(num);
	}

	public class Solution {
		public List<List<Integer>> permuteUnique(int[] num) {
			Arrays.sort(num);
			List<List<Integer>> re = new ArrayList<List<Integer>>();
			List<Integer> temp = new ArrayList<Integer>();
			permute(num, 0, re, temp);
			return re;
		}

		private void permute(int[] num, int start, List<List<Integer>> re,
				List<Integer> temp) {
			if (temp.size() == num.length) {
				re.add(new ArrayList<Integer>(temp));
				return;
			}
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
