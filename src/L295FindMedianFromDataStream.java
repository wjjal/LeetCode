import java.util.Comparator;
import java.util.PriorityQueue;

public class L295FindMedianFromDataStream {
    class MedianFinder {
        private PriorityQueue<Integer> small_heap = new PriorityQueue<Integer>();
        private PriorityQueue<Integer> big_heap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2.intValue() - o1.intValue();
            }
        });

        // Adds a number into the data structure.
        public void addNum(int num) {
            if (small_heap.size() == 0 && big_heap.size() == 0) {
                small_heap.add(num);
            } else if (small_heap.size() > big_heap.size()) {
                if (num > small_heap.peek()) {
                    big_heap.add(small_heap.poll());
                    small_heap.add(num);
                } else {
                    big_heap.add(num);
                }
            } else if (small_heap.size() < big_heap.size()) {
                if (num < big_heap.peek()) {
                    small_heap.add(big_heap.poll());
                    big_heap.add(num);
                } else {
                    small_heap.add(num);
                }
            } else {
                if (num < big_heap.peek()) {
                    big_heap.add(num);
                } else {
                    small_heap.add(num);
                }
            }
        }

        // Returns the median of current data stream
        public double findMedian() {
            if (small_heap.size() == 0 && big_heap.size() == 0) {
                return 0.0;
            } else if (small_heap.size() > big_heap.size()) {
                return (double) small_heap.peek();
            } else if (small_heap.size() < big_heap.size()) {
                return (double) big_heap.peek();
            } else {
                return (small_heap.peek() + big_heap.peek()) / 2.0;
            }
        }
    }
}
