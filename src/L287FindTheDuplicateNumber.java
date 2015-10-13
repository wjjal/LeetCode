public class L287FindTheDuplicateNumber {
    public class Solution {
        public int findDuplicate(int[] nums) {
            int fast = 0, slow = 0;
            do {
                fast = nums[nums[fast]];
                slow = nums[slow];
            } while (fast != slow);
            int start = 0, collision = fast;
            while (start != collision) {
                start= nums[start];
                collision = nums[collision];
            }
            return start;
        }
    }
}
