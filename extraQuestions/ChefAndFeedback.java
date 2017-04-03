package extraQuestions;

import java.util.Scanner;

public class ChefAndFeedback {

	public static void main(String[] args) {
		// https://www.codechef.com/problems/ERROR
		Scanner scn = new Scanner(System.in);
		int T = scn.nextInt();
		scn.nextLine();
		for (int i = 0; i < T; i++) {
			fun(scn);
		}

	}

	private static void fun(Scanner scn) {
		String s = scn.nextLine();
		for (int i = 0; i < s.length() - 2; i++) {
			if (s.charAt(i) == '0' && s.charAt(i + 1) == '1' && s.charAt(i + 2) == '0') {
				System.out.println("Good");
				return;
			}
			if (s.charAt(i) == '1' && s.charAt(i + 1) == '0' && s.charAt(i + 2) == '1') {
				System.out.println("Good");
				return;
			}
		}
		System.out.println("Bad");

	}

}
