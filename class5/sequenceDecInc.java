package class5;

import java.util.Scanner;

public class sequenceDecInc {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		Q();
	}

	public static void Q() {
		System.out.println("How many numbers? ");
		int N = scn.nextInt();

		System.out.println("Enter first number ");
		int prev = scn.nextInt();

		int counter = 2;
		boolean goingDown = true;

		while (counter <= N) {
			System.out.println("Enter " + counter + "th number");
			int current = scn.nextInt();

			// from here
			if (goingDown) {
				if (current > prev) {
					goingDown = false;
				}
			} else {
				if (current < prev) {
					System.out.println("Invalid");
					return;
				}
			}
			// to here

			prev = current;
			counter++;
		}

		System.out.println("Valid");
	}

}
