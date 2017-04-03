package class2;

import java.util.Scanner;

public class fiboNth {

	public static void main(String[] args) {
		// input
		Scanner scn = new Scanner(System.in);

		System.out.println("enter number of term in fibonnachi series\n");
		int N = scn.nextInt();
		if(N<0|N>1000){
			return;
		}
		int count = 1;
		int present = 1;
		int last = 0;
		if (N == 1) {
			System.out.println("1");
		} else {
			while (count <= N) {

				present = present + last;
				last = present - last;
				count = count + 1;
			}
			System.out.println(+N + "fibonnachi term is" + last);

		}
	}
}
