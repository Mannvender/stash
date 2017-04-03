package class9;

import java.util.ArrayList;

public class StringsOPS {

	public static void main(String[] args) {
		String s = "abc";
		// printSubstring(s);
		// System.out.println(IsPdrome(s));
		// System.out.println(NumPdrome(s));
		// System.out.println(toogleCase(s));
		// System.out.println(OneMoreNless(s));
		// System.out.println(AddDiff(s));
		// consecutiveDuplicates(s);
		// stringCompression(s);
		permutation(s);
	}

	public static void printSubstring(String s) {

		int j = 0;
		int length = s.length() - 1;
		while (j <= s.length() - 1) {
			for (int i = length + 1; i >= j; i--) {
				System.out.println(s.substring(j, i));
			}

			j++;
		}
	}

	public static int NumPdrome(String s) {
		int j = 0;
		int count = 0;
		int length = s.length() - 1;
		while (j <= s.length() - 1) {
			for (int i = length + 1; i > j; i--) {
				String sub = s.substring(j, i);
				boolean bo = IsPdrome(sub);
				if (bo) {
					count++;
				}
			}

			j++;
		}
		return count;
	}

	public static boolean IsPdrome(String s) {

		boolean bo = true;
		int left = 0;
		int right = s.length() - 1;
		while (left <= right) {

			if (s.charAt(left) == s.charAt(right)) {
				left++;
				right--;
				bo = true;
			} else {
				bo = false;
				break;

			}
		}
		return bo;
	}

	public static String toogleCase(String s) {
		String retVal = "";
		for (int i = 0; i < s.length(); i++) {
			char cc = s.charAt(i);
			if (cc <= 'Z' && cc >= 'A') {
				cc = (char) (cc - 'A' + 'a');
			} else if (cc <= 'z' && cc >= 'a') {
				cc = (char) (cc - 'a' + 'A');
			}
			retVal = retVal + cc;
		}
		return retVal;
	}

	public static String OneMoreNless(String s) {
		String retVal = "";
		for (int i = 0; i < s.length(); i++) {
			char cc = s.charAt(i);
			if (i % 2 == 0) {
				cc = (char) (cc - ('b' - 'a'));
			} else {
				cc = (char) (cc + ('b' - 'a'));
			}
			retVal = retVal + cc;
		}
		return retVal;
	}

	public static String AddDiff(String s) {
		String retVal = "";
		int i = 0;
		for (i = 1; i < s.length(); i++) {
			if (s.length() < 2) {
				System.out.println("not valid");
				break;
			}
			int cc = (s.charAt(i) - s.charAt(i - 1));

			retVal = retVal + s.charAt(i - 1) + cc;
		}
		retVal = retVal + s.charAt(i - 1);
		return retVal;
	}

	public static void consecutiveDuplicates(String s) {
		s = s + "?";

		String retVal = "";

		for (int i = 1; i < s.length(); i++) {
			int cc = s.charAt(i - 1) - s.charAt(i);
			if (cc != 0) {
				retVal = retVal + s.charAt(i - 1);
			}
		}
		System.out.println(retVal);
	}

	public static void stringCompression(String s) {
		// have a look of next line
		s = s + "?";
		int count = 0;
		String retVal = "";
		for (int i = 1; i < s.length(); i++) {
			int cc = s.charAt(i - 1) - s.charAt(i);
			if (cc != 0) {
				retVal = retVal + s.charAt(i - 1);
				if (count != 0) {
					retVal = retVal + (count + 1);
				}
				count = 0;
			} else {
				count++;
			}
		}
		System.out.println(retVal);
	}

	public static void permutation(String s) {

	}

}
