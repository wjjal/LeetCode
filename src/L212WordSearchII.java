import java.util.*;

public class L212WordSearchII {
	Trie tree = new Trie();
	HashSet<String> hash = new HashSet<String>();

	public List<String> findWords(char[][] board, String[] words) {
		List<String> re = new ArrayList<String>();
		TrieNode root = tree.root;
		for (int i = 0; i < words.length; i++) {
			tree.insert(words[i]);
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				int idx = board[i][j] - 'a';
				if (root.children[idx] != null) {
					board[i][j] = '*';
					dfs(board, i, j, root.children[idx], re);
					board[i][j] = (char) (idx + 'a');
				}
			}
		}
		return re;
	}

	private void dfs(char[][] board, int i, int j, TrieNode node,
			List<String> re) {
		if (node.have) {
			String s = node.getWord();
			if (!hash.contains(s)) {
				hash.add(s);
				re.add(s);
			}
		}
		if (i - 1 >= 0 && board[i - 1][j] != '*') {
			int idx = board[i - 1][j] - 'a';
			if (node.children[idx] != null) {
				board[i - 1][j] = '*';
				dfs(board, i - 1, j, node.children[idx], re);
				board[i - 1][j] = (char) (idx + 'a');
			}
		}
		if (i + 1 < board.length && board[i + 1][j] != '*') {
			int idx = board[i + 1][j] - 'a';
			if (node.children[idx] != null) {
				board[i + 1][j] = '*';
				dfs(board, i + 1, j, node.children[idx], re);
				board[i + 1][j] = (char) (idx + 'a');
			}
		}
		if (j - 1 >= 0 && board[i][j - 1] != '*') {
			int idx = board[i][j - 1] - 'a';
			if (node.children[idx] != null) {
				board[i][j - 1] = '*';
				dfs(board, i, j - 1, node.children[idx], re);
				board[i][j - 1] = (char) (idx + 'a');
			}
		}
		if (j + 1 < board[i].length && board[i][j + 1] != '*') {
			int idx = board[i][j + 1] - 'a';
			if (node.children[idx] != null) {
				board[i][j + 1] = '*';
				dfs(board, i, j + 1, node.children[idx], re);
				board[i][j + 1] = (char) (idx + 'a');
			}
		}
	}

	class TrieNode {
		boolean have;
		char val;
		TrieNode father;
		TrieNode[] children;

		public TrieNode() {
			have = false;
			children = new TrieNode[26];
		}

		public String getWord() {
			TrieNode cur = this;
			StringBuffer sb = new StringBuffer();
			while (cur.father != null) {
				sb.insert(0, cur.val);
				cur = cur.father;
			}
			return sb.toString();
		}
	}

	public class Trie {
		private TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		public void insert(String word) {
			TrieNode cur = root;
			int len = word.length();
			for (int i = 0; i < len; i++) {
				int c = word.charAt(i) - 'a';
				if (cur.children[c] == null) {
					cur.children[c] = new TrieNode();
					cur.children[c].val = word.charAt(i);
					cur.children[c].father = cur;
				}
				cur = cur.children[c];
			}
			cur.have = true;
		}
	}
}
