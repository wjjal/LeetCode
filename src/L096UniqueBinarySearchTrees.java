//Given n, how many structurally unique BST's (binary search trees) 
//that store values 1...n?
//
//For example,
//Given n = 3, there are a total of 5 unique BST's.
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3

public class L096UniqueBinarySearchTrees {
	public static void main(String[] args) {
		new L096UniqueBinarySearchTrees().new Solution2().numTrees(3);
	}

	public class Solution {
		public int numTrees(int n) {
			int num[] = new int[n + 1];
			num[0] = 1;
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= i; j++)
					num[i] += num[j - 1] * num[i - j];
			}
			return num[n];

		}
	}

	public class Solution2 {
		public int numTrees(int n) {
			return numTrees(1, n);
		}

		public int numTrees(int start, int end) {
			if (start >= end)
				return 1;
			int totalNum = 0;
			for (int i = start + 1; i < end; i++) {
				totalNum += numTrees(start, i - 1) * numTrees(i + 1, end);
			}
			return totalNum;
		}
	}
}
