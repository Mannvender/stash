package Lecture12;

public class reverseRecurrPattern {

	public static void main(String[] args) {
		printPattern(4, 1, 1);

		
	}
	public static void printPattern(int n, int row, int col) {
		if (row > n) {
			return;
		}
		if (col > row) {
			printPattern(n, row + 1, 1);
			System.out.println();
			return;
		}
		
		printPattern(n, row, col + 1);
		System.out.print("*\t");

	}

}
