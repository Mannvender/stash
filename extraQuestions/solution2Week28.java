package extraQuestions;

import java.util.Scanner;

public class solution2Week28 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();
		long[] arr = new long[num];
		for (int i = 0; i < num; i++) {
			long t = scn.nextLong();
			arr[i] = t;
		}

		for (int j = 0; j < arr.length; j++) {
			int rv = 0;
			for (int i = 1; i < arr[j]; i++) {
				long temp = arr[j];
				if ((i ^ temp) > temp) {
					rv++;
				}

			}
			System.out.println(rv);
		}

	}

}
