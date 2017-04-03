package extraQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PermutationCycles {
	// https://www.codechef.com/problems/PCYCLE
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		int[] arr = new int[t];
		ArrayList<String> rv = new ArrayList<>();
		HashMap<Integer, Boolean> map = new HashMap<>();
		for (Integer i = 0; i < arr.length; i++) {

			arr[i] = scn.nextInt();
		}
		int counter = 0;

		while (counter != t) {
			Integer i = 0;
			while (map.containsKey(i)) {
				i++;
			}
			// int count = 0;
			String s = "";
			while (true) {
				if (map.containsKey(i)) {
					if (s.equals("")) {

					} else {
						s += i + 1;
						rv.add(s);
					}
					break;
				} else {
					s += i + 1 + " ";
					map.put(i, true);
					counter += 1;
					map.put(i, true);
					i = arr[i] - 1;
				}

			}
		}
		System.out.println(rv.size());
		for (String s : rv) {
			System.out.println(s);
		}

	}

}
