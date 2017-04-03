package class3;

import java.util.Scanner;

public class assignQ16 {

	public static void main(String[] args) {
		// input
		Scanner scn = new Scanner(System.in);
		System.out.println("enter number of rows");
		int N = scn.nextInt();
		// code
		int row = 0;
		int value = 1;
		while (row <= N-1) {
			int col = 0;
			while (col <= row) {
				System.out.print(+value+"\t");

				col = col + 1;
				if ((row + 1) == col | col == 0) {
					value = 1;
				} else {
					value = value * (row - (col - 1)) / ((col - 1) + 1);
				}
			}
			System.out.print("\n");
			row = row + 1;
		}
	}

}
