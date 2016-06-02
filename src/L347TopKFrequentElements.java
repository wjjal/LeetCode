import java.util.*;

public class L347TopKFrequentElements {
    public class Solution {
        public List<Integer> topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int i : nums) {
                int count = map.getOrDefault(i, 0);
                map.put(i, count + 1);
            }
            PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                pq.offer(entry);
                if (pq.size() > k) {
                    pq.poll();
                }
            }

            List<Integer> res = new LinkedList<>();
            while (!pq.isEmpty()) {
                res.add(0, pq.poll().getKey());
            }
            return res;
        }
    }
}
