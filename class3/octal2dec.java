package class3;

import java.util.Scanner;

public class octal2dec {

	public static void main(String[] args) {
		// input
		Scanner scn = new Scanner(System.in);

		System.out.println("enter in octal");

		int oct = scn.nextInt();
		int dec = 0;
		int octpower = 1;
		while (oct != 0) {
			int rem = oct % 10;
			dec = dec + rem * octpower;
			octpower = octpower * 8;
			// debug
			oct = oct / 10;
		}
		System.out.println(+dec);

	}
}
