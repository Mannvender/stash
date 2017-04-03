package class5;

import java.util.Scanner;

public class asgn2 {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		Q13();
		 //Q11();
	}

	public static void Q11() {
		int count = 0, n = 1;
		System.out.println("enter number of terms");
		int num=scn.nextInt();
		System.out.println("enter numbe you dont want to see the multiples of");
		int noentry=scn.nextInt();
		while (count < num) {
			if ((3 * n + 2) % noentry != 0) {
				System.out.println(3 * n + 2);
				count++;
			}
			n++;
		}
	}

	public static void Q13() {
		// input
		System.out.println("enter number");
		double N = scn.nextInt();
		System.out.println("enter precision");
		double P = scn.nextInt();

		// code
		double sqroot = 0.0;
		int iprsnhelper = 1;
		double dprsnhelper = 1.0;
		while (sqroot * sqroot <= N) {
			sqroot++;
		}
		sqroot--;
		// precision
		double prsn = 1, mtenpwr = 0.1;
		while (prsn <= P) {
			while (sqroot * sqroot <= N) {
				sqroot = sqroot + mtenpwr;

			}

			sqroot = sqroot - mtenpwr;
			mtenpwr = mtenpwr / 10;
			iprsnhelper = iprsnhelper * 10;
			dprsnhelper = dprsnhelper * 10;
			prsn++;

		}
		System.out.println(sqroot + ", " + (Math.round(sqroot * iprsnhelper) / dprsnhelper));
	}

}
