package class5;

import java.util.Scanner;

public class octal2bin {

	public static void main(String[] args) {
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

		// 2nd part
		int bin = 0;
		int tenpower = 1;

		while (dec != 0) {
			int rem = dec % 2;
			bin = bin + rem * tenpower;
			tenpower = tenpower * 10;
			dec = dec / 2;
		}
		System.out.println("number in bin is" + bin);
	}

}
