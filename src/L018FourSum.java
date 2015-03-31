import java.util.ArrayList;
import java.util.Arrays;

//Given an array S of n integers, are there elements a, b, c, 
//and d in S such that a + b + c + d = target? Find all unique quadruplets 
//in the array which gives the sum of target.
//
//Note:
//Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ¡Ü b ¡Ü c ¡Ü d)
//The solution set must not contain duplicate quadruplets.
//For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
//
//A solution set is:
//(-1,  0, 0, 1)
//(-2, -1, 1, 2)
//(-2,  0, 0, 2)

public class L018FourSum {
	public class Solution {
		public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
			Arrays.sort(num);
			ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
			for (int i = 0; i < num.length; i++) {
				if (i == 0 || num[i] > num[i - 1]) {
					for (int j = i + 1; j < num.length; j++) {
						if (j == i + 1 || num[j] > num[j - 1]) {
							int k = j + 1;
							int l = num.length - 1;
							while (k < l) {
								int sum = num[i] + num[j] + num[k] + num[l];
								if (sum < target)
									k++;
								else if (sum > target)
									l--;
								else {
									ArrayList<Integer> temp = new ArrayList<Integer>();
									temp.add(num[i]);
									temp.add(num[j]);
									temp.add(num[k]);
									temp.add(num[l]);
									result.add(temp);
									k++;
									l--;
									while (k < l && num[k] == num[k - 1])
										k++;
									while (k < l && num[l] == num[l + 1])
										l--;
								}
							}
						}
					}
				}
			}
			return result;
		}
	}
}
