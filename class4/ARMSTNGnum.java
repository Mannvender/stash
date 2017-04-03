package class4;

import java.util.Scanner;

public class ARMSTNGnum {

	public static void main(String[] args) {
		// input
		Scanner scn = new Scanner(System.in);
		System.out.println("enter number greator than zero");
		int N = scn.nextInt();
		int count = 0;
		int reset = N;
		int armnum;
		int save = 0;

		// term count
		while (N != 0) {
			count = count + 1;
			N = N / 10;
		}
		N = reset;
		// code
		while (N != 0) {
			int rem = N % 10;
			int i = 1;
			armnum = 1;
			while (i <= count) {
				armnum = armnum * rem;
				i = i + 1;
			}
			save = save + armnum;
			N = N / 10;
		}
		if (save == reset) {
			System.out.println("yes num is armstrong num");
		} else {
			System.out.println("no the num is not armstrong num");
		}

	}

}
