package Lecture11;

public class recursicePattern {

	public static void main(String[] args) {
		int N = 4;
		// PP(N, N, 0);
		smartMethod(N, 1, 1);
	}

	public static void PP(int n, int row, int col) {
		if (n == 0) {
			return;
		}
		PP(n - 1, n - 1, 0);
		for (col = 1; col <= row; col++) {
			System.out.print("*\t");

		}
		System.out.println();

	}

	public static void smartMethod(int n, int row, int col) {
		if (row > n) {
			return;
		}
		if (col > row) {
			System.out.println();
			smartMethod(n, row + 1, 1);
			return;
		}
		System.out.print("*\t");
		smartMethod(n, row, col + 1);

	}

}
