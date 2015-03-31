import java.util.ArrayList;

//Given a triangle, find the minimum path sum from top to bottom. 
//Each step you may move to adjacent numbers on the row below.
//
//For example, given the following triangle
//[
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
//The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
//
//Note:
//Bonus point if you are able to do this using only O(n) extra space, 
//where n is the total number of rows in the triangle.

public class L120Triangle {
	public class Solution {
		public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
			int min = Integer.MAX_VALUE;
				int[] temp = new int[triangle.size()];
				temp[0] = triangle.get(0).get(0);
				for (int i = 1; i < triangle.size(); i++) {
					ArrayList<Integer> now = triangle.get(i);
					int size = now.size();
					for (int j = size - 1; j >= 0; j--){
					    if(j==0)
					        temp[0] = temp[0] + now.get(0);
					    else if(j == size -1)
					    	temp[size - 1] = temp[size - 2] + now.get(size - 1);
					    else
					        temp[j] = Math.min(temp[j-1],temp[j]) + now.get(j);
					}
				}
				for (int val : temp) {
					if (val < min)
						min = val;
				}
				return min;
			}
		}
}
