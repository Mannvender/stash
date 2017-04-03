package extraQuestions;

import java.util.Scanner;

public class CamelCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String s = scn.nextLine();
		int rv = 1;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) <= 'Z' && s.charAt(i) >= 'A') {
				rv++;
			}

		}
		System.out.println(rv);

	}

}
