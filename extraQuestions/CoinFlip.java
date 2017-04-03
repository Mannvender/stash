package extraQuestions;

import java.util.Scanner;

public class CoinFlip {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int T = scn.nextInt();

		for (int i = 0; i < T; i++) {
			int G = scn.nextInt();
			for (int j = 0; j < G; j++) {
				int I = scn.nextInt(), N = scn.nextInt(), Q = scn.nextInt();
				codeShefSolution(I, N, Q);
			}

		}

	}

	private static void badCode(int i, int n, int q) {

		if (i == 1) {
			int numH = 0;
			int numT = 0;
			for (int k = 1; k <= n; k++) {
				if (k % 2 == 1) {
					numT++;
				} else {
					numH++;
				}
			}
			if (q == 1) {
				System.out.println(numH);
			} else {
				System.out.println(numT);
			}
		} else {
			int numH = 0;
			int numT = 0;
			for (int k = 1; k <= n; k++) {
				if (k % 2 == 1) {
					numH++;
				} else {
					numT++;
				}
			}
			if (q == 1) {
				System.out.println(numH);
			} else {
				System.out.println(numT);
			}

		}
	}

	private static void codeShefSolution(int I, int N, int Q) {
		if (N % 2 == 0 || I == Q)
			System.out.println(N / 2);
		else
			System.out.println(N / 2 + 1);
	}
}
