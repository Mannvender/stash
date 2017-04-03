package class5;

import java.util.Scanner;

public class asgn1Q10 {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		Q10();

	}

	public static void Q10() {
		// input
		System.out.println("enter number");
		int N = scn.nextInt();
		int row = 1, value = 1, numspace = 2 * N - 3;
		while (row <= N) {
			int col = 1;
			while (col <= row) {

				System.out.print(+value+"\t");
				value++;
				col = col + 1;
				if (row == N&&col==N) {
					value++;
					break;	
				}
			
			}
			col = 1;
			while (col <= numspace) {
				System.out.print(" \t");

				col++;
			}
			numspace = numspace - 2;
			col = 1;
			while (col <= row) {
				System.out.print(+value - 1+"\t");
				value--;
				col++;
			}

			System.out.print("\n");
			row = row + 1;
		}

	}

}
