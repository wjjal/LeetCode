import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

//Given two words (start and end), and a dictionary, find all 
//shortest transformation sequence(s) from start to end, such that:
//
//Only one letter can be changed at a time
//Each intermediate word must exist in the dictionary
//For example,
//
//Given:
//start = "hit"
//end = "cog"
//dict = ["hot","dot","dog","lot","log"]
//Return
//  [
//    ["hit","hot","dot","dog","cog"],
//    ["hit","hot","lot","log","cog"]
//  ]
//Note:
//All words have the same length.
//All words contain only lowercase alphabetic characters.

public class WordLadderII {
	public static void main(String[] args){
		String start = "red";
		String end = "tax";
		Set<String> dict = new HashSet<String>();
		dict.add("ted");
		dict.add("tex");
		dict.add("red");
		dict.add("tax");
		dict.add("tad");
		dict.add("den");
		dict.add("rex");
		dict.add("pee");
		new WordLadderII().new Solution().findLadders(start,end,dict);
	}
	
	public class Solution {
	    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
	        List<List<String>> re = new ArrayList<List<String>>();
			if (start == null || end == null)
				return re;
			LinkedList<String> tmp = new LinkedList<String>();
			if(start.equals(end)){
			    tmp.add(start);
			    tmp.add(end);
			    re.add(tmp);
			    return re;
			}
			
	        
			HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
			map.put(end, new ArrayList<String>());
			map.put(start, new ArrayList<String>());
			for (String s : dict) {
				map.put(s, new ArrayList<String>());
			}
			
	        LinkedList<String> queue = new LinkedList<String>();
	        queue.offer(start);
			ArrayList<String> currentlevel = new ArrayList<String>();
			while (!queue.isEmpty()) {
				int level = queue.size();
				currentlevel.clear();
				for (int i = 0; i < level; i++) {
					String top = queue.poll();
					if (dict.contains(top))
						dict.remove(top);
					currentlevel.add(top);
				}
				boolean flag = false;
				for (String curs : currentlevel) {
					for (int i = 0; i < curs.length(); ++i) {
						for (char j = 'a'; j <= 'z'; ++j) {
							char[] tmpchars = curs.toCharArray();
							tmpchars[i] = j;
							String tmps = new String(tmpchars);
							if (tmps.equals(end)) {
								map.get(end).add(curs);
								flag = true;
							} else if (!tmps.equals(curs) && dict.contains(tmps)) {
								if (!queue.contains(tmps))
									queue.offer(tmps);
								map.get(tmps).add(curs);
							}
						}
					}
				}
				if (flag)
					break;
			}
			tmp.add(end);
			buildPath(start, end, map, tmp, re);
			return re;
		}
		
		public void buildPath(String start, String cur, HashMap<String, ArrayList<String>> map, LinkedList<String> tmp, List<List<String>> re) {
		    ArrayList<String> pre = map.get(cur);
		    if(cur.equals(start)){
		        re.add(new LinkedList<String>(tmp));
		        return;
		    }
		    for(String s : pre){
		        tmp.addFirst(s);
		        buildPath(start,s,map,tmp,re);
		        tmp.removeFirst();
		    }
		}
	}
}
