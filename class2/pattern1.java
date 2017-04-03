package class2;

import java.util.Scanner;

public class pattern1 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("how many rows do you want to see?");
		int n = scn.nextInt();

		// code for pattern
		int row = 1;
		int value = 1;
		while (row <= n) {
			int col = 1;
			while (col <= row) {
				System.out.print(+value);
				value = value + 1;
				col = col + 1;
			}
			System.out.print("\n");
			row = row + 1;
		}
	}

}
