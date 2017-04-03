package Lecture19;

import Lecture11.string2Number;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		String s1 = "sfnriunrfishdjcksj";
		String s2 = "abasurhsjix";
		// Lecture18.CountMazePathBetter.init();
		// System.out.println("solution - " + lcs(s1, s2));
		// System.out.println("lcs took - " +
		// Lecture18.CountMazePathBetter.duration());
		// // ***********
		// Lecture18.CountMazePathBetter.init();
		// System.out.println("solution - " + lcsBetter(s1, s2, new
		// int[s1.length() + 1][s2.length() + 1]));
		// System.out.println("lcsBetter took - " +
		// Lecture18.CountMazePathBetter.duration());
		System.out.println(lcsBetter(s1, s2, new int[s1.length()+1][s2.length()+1]));
		System.out.println("*************");
		System.out.println(lcsIterative(s1, s2));
	}

	public static int lcs(String s1, String s2) {
		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}
		int rv = 0;
		if (s1.charAt(0) == s2.charAt(0)) {
			rv = 1 + lcs(s1.substring(1), s2.substring(1));
		} else {
			int f1 = lcs(s1.substring(1), s2);
			int f2 = lcs(s1, s2.substring(1));
			rv = Math.max(f1, f2);
		}
		return rv;
	}

	public static int lcsBetter(String s1, String s2, int[][] storage) {
		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}
		if (storage[s1.length()][s2.length()] != 0) {
			return storage[s1.length()][s2.length()];
		}
		int rv = 0;
		if (s1.charAt(0) == s2.charAt(0)) {
			rv = 1 + lcsBetter(s1.substring(1), s2.substring(1), storage);
		} else {
			int f1 = lcsBetter(s1.substring(1), s2, storage);
			int f2 = lcsBetter(s1, s2.substring(1), storage);
			rv = Math.max(f1, f2);
		}
		storage[s1.length()][s2.length()] = rv;
		return rv;
	}

	/// done using 2d array
	public static int lcsIterative(String s1, String s2) {
		int[][] arr = new int[s1.length() + 1][s2.length() + 1];
		arr[0][0] = 0;

		for (int j = 1; j <= s2.length(); j++) {
			for (int i = 1; i <= s1.length(); i++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					arr[i][j] = arr[i - 1][j - 1] + 1;
				} else {
					arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
				}
			}
		}
		return arr[s1.length()][s2.length()];
	}
}
