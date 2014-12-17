import java.util.HashMap;
import java.util.LinkedList;

//Clone an undirected graph. Each node in the graph contains 
//a label and a list of its neighbors.

public class CloneGraph {
	public class Solution {
	    public UndirectedGraphNode cloneGraph1(UndirectedGraphNode node) {
	        if(node == null)
	           return null;
	        HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
	        LinkedList<UndirectedGraphNode> q= new LinkedList<UndirectedGraphNode>();
	        q.offer(node);
	        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
	        map.put(node.label,head);
	        while(!q.isEmpty()){
	            UndirectedGraphNode tmp = q.poll();
	            UndirectedGraphNode cur = map.get(tmp.label);
	  
	            for(int i=0;i<tmp.neighbors.size();i++){
	                UndirectedGraphNode p = tmp.neighbors.get(i);
	                UndirectedGraphNode child = null;
	                if(!map.containsKey(p.label)){
	                   UndirectedGraphNode newNode = new UndirectedGraphNode(p.label);
	                   map.put(p.label,newNode);
	                   q.offer(p);
	                   child = newNode;
	                }
	                else
	                   child = map.get(p.label);
	                cur.neighbors.add(child);
	            }
	        }
			return head;
	    }

		public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
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
