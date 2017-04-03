package Lecture12;

import java.util.ArrayList;

public class subString {

	public static void main(String[] args) {
		String s = "123";
		 System.out.println(getSS(s));
		//printSubSequence(s, "");
	}

	public static ArrayList<String> getSS(String s) {
		if (s.equals("")) {
			ArrayList<String> baseRslt = new ArrayList<>();
			baseRslt.add("");
			return baseRslt;
		}

		char cc = s.charAt(0);
		String small = s.substring(1);
		ArrayList<String> subOfSmall = getSS(small);
		ArrayList<String> AllSubs = new ArrayList<>();
		for (int i = 0; i < subOfSmall.size(); i++) {
			AllSubs.add("" + subOfSmall.get(i));
			AllSubs.add(cc + subOfSmall.get(i));
		}
		return AllSubs;

	}

	// print subsequence
	public static void printSubSequence(String s, String osf) {
		// less complexity
		// osf=output so far

		if (s.length() == 0) {
			System.out.println(osf);
			return;
		}

		char cc = s.charAt(0);
		String ros = s.substring(1);

		printSubSequence(ros, osf + "");
		printSubSequence(ros, osf + cc);
	}
}
