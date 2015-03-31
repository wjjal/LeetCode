import java.util.ArrayList;

//Write a program to solve a Sudoku puzzle by filling the empty cells.
//
//Empty cells are indicated by the character '.'.
//
//You may assume that there will be only one unique solution.

public class L037SudokuSolver {
	public class Solution {
		public void solveSudoku(char[][] board) {
			ArrayList<Integer> array = getArrayList(board);
			DFS(board, array, 0);
		}

		public ArrayList<Integer> getArrayList(char[][] board) {
			ArrayList<Integer> array = new ArrayList<Integer>();
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if (board[i][j] == '.') {
						array.add(i * 9 + j);
					}
				}
			}
			return array;
		}

		public boolean DFS(char[][] board, ArrayList<Integer> array, int index) {
			int len = array.size();
			if (index == len)
				return true;
			int data = array.get(index);
			int row = data / 9;
			int column = data % 9;
			for (int i = 1; i <= 9; i++) {
				if (isValid(board, row, column, i)) {
					board[row][column] = (char) (i + '0');
					if (DFS(board, array, index + 1))
						return true;
					board[row][column] = '.';
				}
			}
			return false;
		}

		public boolean isValid(char[][] board, int row, int column, int data) {
			for (int i = 0; i < 9; i++) {
				if (board[row][i] - '0' == data)
					return false;
				if (board[i][column] - '0' == data)
					return false;
				int currow = row / 3 * 3 + i / 3;
				int curcol = column / 3 * 3 + i % 3;
				if (board[currow][curcol] - '0' == data)
					return false;
			}
			return true;
		}
	}
}
