package Lecture19;

public class editDistnc {

	public static void main(String[] args) {
		String s1 = "reiuhsjnc";
		String s2 = "eirhfjfneoi";
		Lecture18.CountMazePathBetter.init();
		System.out.println(badcode(s1, s2));
		System.out.println("badcode took - " + Lecture18.CountMazePathBetter.duration());
		// *************
		Lecture18.CountMazePathBetter.init();
		System.out.println(goodcode(s1, s2, new int[s1.length() + 1][s2.length() + 1]));
		System.out.println("goodcode took - " + Lecture18.CountMazePathBetter.duration());

		System.out.println("************");
		System.out.println(Iterative(s1, s2));
	}

	public static int badcode(String s1, String s2) {
		if (s1.length() == 0) {
			return s2.length();
		}
		if (s2.length() == 0) {
			return s1.length();
		}
		int rv = 0;
		if (s1.charAt(0) == s2.charAt(0)) {
			rv = badcode(s1.substring(1), s2.substring(1));
		} else {
			int swap = 1 + badcode(s1.substring(1), s2.substring(1));
			int add = 1 + badcode(s1.substring(1), s2);
			int delete = 1 + badcode(s1, s2.substring(1));
			rv = Math.min(swap, Math.min(add, delete));

		}
		return rv;

	}

	public static int goodcode(String s1, String s2, int[][] storage) {
		if (s1.length() == 0) {
			return s2.length();
		}
		if (s2.length() == 0) {
			return s1.length();
		}
		if (storage[s1.length()][s2.length()] != 0) {
			return storage[s1.length()][s2.length()];
		}
		int rv = 0;
		if (s1.charAt(0) == s2.charAt(0)) {
			rv = goodcode(s1.substring(1), s2.substring(1), storage);
		} else {
			int swap = 1 + goodcode(s1.substring(1), s2.substring(1), storage);
			int add = 1 + goodcode(s1.substring(1), s2, storage);
			int delete = 1 + goodcode(s1, s2.substring(1), storage);
			rv = Math.min(swap, Math.min(add, delete));

		}
		storage[s1.length()][s2.length()] = rv;
		return rv;

	}

	public static int Iterative(String s1, String s2) {
		int[][] arr = new int[s1.length() + 1][s2.length() + 1];
		int ls1 = s1.length();
		int ls2 = s2.length();
		for (int i = 1; i <= ls2; i++) {
			arr[0][i] = s2.length();
		}
		for (int j = 1; j <= ls1; j++) {
			arr[j][0] = s1.length();
		}

		for (int j = 1; j <= s2.length(); j++) {
			for (int i = 1; i <= s1.length(); i++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					arr[i][j] = arr[i - 1][j - 1];
				} else {
					arr[i][j] = Math.min(1 + arr[i - 1][j - 1], Math.min(1+arr[i][j - 1], 1+arr[i - 1][j]));
				}
			}
		}
		class7.ARR2d.display(arr);
		return arr[s1.length()][s2.length()];
	}
}
