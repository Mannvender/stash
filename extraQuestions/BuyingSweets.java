package extraQuestions;

import java.util.Scanner;

public class BuyingSweets {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int T = scn.nextInt();
		for (int i = 0; i < T; i++) {

			System.out.println(fun(scn));
		}
	}

	private static int fun(Scanner scn) {
		int N = scn.nextInt();
		int X = scn.nextInt();
		int[] notes = new int[N];
		int sum = 0;
		for (int i = 0; i < notes.length; i++) {
			int temp = scn.nextInt();
			sum += temp;
			notes[i] = temp;
		}
		int rv = sum / X;
		for (int i = 0; i < notes.length; i++) {
			int newSum = sum - notes[i];

			if (newSum / X == rv) {
				return -1;
			}
		}
		return rv;
	}

}
