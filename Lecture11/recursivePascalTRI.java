package Lecture11;

import java.util.Scanner;

public class recursivePascalTRI {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		System.out.println("ENTER NUMBER OF ROWS");
		int N=scn.nextInt();
		PPtriangle(N, N - 1, 0);
	}

	public static void PPtriangle(int n, int row, int col) {
		if (n == 0) {
			return;
		}
		PPtriangle(n - 1, row - 1, 0);
		col = 0;
		int value = 1;
		while (col <= row) {
			if (col == row || col == 0) {
				value = 1;
			} else {
				value = value * (row - (col - 1)) / ((col - 1) + 1);
			}
			System.out.print(value + "\t");
			col++;
		}
		System.out.println();
	}

}
