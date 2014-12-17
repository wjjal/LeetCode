import java.util.LinkedList;

//Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
//
//A region is captured by flipping all 'O's into 'X's in that surrounded region.
//
//For example,
//X X X X
//X O O X
//X X O X
//X O X X
//After running your function, the board should be:
//
//X X X X
//X X X X
//X X X X
//X O X X

public class SurroundedRegions {
	public static void main(String[] args) {
		char[][] board = { { 'O', 'O' }, { 'O', 'O' } };
		new SurroundedRegions().new Solution().solve(board);
	}

	public class Solution {
		public void solve(char[][] board) {
			if (board.length == 0) {
				return;
			}
			if (board[0].length == 0) {
				return;
			}
			int row = board.length;
			int col = board[0].length;
			int[][] visit = new int[row][col];
			for (int j = 0; j < col; j++) {
				if (board[0][j] == 'O')
					bfs(board, 0, j, visit);
			}
			for (int j = 0; j < col; j++) {
				if (board[row - 1][j] == 'O')
					bfs(board, row - 1, j, visit);
			}
			for (int i = 0; i < row; i++) {
				if (board[i][0] == 'O')
					bfs(board, i, 0, visit);
			}
			for (int i = 0; i < row; i++) {
				if (board[i][col - 1] == 'O')
					bfs(board, i, col - 1, visit);
			}

			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if (board[i][j] == 'P')
						board[i][j] = 'O';
					else if (board[i][j] == 'O')
						board[i][j] = 'X';
				}
			}
		}

		void bfs(char[][] board, int i, int j, int[][] visit) {
			int row = board.length;
			int col = board[0].length;
			LinkedList<Integer> queue = new LinkedList<Integer>();
			if (visit[i][j] == 0) {
				queue.offer(i * col + j);
				while (!queue.isEmpty()) {
					int cur = queue.poll();
					int x = cur / col;
					int y = cur % col;
					if (x < 0 || x >= row || y < 0 || y >= col
							|| visit[x][y] == 1 || board[x][y] != 'O')
						continue;
					board[x][y] = 'P';
					visit[x][y] = 1;
					queue.offer((x - 1) * col + y);
					queue.offer((x + 1) * col + y);
					queue.offer(x * col + y - 1);
					queue.offer(x * col + y + 1);
				}
			}
		}
	}
	
	// public class Solution {
	// private LinkedList<Integer> queue = new LinkedList<Integer>();
	// public void solve(char[][] board) {
	// if (board.length == 0) {
	// return;
	// }
	// if (board[0].length == 0) {
	// return;
	// }
	// int row = board.length;
	// int col = board[0].length;
	//
	// // up row
	// for (int j = 0; j < col; j++) {
	// if (board[0][j] == 'O') {
	// bfs(board, 0, j);
	// }
	// }
	//
	// // bottom row
	// for (int j = 0; j < col; j++) {
	// if (board[row - 1][j] == 'O') {
	// bfs(board, row - 1, j);
	// }
	// }
	//
	// // left column
	// for (int i = 0; i < row; i++) {
	// if (board[i][0] == 'O') {
	// bfs(board, i, 0);
	// }
	// }
	//
	// // right column
	// for (int i = 0; i < row; i++) {
	// if (board[i][col - 1] == 'O') {
	// bfs(board, i, col - 1);
	// }
	// }
	//
	// for (int i = 0; i < row; i++) {
	// for (int j = 0; j < col; j++) {
	// if (board[i][j] == 'O') {
	// board[i][j] = 'X';
	// }
	// if (board[i][j] == 'P') {
	// board[i][j] = 'O';
	// }
	// }
	// }
	//
	// }
	//
	// private void fill(char[][] board, int i, int j) {
	// int row = board.length;
	// int col = board[0].length;
	// if (i < 0 || i >= row || j < 0 || j >= col || board[i][j] != 'O')
	// return;
	//
	// queue.offer(i * col + j);
	// board[i][j] = 'P';
	// }
	//
	// private void bfs(char[][] board, int i, int j) {
	// int col = board[0].length;
	//
	// fill(board, i, j);
	//
	// while (!queue.isEmpty()) {
	// int cur = queue.poll();
	// int x = cur / col;
	// int y = cur % col;
	//
	// fill(board, x - 1, y);
	// fill(board, x + 1, y);
	// fill(board, x, y - 1);
	// fill(board, x, y + 1);
	// }
	// }
	// }
}
