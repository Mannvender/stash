package class2;

import java.util.Scanner;

public class PrimeNUM {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("enter number");
		int N = scn.nextInt();

		// if number is prime
		int i = 2;
		while (i < N) {
			if (N % i == 0) {
				System.out.println("number is not prime");
				return;
			}

			i = i + 1;
		}
		System.out.println("number is prime");
	}

}
