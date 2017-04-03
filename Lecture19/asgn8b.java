package Lecture19;

import java.lang.reflect.Array;
import java.util.ArrayList;

import Lecture11.string2Number;

public class asgn8b {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(getBoardPAth(10, 7, 0));
		// PrintBoardPaths(0, 10, 7, "");
		// System.out.println(countKnights(2));
		System.out.println(countKnightsBtr(2));
		// PrintNKnights(3);
		// System.out.println(returnKnights(2));
		// **************** fix them ,,to8 complex
		// System.out.println(countLDDRonPrimePaths(4, 0, 4));
		// System.out.println(returnLDDRonPrimePaths(3, 0, 3));
		// ****************
		// int n = 4;
		// int[] ladders = { 0, 0, 13, 11, 0, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0,0 };
		// printLDDRprimePAth(n, 0, returnLadders(returnPrimesSOE(n), 2,
		// returnPrimesSOE(n).length-1), "");
		// int[] sNl = { 0, 0, 13, 0, 0, 7, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0 };
		// int[] dicevalues = { 5, 4, 2, 6, 2 };
		// System.out.println(isSnLPathValid(15, 0, sNl, dicevalues, 0));
		// *************
		// class6.arr1D.display(returnLadders(returnPrimesSOE(15), 2,
		// returnPrimesSOE(15).length - 1));
		// boolean[] bo = returnPrimesSOE(15);
		// for (int i = 0; i < bo.length; i++) {
		// System.out.println(bo[i]);
		// }
		// ******************
		// int n = 3;
		// printChesBrdPAthComplex(n, "", 0, 0, n - 1, n - 1);
		// printChesBrdPAthComplexMines(n, "", 0, 0, n - 1, n - 1, portNmines(n
		// * n, returnPrimesSOE(n * n)));
		// class6.arr1D.display(portNmines(n*n, returnPrimesSOE(n*n)));

	}

	public static ArrayList<String> getBoardPAth(int size, int diceSize, int current) {
		// positive base case
		if (current == size) {
			ArrayList<String> base = new ArrayList<>();
			base.add("");
			return base;
		}
		// negative base case
		if (current > size) {
			ArrayList<String> base = new ArrayList<>();
			return base;
		}

		ArrayList<String> recResult = null, myResult = new ArrayList<>();
		for (int dice = 1; dice <= diceSize; dice++) {
			recResult = getBoardPAth(size, diceSize, current + dice);
			for (int j = 0; j < recResult.size(); j++) {
				myResult.add(dice + recResult.get(j));
			}
		}
		return myResult;
	}

	public static void PrintBoardPaths(int current, int size, int diceSize, String osf) {

		if (current == size) {
			System.out.println(osf);
			return;
		}
		if (current > size) {
			return;
		}
		for (int i = 1; i <= diceSize; i++) {
			PrintBoardPaths(current + i, size, diceSize, i + osf);
		}

	}

	public static int countKnights(int n) {
		boolean[][] board = new boolean[n][n];
		return countKnights(n, board, 0, 0);
	}

	public static int countKnights(int n, boolean[][] board, int row, int col) {
		if (n == 0) {
			return 1;
		}
		int count = 0;
		for (int i = row; i < board.length; i++) {
			for (int j = col; j < board.length; j++) {
				if (isItSafeKnight(board, i, j)) {
					board[i][j] = true;
					int recResult = countKnights(n - 1, board, i, j + 1);
					count = count + recResult;
					board[i][j] = false;
				}
			}
			col = 0;

		}
		return count;
	}

	public static int countKnightsBtr(int n) {
		boolean[][] board = new boolean[n][n];
		return countKnightsBtr(n, board, 0, 0);
	}

	// try something new //fix it
	public static int countKnightsBtr(int n, boolean[][] board, int row, int col) {
		if (n == 0) {
			return 1;
		}
		int count = 0;
		for (int i = row; i < board.length; i++) {

			if (isItSafeKnight(board, i, col)) {
				board[i][col] = true;
				int recResult = countKnightsBtr(n - 1, board, i, col + 1);
				count = count + recResult;
				board[i][col] = false;
			}
			if (col < board.length - 1) {
				col++;
			} else {
				col = 0;
			}

		}
		return count;
	}

	public static boolean isItSafeKnight(boolean[][] board, int testrow, int testcol) {
		int row = testrow, col = testcol;
		if (row - 2 >= 0 && col - 1 >= 0) {
			if (board[testrow - 2][testcol - 1] == true) {
				return false;
			}
		}
		if (row - 2 >= 0 && col + 1 < board.length) {
			if (board[testrow - 2][testcol + 1] == true) {
				return false;
			}
		}
		if (row - 1 >= 0 && col - 2 >= 0) {
			if (board[testrow - 1][testcol - 2] == true) {
				return false;
			}
		}
		if (row - 1 >= 0 && col + 2 < board.length) {
			if (board[testrow - 1][testcol + 2] == true) {
				return false;
			}
		}

		return true;
	}

	public static void PrintNKnights(int n) {
		boolean[][] board = new boolean[n][n];
		PrintNKnights(n, board, 0, 0, "");
	}

	public static void PrintNKnights(int n, boolean[][] board, int row, int col, String osf) {
		if (n == 0) {
			System.out.println(osf + "END");
			return;
		}
		for (int i = row; i < board.length; i++) {
			for (int j = col; j < board.length; j++) {
				if (isItSafeKnight(board, i, j)) {
					board[i][j] = true;
					PrintNKnights(n - 1, board, i, j + 1, osf + "{" + i + "," + j + "}");
					board[i][j] = false;
				}
			}
			col = 0;
		}
		return;
	}

	public static ArrayList<String> returnKnights(int n) {
		boolean[][] board = new boolean[n][n];
		return returnNKnights(n, board, 0, 0);
	}

	public static ArrayList<String> returnNKnights(int n, boolean[][] board, int row, int col) {
		if (n == 0) {
			ArrayList<String> base = new ArrayList<>();
			base.add("\n");
			return base;
		}
		ArrayList<String> MyResult = new ArrayList<>();
		for (int i = row; i < board.length; i++) {
			for (int j = col; j < board.length; j++) {
				if (isItSafeKnight(board, i, j)) {
					board[i][j] = true;

					ArrayList<String> RecResult = returnNKnights(n - 1, board, i, j + 1);
					for (int k = 0; k < RecResult.size(); k++) {
						MyResult.add("{" + i + "," + j + "} " + RecResult.get(k));
					}
					board[i][j] = false;
				}
			}
			col = 0;

		}
		return MyResult;
	}

	public static void printLDDRprimePAth(int size, int current, int[] ladders, String osf) {
		if (current == size) {
			System.out.println(osf);
			return;
		}
		if (current > size) {
			return;
		}
		if (ladders[current] != 0) {
			printLDDRprimePAth(size, ladders[current], ladders, osf + "L");
		} else {
			for (int dice = 1; dice <= 6; dice++) {
				printLDDRprimePAth(size, current + dice, ladders, osf + "D" + dice);
			}
		}
	}

	public static boolean isSnLPathValid(int size, int current, int[] sNl, int[] dicevalues, int si) {
		if (current == size) {
			return true;
		}
		if (current > size) {
			return false;
		}
		if (si == dicevalues.length) {
			return false;
		}
		if (sNl[current] != 0) {
			return isSnLPathValid(size, sNl[current], sNl, dicevalues, si);
		} else {
			return isSnLPathValid(size, current + dicevalues[si], sNl, dicevalues, si + 1);
		}
	}

	public static boolean[] returnPrimesSOE(int N) {
		boolean[] primes = new boolean[N + 1];

		for (int i = 0; i < primes.length; i++) {
			primes[i] = true;
		}

		for (int div = 2; div * div <= N; div++) {
			if (primes[div]) {
				for (int multiple = 2; div * multiple <= N; multiple++) {
					primes[div * multiple] = false;
				}
			}
		}

		return primes;
	}

	// left always start from 2.....as we are saving all primes on their
	// respective places,so for n==15,we start from 0to index 15,we need not
	// start from 0 or 1 so we start from 2 directly
	public static int[] returnLadders(boolean[] primes, int left, int right) {
		int[] lddrs = new int[primes.length];
		while (left < right) {
			while (primes[left] != true) {
				left++;

			}
			while (primes[right] != true) {
				right--;
			}
			lddrs[left] = right;
			left++;
			right--;
		}
		return lddrs;
	}

	public static void printChesBrdPAthComplex(int n, String osf, int cc, int cr, int ec, int er) {
		if (cc == ec && cr == er) {
			System.out.println(osf);
			return;
		}
		if (cc > ec || cr > er) {
			return;
		}

		// for knight
		printChesBrdPAthComplex(n, osf + "HHV", cc + 2, cr + 1, ec, er);
		printChesBrdPAthComplex(n, osf + "VVH", cc + 1, cr + 2, ec, er);
		// for bishop
		if (cc == cr || cr + cc == er) {
			for (int i = 1; cr + i <= er && cc + i <= ec; i++) {
				printChesBrdPAthComplex(n, osf + "B" + i, cc + i, cr + i, ec, er);
			}
		}
		// for rook
		if (cc == 0 || cr == 0 || cr == er || cc == ec) {
			for (int i = 1; cr + i <= er; i++) {
				printChesBrdPAthComplex(n, osf + "RV" + i, cc, cr + i, ec, er);
			}
			for (int i = 1; cc + i <= ec; i++) {
				printChesBrdPAthComplex(n, osf + "RH" + i, cc + i, cr, ec, er);
			}
		}
	}

	public static void printChesBrdPAthComplexMines(int n, String osf, int cc, int cr, int ec, int er,
			int[] portNmines) {
		if (cc == ec && cr == er) {
			System.out.println(osf);
			return;
		}
		if (cc > ec || cr > er) {
			return;
		}
		if (portNmines[cr * (ec + 1) + cc + 1] == 10) {
			return;
		}
		if (portNmines[cr * (ec + 1) + cc + 1] == 8) {
			printChesBrdPAthComplex(n, osf + " PRT ", ec, er, ec, er);
		}
		// for knight
		printChesBrdPAthComplexMines(n, osf + "HHV", cc + 2, cr + 1, ec, er, portNmines);
		printChesBrdPAthComplexMines(n, osf + "VVH", cc + 1, cr + 2, ec, er, portNmines);
		// for bishop
		if (cc == cr || cr + cc == er) {
			for (int i = 1; cr + i <= er && cc + i <= ec; i++) {
				printChesBrdPAthComplexMines(n, osf + "B" + i, cc + i, cr + i, ec, er, portNmines);
			}
		}
		// for rook
		if (cc == 0 || cr == 0 || cr == er || cc == ec) {
			for (int i = 1; cr + i <= er; i++) {
				printChesBrdPAthComplexMines(n, osf + "RV" + i, cc, cr + i, ec, er, portNmines);
			}
			for (int i = 1; cc + i <= ec; i++) {
				printChesBrdPAthComplexMines(n, osf + "RH" + i, cc + i, cr, ec, er, portNmines);
			}
		}
	}

	public static int[] portNmines(int num, boolean[] primes) {
		int[] rv = new int[primes.length];
		for (int i = 2, count = 1; i < primes.length; i++) {
			if (primes[i]) {
				if (count % 2 == 1) {
					rv[i] = 10;
					count++;
				} else {
					rv[i] = 8;
					count++;
				}
			}
		}
		return rv;
	}

}
