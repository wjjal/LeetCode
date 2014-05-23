import java.util.HashMap;

//Clone an undirected graph. Each node in the graph contains 
//a label and a list of its neighbors.

public class CloneGraph {
	public class Solution {
		public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
			HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
			return cloneGraph(node,map);
		}

		private UndirectedGraphNode cloneGraph(UndirectedGraphNode node,
				HashMap<Integer, UndirectedGraphNode> map) {
			if(node == null)
				return node;
			if(map.containsKey(node.label))
				return map.get(node.label);
			UndirectedGraphNode rs = new UndirectedGraphNode(node.label);
			map.put(node.label, rs);
			for(int i=0;i<node.neighbors.size();i++)
				rs.neighbors.add(cloneGraph(node.neighbors.get(i),map));
			return rs;
		}
	}
}
