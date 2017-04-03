package extraQuestions;

import java.util.Scanner;

public class solution1Week28 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		boolean bo = func(n, scn);
		if (bo) {
			System.out.println("Yes");

		} else {
			System.out.println("No");
		}

	}

	public static boolean func(int num, Scanner scn) {
		int[] arr = new int[num];
		int numBoats = scn.nextInt();
		int bcapacity = scn.nextInt();
		int maxperRound = numBoats * bcapacity;

		for (int i = 0; i < num; i++) {
			arr[i] = scn.nextInt();
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > maxperRound) {
				return false;
			}
		}
		return true;

	}

}
