public class L208ImplementTrie {
	class TrieNode {
		// Initialize your data structure here.
		boolean have;
		TrieNode[] children;

		public TrieNode() {
			have = false;
			children = new TrieNode[26];
		}
	}

	public class Trie {
		private TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		// Inserts a word into the trie.
		public void insert(String word) {
			TrieNode cur = root;
			int len = word.length();
			for (int i = 0; i < len; i++) {
				int c = word.charAt(i) - 'a';
				if (cur.children[c] == null) {
					cur.children[c] = new TrieNode();
				}
				cur = cur.children[c];
			}
			cur.have = true;
		}

		// Returns if the word is in the trie.
		public boolean search(String word) {
			TrieNode cur = root;
			int len = word.length();
			for (int i = 0; i < len; i++) {
				int c = word.charAt(i) - 'a';
				if (cur.children[c] == null) {
					return false;
				}
				cur = cur.children[c];
			}
			return cur.have;
		}

		// Returns if there is any word in the trie
		// that starts with the given prefix.
		public boolean startsWith(String prefix) {
			TrieNode cur = root;
			int len = prefix.length();
			for (int i = 0; i < len; i++) {
				int c = prefix.charAt(i) - 'a';
				if (cur.children[c] == null) {
					return false;
				}
				cur = cur.children[c];
			}
			return true;
		}
	}

	// Your Trie object will be instantiated and called as such:
	// Trie trie = new Trie();
	// trie.insert("somestring");
	// trie.search("key");
}
