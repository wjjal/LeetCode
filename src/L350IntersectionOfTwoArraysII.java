import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L350IntersectionOfTwoArraysII {
    public class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            Map<Integer, Integer> hash = new HashMap<>();
            List<Integer> re = new ArrayList<>();
            for (int i : nums1) {
                if (hash.containsKey(i)) {
                    hash.put(i, hash.get(i) + 1);
                } else {
                    hash.put(i, 1);
                }
            }
            for (int i : nums2) {
                if (hash.containsKey(i)) {
                    int count = hash.get(i);
                    if (count == 1) {
                        hash.remove(i);
                    } else {
                        hash.put(i, count - 1);
                    }
                    re.add(i);
                }
            }
            return re.stream().mapToInt(i -> i).toArray();
        }
    }
}
