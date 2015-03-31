	import java.util.ArrayList;
import java.util.EmptyStackException;
public class L155MinStack {
	class MinStack {
		ArrayList<Integer> stack = new ArrayList<Integer>();
		int size = 0;
		ArrayList<Integer> minstack = new ArrayList<Integer>();
		int min_size = 0;

		public void push(int x) {
			stack.add(x);
			size++;
			if (minstack.size() == 0) {
				minstack.add(x);
				min_size++;
			} else {
				int min = minstack.get(min_size - 1);
				if (x <= min) {
					minstack.add(x);
					min_size++;
				}
			}
		}

		public void pop() {
			if (size > 0) {
				int temp = stack.remove(size - 1);
				size--;
				if (temp == minstack.get(min_size - 1)) {
					minstack.remove(min_size - 1);
					min_size--;
				}
			} else
				throw new EmptyStackException();
		}

		public int top() {
			if (size > 0)
				return stack.get(size - 1);
			else
				throw new EmptyStackException();
		}

		public int getMin() {
			if (min_size > 0)
				return minstack.get(min_size - 1);
			else
				throw new EmptyStackException();
		}
	}
}
