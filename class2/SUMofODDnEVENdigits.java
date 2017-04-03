package class2;

import java.util.Scanner;

public class SUMofODDnEVENdigits {

	public static void main(String[] args) {
		// input
		Scanner scn = new Scanner(System.in);
		System.out.println("enter a number");
		int N = scn.nextInt();
		// sum of odd n even digits
		int sumeven = 0;
		int sumodd = 0;
		while (N > 0) {
			int rem = N % 10;
			if (rem % 2 != 0)
				sumodd = sumodd + rem;
			else
				sumeven = sumeven + rem;

			N = N / 10;
		}
		System.out.println("sum of odd digits is"+sumodd+"\n and sum of even is"+sumeven);
	}

}
