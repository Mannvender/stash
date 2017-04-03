package extraQuestions;

import java.util.Arrays;
import java.util.Scanner;

public class LittleElephantPermutations {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int T = scn.nextInt();
		for (int i = 0; i < T; i++) {
			fun(scn);
		}
	}

	private static void fun(Scanner scn) {
		int N = scn.nextInt();

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			int temp = scn.nextInt();
			arr[i] = temp;
		}
		if (N == 1) {
			System.out.println("YES");
			return;
		}
		int local = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				local++;
			}
		}
		int total = 0;
		// Arrays.sort(arr);
		for (int i = 0; i < arr.length - 1; i++) {
			if (total > local) {
				System.out.println("NO");
				return;
			}
			for (int j = i + 1; j < arr.length; j++) {
				if (total > local) {
					System.out.println("NO");
					return;
				}
				if (arr[j] < arr[i]) {
					total++;
				}
			}

		}
		if (total == local) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}

}
