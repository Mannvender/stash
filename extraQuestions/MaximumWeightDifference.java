package extraQuestions;

import java.util.Scanner;

public class MaximumWeightDifference {
	// https://www.codechef.com/problems/MAXDIFF
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int T = scn.nextInt();
		for (int i = 0; i < T; i++) {

			System.out.println(fun(scn));
		}
	}

	private static int fun(Scanner scn) {
		int n = scn.nextInt();
		int k = scn.nextInt();
		int totalSum = 0;

		int[] weights = new int[n];
		for (int i = 0; i < n; i++) {
			int temp = scn.nextInt();
			totalSum = totalSum + temp;
			weights[i] = temp;
		}
		java.util.Arrays.sort(weights);
		int small = 0;
		for (int i = 0; i < k; i++) {
			small = small + weights[i];
		}
		int big = 0;
		for (int i = n - 1; i > n - k - 1; i--) {
			big = big + weights[i];
		}
		int rv = Math.max(Math.abs(small - (totalSum - small)), Math.abs(big - (totalSum - big)));
		return rv;
	}

}
