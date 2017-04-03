package class2;

import java.util.Scanner;

public class pattern2 {

	public static void main(String[] args) {
		// input
		Scanner scn = new Scanner(System.in);
		System.out.println("how many rows do you want to see?");
		int n = scn.nextInt();
		// pattern code
		int row = 1;
		while (row <= n) {
			// spaces
			int col = 1;
			while (col <= n - row) {
				System.out.print(" ");
				col = col + 1;
			}
			// inc numbers
			int value = row;
			col = 1;
			while (col <= row) {
				System.out.print(+value);
				value = value + 1;
				col = col + 1;

			}
			// dec numbers
			value = value - 2;
			col = 1;
			while (col <= row - 1) {
				System.out.print(+value);
				value = value - 1;
				col = col + 1;

			}
			System.out.print("\n");
			row = row + 1;

		}
	}

}
