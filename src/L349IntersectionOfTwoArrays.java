import java.util.HashSet;
import java.util.Set;

public class L349IntersectionOfTwoArrays {
    public class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> hash = new HashSet<>();
            Set<Integer> re = new HashSet<>();
            for (int i : nums1) {
                hash.add(i);
            }
            for (int i : nums2){
                if (hash.contains(i)){
                    re.add(i);
                }
            }
            return re.stream().mapToInt(i->i).toArray();
        }
    }
}
