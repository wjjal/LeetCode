import java.util.*;

public class L218TheSkylineProblem {
	public List<int[]> getSkyline(int[][] buildings) {
		List<int[]> list = new ArrayList<int[]>();
		if (buildings == null || buildings.length == 0)
			return list;
		int[][] all = new int[buildings.length * 2][3];
		int n = 0;
		for (int i = 0; i < buildings.length; i++) {
			all[n][0] = buildings[i][0];
			all[n][1] = buildings[i][2];
			all[n++][2] = 1;
			all[n][0] = buildings[i][1];
			all[n][1] = buildings[i][2];
			all[n++][2] = -1;
		}

		Arrays.sort(all, new Comparator<int[]>() {
			public int compare(int[] h1, int[] h2) {
				return h1[0] - h2[0];
			}
		});

		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(300,
				Collections.reverseOrder());
		int i = 0;
		int[] pre = null;
		while (i < all.length) {
			int j = i + 1;
			while (j < all.length && all[i][0] == all[j][0]) {
				j++;
			}
			for (int k = i; k < j; k++) {
				if (all[k][2] == -1)
					queue.remove(all[k][1]);
			}
			for (int k = i; k < j; k++) {
				if (all[k][2] == 1)
					queue.offer(all[k][1]);
			}
			int high = (queue.peek() == null ? 0 : queue.peek());
			if (pre == null || high != pre[1]) {
				int[] p = { all[i][0], high };
				list.add(p);
				pre = p;
			}
			i = j;
		}
		return list;
	}
}