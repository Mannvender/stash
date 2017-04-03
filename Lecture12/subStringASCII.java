package Lecture12;

import java.util.ArrayList;

public class subStringASCII {

	public static void main(String[] args) {
		String s = "ab";
		System.out.println(getSSascii(s));
		System.out.println("*******");
		printSubWithASCII(s, "");

	}

	public static ArrayList<String> getSSascii(String s) {
		if (s.equals("")) {
			ArrayList<String> baseRslt = new ArrayList<>();
			baseRslt.add("");
			return baseRslt;
		}

		char cc = s.charAt(0);
		int ascii = cc;
		String small = s.substring(1);
		ArrayList<String> subOfSmall = getSSascii(small);
		ArrayList<String> AllSubs = new ArrayList<>();
		for (int i = 0; i < subOfSmall.size(); i++) {
			AllSubs.add("" + subOfSmall.get(i));// when first element is not
												// part of the solution
			AllSubs.add(cc + subOfSmall.get(i));// when first element is part of
												// the solution
			AllSubs.add(ascii + subOfSmall.get(i));// when its ASCII is part of
													// the solution
		}
		return AllSubs;

	}

	public static void printSubWithASCII(String s, String osf) {
		if (s.length() == 0) {
			System.out.println(osf + ",");
			return;
		}

		char cc = s.charAt(0);
		int asci = cc;
		String ros = s.substring(1);
		printSubWithASCII(ros, osf + "");
		printSubWithASCII(ros, osf + cc);
		printSubWithASCII(ros, osf + asci);
	}
}
