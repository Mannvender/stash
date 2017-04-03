package class2;

import java.util.Scanner;

public class Pattern3 {

	public static void main(String[] args) {
		// input
		Scanner scn = new Scanner(System.in);
		System.out.println("type value of n");
		int n = scn.nextInt();

		// code
		int numspace = (n-1);
		int value = 1;
		int numdec = 0;
		int numinc = 1;
		int row = 1;
		int col = 1;
		while (row <= 2 * n - 1) {
			// spaces
			col = 1;
			while (col <= numspace) {
				System.out.print("\t");
				col = col + 1;

			}
			// inc num
			col = 1;
			while (col <= numinc) {
				System.out.print(+value+"\t");
				value = value + 1;
				col = col + 1;
			}
			// dec num
			col = 1;

			while (col <= numdec) {
				int z = value - 2;
				System.out.print(+z+"\t");
				value = value - 1;
				col = col + 1;

			}
			System.out.print("\n");

			if (row < n) {
				numspace = numspace - 1;
				numinc = numinc + 1;
				numdec = numdec + 1;
			}

			else {
				numinc = numinc - 1;
				numdec = numdec - 1;
				numspace = numspace + 1;
				value = value - 2;
			}
			row = row + 1;

		}
	}

}
