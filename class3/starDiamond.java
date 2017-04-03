package class3;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class starDiamond {

	public static void main(String[] args) {
		// input
		Scanner scn = new Scanner(System.in);
		System.out.println("enter number of rows");
		int N = scn.nextInt();

		// code
		int row = 1;
		int col = 1;
		int numstar = 1;
		int numspace = N / 2;

		while (row <= N) {

			// spaces
			col = 1;
			while (col <= numspace) {
				System.out.print(" \t");
				col = col + 1;
			}
			// stars
			col = 1;
			while (col <= numstar) {
				System.out.print("*\t");
				col = col + 1;

			}

			if (row < N / 2 + 1) {
				numspace = numspace - 1;
				numstar = numstar + 2;
			} else {
				numspace = numspace + 1;
				numstar = numstar - 2;
			}
			row++;
			System.out.print("\n");
			//
		}
	}

}
