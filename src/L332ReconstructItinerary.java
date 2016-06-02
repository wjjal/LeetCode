import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class L332ReconstructItinerary {
    public class Solution {
        public List<String> findItinerary(String[][] tickets) {
            HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
            for (String[] ticket : tickets) {
                if (map.containsKey(ticket[0])) {
                    ArrayList<String> to_list = map.get(ticket[0]);
                    to_list.add(ticket[1]);
                    map.put(ticket[0], to_list);
                } else {
                    ArrayList<String> to_list = new ArrayList<String>();
                    to_list.add(ticket[1]);
                    map.put(ticket[0], to_list);
                }
            }
            for (ArrayList<String> curr : map.values()) {
                Collections.sort(curr);
            }
            ArrayList<String> re = new ArrayList<String>();
            help("JFK", re, map, tickets.length + 1);
            return re;
        }

        public boolean help(String cur, List<String> re, HashMap<String, ArrayList<String>> map, int n) {
            re.add(cur);
            if (re.size() >= n) {
                return true;
            }
            if (!map.containsKey(cur) || map.get(cur).isEmpty()) {
                return false;
            }
            ArrayList<String> arrivals = map.get(cur);
            for (int i = 0; i < arrivals.size(); i++) { // iterate each arrival point
                String arrival = map.get(cur).remove(i);
                if (help(arrival, re, map, n)) {
                    return true;
                }
                re.remove(re.size() - 1); // backtrack
                arrivals.add(i, arrival);
            }
            return false;
        }
    }
}
