import java.util.LinkedList;

public class L210CourseScheduleII {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int re[] = new int[numCourses];
		int m = prerequisites.length;
		int count[] = new int[numCourses];
		LinkedList<Integer> stack = new LinkedList<Integer>();
		int p = 0;
		for (int i = 0; i < m; i++) {
			count[prerequisites[i][0]]++;
		}
		for (int i = 0; i < numCourses; i++) {
			if (count[i] == 0) {
				stack.push(i);
				re[p++] = i;
			}
		}
		while (!stack.isEmpty()) {
			int cur = stack.pop();
			for (int i = 0; i < m; i++) {
				if (prerequisites[i][1] == cur) {
					if (--count[prerequisites[i][0]] == 0) {
						stack.push(prerequisites[i][0]);
						re[p++] = prerequisites[i][0];
					}
				}
			}
		}
		return p < numCourses ? new int[0] : re;
	}
}
