package extraQuestions;

import java.util.Scanner;

public class solution {
	// public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] hts = takeinput(26);
		// scn.nextLine();
		Scanner scn2 = new Scanner(System.in);
		String word = scn2.nextLine();
		int width = word.length();
		int ht = -1;
		for (int i = 0; i < word.length(); i++) {
			if (GiveHt(word.charAt(i), hts) > ht) {
				ht = GiveHt(word.charAt(i), hts);
			}
		}
		System.out.println(width * ht);

	}

	public static int[] takeinput(int size) {
		int[] retval = null;
		// System.out.println("enter the size");
		int N = size;
		retval = new int[N];
		Scanner scn = new Scanner(System.in);
		for (int i = 0; i < retval.length; i++) {
			// System.out.println("enter" + i + "th element:");
			int data = scn.nextInt();
			retval[i] = data;
		}
		return retval;
	}

	public static int GiveHt(char cc, int[] hts) {
		int ai = cc - 'a';
		int rv = hts[ai];
		return rv;
	}

}