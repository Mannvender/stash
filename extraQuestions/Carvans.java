package extraQuestions;

import java.util.Scanner;

import Lecture31.Cars;

public class Carvans {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int T = scn.nextInt();
		for (int i = 0; i < T; i++) {
			int N = scn.nextInt();
			if (N == 1) {
				int firstCarS = scn.nextInt();
				System.out.println("1");
			} else {
				int[] arr = new int[N];
				int firstCarS = scn.nextInt();
				int count = 1;
				for (int j = 0; j < arr.length; j++) {
					arr[j] = firstCarS;
				}
				for (int j = 1; j < arr.length; j++) {
					int CarS = scn.nextInt();
					if (CarS > arr[j - 1]) {
						arr[j] = arr[j - 1];
					} else {
						arr[j] = CarS;
						count++;
					}
				}
				System.out.println(count);
			}

		}
	}

}
