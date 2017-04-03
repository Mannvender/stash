package class5;

import java.util.Scanner;

public class simpleLOG {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("enter number");
		int num = scn.nextInt();
		System.out.println("enter base");
		int base = scn.nextInt();
		LOG(num, base);
	}

	public static void LOG(int num, int base) {
		int power = base;
		int retVal=0;
		while (base <= num) {

			base = base * power;
			retVal++;
		}
		System.out.println(retVal);

	}

}
