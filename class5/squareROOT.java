package class5;

import java.util.Scanner;

public class squareROOT {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// input

		System.out.println("enter number");
		int N = scn.nextInt();
		System.out.println(sqrroot(N));

	}

	public static int sqrroot(int n) {
		int ans = 0;
		int i = 0;
		while (i <= n) {
			if (n >= i * i) {
				ans = i;

			}
			i = i + 1;
		}
		return ans;
	}

}
