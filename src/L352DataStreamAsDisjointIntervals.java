import java.util.*;

public class L352DataStreamAsDisjointIntervals {
    /**
     * Definition for an interval.
     * public class Interval {
     * int start;
     * int end;
     * Interval() { start = 0; end = 0; }
     * Interval(int s, int e) { start = s; end = e; }
     * }
     */
    public class SummaryRanges {
        private Map<Integer, Integer> valueToBond;//map val to containing interval left bound
        private Map<Integer, Interval> bondToInterval; // store intervals in TreeMap <left bound, interval>

        public SummaryRanges() {
            valueToBond = new HashMap<>();
            bondToInterval = new TreeMap<>();
        }

        public void addNum(int val) {
            //contained in an existing interval
            if (valueToBond.containsKey(val)) {
                return;
            }
            //isolated number, no connection to its left or right
            if (!valueToBond.containsKey(val - 1) && !valueToBond.containsKey(val + 1)) {
                valueToBond.put(val, val);
                bondToInterval.put(val, new Interval(val, val));
                return;
            }
            //may connect to left, right or both
            int left = valueToBond.containsKey(val - 1) ? valueToBond.get(val - 1) : val;
            int right = valueToBond.containsKey(val + 1) ? bondToInterval.get(valueToBond.get(val + 1)).end : val;
            valueToBond.put(val, left);
            valueToBond.put(right, left);
            bondToInterval.remove(val + 1);
            bondToInterval.put(left, new Interval(left, right));
        }

        public List<Interval> getIntervals() {
            return new ArrayList<>(bondToInterval.values());
        }
    }

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */
}
