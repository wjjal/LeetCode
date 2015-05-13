import java.util.LinkedList;

public class L207CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if (numCourses == 0)
			return true;
		int m = prerequisites.length;
		if (m == 0)
			return true;
		int count[] = new int[numCourses];
		LinkedList<Integer> stack = new LinkedList<Integer>();
		int can = 0;
		for (int i = 0; i < m; i++) {
			count[prerequisites[i][0]]++;
		}
		for (int i = 0; i < numCourses; i++) {
			if (count[i] == 0) {
				stack.push(i);
				can++;
			}
		}
		while (!stack.isEmpty()) {
			int cur = stack.pop();
			for (int i = 0; i < m; i++) {
				if (prerequisites[i][1] == cur) {
					if (--count[prerequisites[i][0]] == 0) {
						stack.push(prerequisites[i][0]);
						can++;
					}
				}
			}
		}
		return can < numCourses ? false : true;
	}
}
