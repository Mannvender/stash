package Lecture12;

import java.util.ArrayList;

public class permutations {

	public static void main(String[] args) {
		String s = "aac";
		// System.out.println(getPM(s));
		// Smarter(s, "");
		withDupli(s, "");

	}

	public static ArrayList<String> getPM(String s) {
		if (s.equals("")) {
			ArrayList<String> baseRslt = new ArrayList<>();
			baseRslt.add("");
			return baseRslt;
		}

		char cc = s.charAt(0);
		String smaller = s.substring(1);
		ArrayList<String> recResult = getPM(smaller);
		ArrayList<String> myResult = new ArrayList<>();
		for (int i = 0; i < recResult.size(); i++) {
			String get = recResult.get(i);
			for (int j = 0; j <= get.length(); j++) {

				String myget = get.substring(0, j) + cc + get.substring(j);
				myResult.add(myget);
			}
		}

		return myResult;

	}

	public static void Smarter(String s, String osf) {
		if (s.length() == 0) {
			System.out.println(osf);
			return;
		}

		for (int i = 0; i < s.length(); i++) {
			char cc = s.charAt(i);
			String ros = s.substring(0, i) + s.substring(i + 1);
			Smarter(ros, osf + cc);

		}

	}

	public static void withDupli(String s, String osf) {

		if (s.length() == 0) {
			System.out.println(osf);
			return;
		}
		boolean[] check = new boolean[26];
		for (int i = 0; i < s.length(); i++) {
			char cc = s.charAt(i);
			if (check[cc - 'a'] == false) {
				String ros = s.substring(0, i) + s.substring(i + 1);
				withDupli(ros, osf + cc);
				check[cc - 'a'] = true;
			}

		}

	}
}
