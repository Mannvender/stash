package extraQuestions;

import java.util.ArrayList;

public class FirstNonRepeatedChar {

	public static void main(String[] args) {
		String s = "abcaccbbdebg";
		System.out.println(fun(s, new ArrayList<>()));
	}

	public static char fun(String s, ArrayList<Character> dsf) {
		if (s.length() == 0) {
			return 'x';
		}
		char front = s.charAt(0);
		int foundat = 0;
		int count = 0;
		for (int i = s.length() - 1; i > 0; i--) {
			if (front == s.charAt(i)) {
				count++;
				foundat = i;
				dsf.add(front);
				break;
			}
		}
		if (count == 0) {
			for (int j = 0; j < dsf.size(); j++) {
				if (front == dsf.get(j)) {

					return fun(s.substring(1), dsf);
				}
			}
			System.out.println(dsf);
			return front;
		} else {
			return fun(s.substring(1, foundat) + s.substring(foundat + 1), dsf);
		}
	}

}
