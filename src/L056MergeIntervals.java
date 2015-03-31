import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//Given a collection of intervals, merge all overlapping intervals.
//
//For example,
//Given [1,3],[2,6],[8,10],[15,18],
//return [1,6],[8,10],[15,18].

public class L056MergeIntervals {
	public class Solution {
		public List<Interval> merge(List<Interval> intervals) {
	        if(intervals.size() <= 1)
	            return intervals;
	        Collections.sort(intervals, new Comparator<Interval>(){
	            public int compare(Interval a, Interval b){
	                return a.start - b.start;
	            }
	        });
	        List<Interval> re = new ArrayList<Interval>();
	        int begin = intervals.get(0).start;
	        int end = intervals.get(0).end;
	        for(int i=1;i<intervals.size();i++){
	            if(intervals.get(i).start > end){
	                re.add(new Interval(begin,end));
	                begin = intervals.get(i).start;
	                end = intervals.get(i).end;
	            } else
	                end = Math.max(end,intervals.get(i).end);
	        }
	        re.add(new Interval(begin,end));
	        return re;
	    }
	}
}
