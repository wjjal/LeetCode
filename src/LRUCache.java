import java.util.HashMap;

//Design and implement a data structure for Least Recently Used (LRU) cache. 
//It should support the following operations: get and set.
//
//get(key) - Get the value (will always be positive) of the key if the key exists 
//in the cache, otherwise return -1.
//set(key, value) - Set or insert the value if the key is not already present. 
//When the cache reached its capacity, it should invalidate the least recently 
//used item before inserting a new item.
public class LRUCache {
	private int capacity;
	private HashMap<Integer, Node> map = new HashMap<Integer, Node>();
	private Node head;
	private Node tail;
	int len;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.len = 0;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node latest = map.get(key);
			removeNode(latest);
			setHead(latest);
			return latest.val;
		} else
			return -1;
	}

	public void removeNode(Node node) {
		if (node.pre != null)
			node.pre.next = node.next;
		else
			head = node.next;
		if (node.next != null)
			node.next.pre = node.pre;
		else
			tail = node.pre;
	}

	private void setHead(Node node) {
		node.pre = null;
		node.next = head;
		if (head != null)
			head.pre = node;
		head = node;
		if (tail == null)
			tail = node;
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			Node oldnode = map.get(key);
			oldnode.val = value;
			removeNode(oldnode);
			setHead(oldnode);
		} else {
			Node newnode = new Node(key, value);
			if (len < capacity) {
				setHead(newnode);
				map.put(key, newnode);
				len++;
			} else {
				map.remove(tail.key);
				tail = tail.pre;
				if (tail != null)
					tail.next = null;
				setHead(newnode);
				map.put(key, newnode);
			}
		}
	}

	class Node {
		int val;
		int key;
		Node pre;
		Node next;

		public Node(int key, int value) {
			this.key = key;
			this.val = value;
		}
	}
}
