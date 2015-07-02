import java.util.LinkedList;

public class L225ImplementStackUsingQueues {
	class MyStack {
		LinkedList<Integer> q1 = new LinkedList<Integer>();
		LinkedList<Integer> q2 = new LinkedList<Integer>();

		// Push element x onto stack.
		public void push(int x) {
			if (!q1.isEmpty())
				q1.offer(x);
			else
				q2.offer(x);
		}

		// Removes the element on top of the stack.
		public void pop() {
			if (!q1.isEmpty()) {
				while (q1.size() != 1) {
					q2.offer(q1.poll());
				}
				q1.poll();
			} else {
				while (q2.size() != 1) {
					q1.offer(q2.poll());
				}
				q2.poll();
			}
		}

		// Get the top element.
		public int top() {
			if (!q1.isEmpty()) {
				while (q1.size() != 1) {
					q2.offer(q1.poll());
				}
				int re = q1.poll();
				q2.offer(re);
				return re;
			} else {
				while (q2.size() != 1) {
					q1.offer(q2.poll());
				}
				int re = q2.poll();
				q1.offer(re);
				return re;
			}
		}

		// Return whether the stack is empty.
		public boolean empty() {
			return q1.isEmpty() && q2.isEmpty();
		}
	}
}
