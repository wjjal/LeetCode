//There are N children standing in a line. Each child is assigned a rating value.
//
//You are giving candies to these children subjected to the following requirements:
//
//Each child must have at least one candy.
//Children with a higher rating get more candies than their neighbors.
//What is the minimum candies you must give?

public class Candy {
	public class Solution {
		public int candy(int[] ratings) {
			int len = ratings.length;
			int[] num = new int[len];
			num[0] = 1;
			for (int i = 1; i < len; i++) {
				if (ratings[i] > ratings[i - 1])
					num[i] = num[i - 1] + 1;
				else
					num[i] = 1;
			}
			int sum = num[len - 1];
			for (int i = len - 2; i >= 0; i--) {
				if (ratings[i] > ratings[i + 1] && num[i] <= num[i + 1])
					num[i] = num[i + 1] + 1;
				sum += num[i];
			}
			return sum;
		}
	}
}
