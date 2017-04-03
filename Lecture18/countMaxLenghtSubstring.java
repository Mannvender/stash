package Lecture18;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class countMaxLenghtSubstring {

	public static void main(String[] args) {
		String s1 = "acgdef";
		String s2 = "abcdfe";
		System.out.println(CountCommonMaxLengthSubstrings(s1, s2, s2.length()));

	}

	public static int CountCommonMaxLengthSubstrings(String s1, String s2, int foundAt) {

		if (s1.length() == 0) {
			return 0;
		}

		int maxlenght = 0;
		char cc = s1.charAt(0);
		int RecurResult = CountCommonMaxLengthSubstrings(s1.substring(1), s2, foundAt);

		for (int i = foundAt - 1; i >= 0; i--) {
			if (cc == s2.charAt(i)) {
				maxlenght++;
				foundAt = i;
				break;
			}
		}

		return maxlenght + RecurResult;
	}

}
