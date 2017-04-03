package extraQuestions;

import java.util.HashMap;
import java.util.Scanner;

public class JewelsandStones {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int T = scn.nextInt();
		scn.nextLine();
		for (int i = 0; i < T; i++) {

			System.out.println(fun(scn));
		}
	}

	private static int fun(Scanner scn) {
		String J = scn.nextLine();
		String S = scn.nextLine();
		HashMap<Character, Integer> charMap = new HashMap<>();
		for (int i = 0; i < J.length(); i++) {
			if (charMap.containsKey(J.charAt(i))) {
				int ov = charMap.get(J.charAt(i));
				charMap.put(J.charAt(i), ov + 1);
			} else {
				charMap.put(J.charAt(i), 1);

			}

		}
		int rv = 0;
		for (int i = 0; i < S.length(); i++) {
			if (charMap.containsKey(S.charAt(i))) {
				rv = rv + 1;
			}
		}

		return rv;
	}

}
