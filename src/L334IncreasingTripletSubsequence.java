public class L334IncreasingTripletSubsequence {
    public class Solution {
        public boolean increasingTriplet(int[] nums) {
            int min = Integer.MAX_VALUE;
            int second_min = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] <= min) {
                    min = nums[i];
                } else if (nums[i] <= second_min) {
                    second_min = nums[i];
                } else {
                    return true;
                }
            }
            return false;
        }
    }
}
