package class5;

import java.util.Scanner;

final class calculator {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		char ch = '\0';
		do {
			int sol = 0;
			System.out.println("enter operation");
			ch = scn.next().charAt(0);
			if (ch == 'x' || ch == 'X') {
				return;
			} else if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '%') {

			} else {
				System.out.println("Invalid operation. Try again.");
				ch = scn.next().charAt(0);
				if (ch == 'x' || ch == 'X') {
					return;
				}
			}
			System.out.println("enter first no.");
			int n1 = scn.nextInt();
			System.out.println("enter 2nd no.");
			int n2 = scn.nextInt();

			if (ch == '+') {
				sol = n1 + n2;
			} else if (ch == '-') {
				sol = n1 - n2;
			} else if (ch == '*') {
				sol = n1 * n2;
			} else if (ch == '/') {
				sol = n1 / n2;
			} else if (ch == '%') {
				sol = n1 % n2;
			} else {
				System.out.println("Invalid operation. Try again.");
			}
			System.out.println(sol);
		} while (true);
	}

}
