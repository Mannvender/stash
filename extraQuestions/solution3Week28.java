package extraQuestions;

import java.util.ArrayList;
import java.util.Scanner;

public class solution3Week28 {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int numdigit = scn.nextInt();
		scn.nextLine();
		// System.out.println("***");
		String s = scn.nextLine();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			sb.append(s.charAt(i));
		}
		// System.out.println(sb);
		ArrayList<String> list = new ArrayList<>();

		list = getSS(s);
		list.remove(0);
		System.out.println(list);

		int rv = 0;
		for (int i = 0; i < list.size(); i++) {
			int temp = s2n(list.get(i));
			if (temp % 8 == 0) {
				rv++;
			}
		}
		System.out.println((int) (rv % (Math.pow(10, 9) + 7)));

	}

	public static int s2n(String s) {
		// if (s.length() == 0) {
		// return 0;
		// }
		// int lastnum = s.charAt(s.length() - 1) - '0';
		//
		// int retVal = s2n(s.substring(0, s.length() - 1));
		//
		// retVal = retVal * 10 + (lastnum);
		// return retVal;
		int num = 0;
		for (int i = 0; i < s.length(); i++) {
			num = num + s.charAt(i) - '0';
			if (i == s.length() - 1) {

			} else {
				num = num * 10;
			}

		}
		return num;
	}

	public static ArrayList<StringBuilder> getSS(StringBuilder s) {
		if (s.equals("")) {
			ArrayList<StringBuilder> baseRslt = new ArrayList<>();
			StringBuilder base = new StringBuilder("");
			baseRslt.add(base);
			return baseRslt;
		}

		char cc = s.charAt(0);
		StringBuilder small = s.substring(1);
		ArrayList<StringBuilder> subOfSmall = getSS(small);
		ArrayList<StringBuilder> AllSubs = new ArrayList<>();
		for (int i = 0; i < subOfSmall.size(); i++) {
			AllSubs.add("" + subOfSmall.get(i));
			AllSubs.add(cc + subOfSmall.get(i));
		}
		return AllSubs;

	}

}
