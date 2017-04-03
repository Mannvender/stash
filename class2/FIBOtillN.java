package class2;

import java.util.Scanner;

public class FIBOtillN {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		// taking input
		System.out.println("enter number");
		int N = scn.nextInt();
		// printing fibo series
		System.out.println("0");
		int present = 1;
		int last = 0;
		while (present <= N) {
			System.out.println(+present);
			present = present + last;
			last = present - last;
		}
	}

}
