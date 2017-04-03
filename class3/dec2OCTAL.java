package class3;

import java.util.Scanner;

public class dec2OCTAL {

	public static void main(String[] args) {
		// input
		Scanner scn = new Scanner(System.in);

		System.out.println("enter in dec");

		int dec = scn.nextInt();
		int oct = 0;
		int tenpower = 1;
		while (dec != 0) {
			int rem = dec % 8;
			oct = oct + rem * tenpower;
			tenpower = tenpower * 10;
			// debug
			dec = dec / 8;
		}
		System.out.println(+oct);

	}

}
