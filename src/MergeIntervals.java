import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//Given a collection of intervals, merge all overlapping intervals.
//
//For example,
//Given [1,3],[2,6],[8,10],[15,18],
//return [1,6],[8,10],[15,18].

public class MergeIntervals {
	public class Solution {
	    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
	        if (intervals.size() <= 1)
				return intervals;
			Collections.sort(intervals, new IntervalComparator());  
			ArrayList<Interval> re = new ArrayList<Interval>();
			int begin = intervals.get(0).start, end = intervals.get(0).end;
			for (int i = 1; i < intervals.size(); i++) {
				if (intervals.get(i).start > end) {
					re.add(new Interval(begin, end));
					begin = intervals.get(i).start;
					end = intervals.get(i).end;
				} else
					end = Math.max(intervals.get(i).end, end);
			}
			re.add(new Interval(begin, end));
			return re;
		}
		
		public class IntervalComparator implements Comparator<Interval> {
			public int compare(Interval a, Interval b) {
				return a.start - b.start;
			}
		}
	}
}
