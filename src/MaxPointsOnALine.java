import java.util.HashMap;

//Given n points on a 2D plane, find the maximum number of 
//points that lie on the same straight line.
public class MaxPointsOnALine {
	public class Solution {
	    public int maxPoints(Point[] points) {
				HashMap<Double, Integer> map = new HashMap<Double, Integer>();
				int max = 0;
				double k;
				for (int i = 0; i < points.length; i++) {
					int maxcount = 0;
					int repeat = 1;
					map.clear();
					Point p = points[i];
					for (int j = i + 1; j < points.length; j++) {
						Point q = points[j];
						if (p.x == q.x && p.y == q.y)
							repeat++;
						else {
							if (p.x == q.x)
								k = Double.MAX_VALUE;
							else
								k = points[j].y == points[i].y ? 0.0
										: (1.0 * (points[j].y - points[i].y))
												/ (points[j].x - points[i].x);
							if (map.containsKey(k))
								map.put(k, map.get(k) + 1);
							else
								map.put(k, 1);
							if (map.get(k) > maxcount)
								maxcount = map.get(k);
						}
					}
					maxcount += repeat;
					max = Math.max(max, maxcount);
				}
				return max;
			}
	}
}
