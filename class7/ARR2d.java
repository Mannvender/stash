package class7;

import java.util.Scanner;

public class ARR2d {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// int[][] arr = takeInput();
		int[][] testsub = { { 1, 2, 3, 4 }, { 11, 12, 13, 14 }, { 21, 22, 23, 24 }, };
		display(testsub);
		System.out.println("*****************");
		// wavecolumn(testsub);
		// spiraldisplayAC(testsub);
		// waverow(testsub);
		 spiraldisplayC(testsub);

	}

	public static void spiraldisplayAC(int[][] arr) {
		int mincol = 0;
		int maxcol = arr[0].length - 1;
		int minrow = 0;
		int maxrow = arr.length - 1;
		int count = 0;
		int countmax = arr.length * arr[0].length;
		System.out.println("spiral anticlockwise ");
		while (count < countmax) {

			for (int row = minrow; count < countmax && row <= maxrow; row++) {
				System.out.print(arr[row][mincol] + ",");
				count++;
			}
			mincol++;

			for (int col = mincol; count < countmax && col <= maxcol; col++) {
				System.out.print(arr[maxrow][col] + ",");
				count++;
			}
			maxrow--;

			for (int row = maxrow; count < countmax && row >= minrow; row--) {
				System.out.print(arr[row][maxcol] + ",");
				count++;
			}
			maxcol--;

			for (int col = maxcol; count < countmax && col >= mincol; col--) {
				System.out.print(arr[minrow][col] + ",");
				count++;
			}
			minrow++;

		}
	}

	public static void spiraldisplayC(int[][] arr) {
		int mincol = 0;
		int maxcol = arr[0].length - 1;
		int minrow = 0;
		int maxrow = arr.length - 1;
		int count = 0;
		int countmax = arr.length * arr[0].length;
		System.out.println("spiral clockwise ");
		while (count < countmax) {
			for (int col = mincol; count < countmax && col <= maxcol; col++) {
				System.out.print(arr[minrow][col] + ",");
				count++;
			}
			minrow++;

			for (int row = minrow; count < countmax && row <= maxrow; row++) {
				System.out.print(arr[row][maxcol] + ",");
				count++;
			}
			maxcol--;

			for (int col = maxcol; count < countmax && col >= mincol; col--) {
				System.out.print(arr[maxrow][col] + ",");
				count++;
			}
			maxrow--;

			for (int row = maxrow; count < countmax && row >= minrow; row--) {
				System.out.print(arr[row][mincol] + ",");
				count++;
			}
			mincol++;

		}
	}

	public static void wavecolumn(int[][] arr) {
		System.out.println("waveDISPLAYcolumnwise");
		for (int col = 0; col < arr[0].length; col++) {
			if (col % 2 == 0) {
				for (int row = 0; row < arr.length; row++) {
					System.out.print(+arr[row][col] + ",");
				}
			} else {
				for (int row = arr.length - 1; row >= 0; row--) {
					System.out.print(+arr[row][col] + ",");
				}

			}
		}
	}

	public static void waverow(int[][] arr) {
		System.out.println("waveDISPLAYrowwise");
		for (int row = 0; row < arr.length; row++) {
			if (row % 2 == 0) {
				for (int col = 0; col < arr[0].length; col++) {
					System.out.print(+arr[row][col] + ",");
				}
			} else {
				for (int col = arr[0].length - 1; col >= 0; col--) {
					System.out.print(+arr[row][col] + ",");
				}

			}
		}
	}

	public static void display(int[][] arr) {
		if (arr == null) {
			System.out.println("no rows ,no cols");

		} else {
			System.out.println("rows = " + arr.length);

			for (int row = 0; row < arr.length; row++) {
				if (arr[row] == null || arr[row].length == 0) {
					System.out.println("blank row");
				} else {
					for (int col = 0; col < arr[row].length; col++) {
						System.out.print(arr[row][col] + "\t");
					}
					System.out.println();
				}
			}
		}

	}

	public static int[][] takeInput() {
		int[][] retval = null;
		System.out.println("enter number of rows");
		int rows = scn.nextInt();

		retval = new int[rows][];
		for (int row = 0; row < retval.length; row++) {
			System.out.println("enter the number of coloumns for " + row + "th row");
			int cols = scn.nextInt();

			retval[row] = new int[cols];

			for (int col = 0; col < retval[row].length; col++) {
				System.out.println("enter the valur for cell (" + row + "," + col + ")");
				retval[row][col] = scn.nextInt();
			}
		}
		return retval;
	}

}
