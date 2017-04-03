package Lecture14;

import java.util.ArrayList;

public class boardQueens {

	public static void main(String[] args) {
		 System.out.println(countqueens(4));
		// PrintNqueens(4);
		//System.out.println(ReturnNqueens(4));
	}

	public static int countqueens(int n) {
		boolean[][] board = new boolean[n][n];
		return countQueens(board, 0);
	}

	public static int countQueens(boolean[][] board, int row) {
		if (row == board.length) {
			return 1;
		}
		int count = 0;
		for (int col = 0; col < board[row].length; col++) {
			if (isItSafe(board, row, col)) {
				board[row][col] = true;
				int recurResult = countQueens(board, row + 1);
				count = count + recurResult;
				board[row][col] = false;
			}
		}
		return count;
	}

	public static boolean isItSafe(boolean[][] board, int testrow, int testcol) {
		for (int row = testrow, col = testcol; row >= 0; row--) {
			if (board[row][col] == true) {
				return false;
			}
		}

		for (int row = testrow, col = testcol; row >= 0 && col >= 0; row--, col--) {
			if (board[row][col] == true) {
				return false;
			}
		}
		for (int row = testrow, col = testcol; row >= 0 && col < board.length; row--, col++) {
			if (board[row][col] == true) {
				return false;
			}
		}
		return true;
	}

	public static void PrintNqueens(int n) {
		boolean[][] board = new boolean[n][n];
		PrintNQueens(board, 0, "");
	}

	public static void PrintNQueens(boolean[][] board, int row, String osf) {
		if (row == board.length) {
			System.out.println(osf + "END");
			return;
		}

		for (int col = 0; col < board[row].length; col++) {
			if (isItSafe(board, row, col)) {
				board[row][col] = true;
				PrintNQueens(board, row + 1, osf + "{" + row + "-" + col + "} ,");
				board[row][col] = false;

			}
		}
		return;
	}

	public static ArrayList<String> ReturnNqueens(int n) {
		boolean[][] board = new boolean[n][n];
		return ReturnNQueens(board, 0);
	}

	public static ArrayList<String> ReturnNQueens(boolean[][] board, int row) {
		if (row == board.length) {
			ArrayList<String> base = new ArrayList<>();
			base.add("\n");
			return base;
		}

		ArrayList<String> MyResult = new ArrayList<>();
		for (int col = 0; col < board[row].length; col++) {
			if (isItSafe(board, row, col)) {
				board[row][col] = true;

				ArrayList<String> RecurResult = ReturnNQueens(board, row + 1);
				for (int i = 0; i < RecurResult.size(); i++) {
					MyResult.add("{" + row + "," + col + "} ;" + RecurResult.get(i));
				}

				board[row][col] = false;

			}
		}
		return MyResult;
	}

}
