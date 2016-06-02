public class L335SelfCrossing {
    public class Solution {
        public boolean isSelfCrossing(int[] x) {
            // Check for initial four values manually.
            if (x.length < 4) {
                for (int el : x) {
                    if (el == 0) {
                        return true;
                    }
                }
                return false;
            }
            for (int i = 3; i < x.length; i++) {
                int cur = x[i];
                if (cur == 0) {
                    return true;
                }
                //At any point of time, i-1 has to be less than i-3 in order to intersect. Draw few figures to realize this.
                if (x[i - 1] <= x[i - 3]) {
                    // Basic case. Straight forward intersection.
                    if (cur >= x[i - 2]) {
                        return true;
                    }
                    //Special case.
                    if (i >= 5) {
                        // if i-2 edge is less than i-4 th edge then it cannot intersect no matter what if i < i-2 th edge.
                        // cur < x[i-2] < x[i-4],螺旋形
                        if (x[i - 2] < x[i - 4]) {
                            continue;
                        }
                        // the intersecting case.
                        if ((x[i] + x[i - 4] >= x[i - 2]) && (x[i - 1] + x[i - 5] >= x[i - 3])) {
                            return true;
                        }
                    }
                }
                // equals case
                if (i >= 4) if (x[i - 1] == x[i - 3] && cur + x[i - 4] == x[i - 2]) {
                    return true;
                }

            }
            return false;
        }
    }
}
