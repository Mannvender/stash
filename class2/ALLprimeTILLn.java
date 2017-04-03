package class2;

import java.util.Scanner;

public class ALLprimeTILLn {

	public static void main(String[] args) {
		// input
		Scanner scn = new Scanner(System.in);
		System.out.println("enter a number greator than 2");
		int N = scn.nextInt();
		if (N < 0 | N > 1000) {
			return;
		}
		// prime printing
		int count = 2;

		while (count <= N) {
			int i = 2;
			int check = 0;
			while (i < count) {
				if (count % i == 0) {
					check = check + 1;
					break;
				}
				i = i + 1;

			}
			if (check == 0) {
				System.out.println(+count);

			}
			count = count + 1;
		}
	}

}
