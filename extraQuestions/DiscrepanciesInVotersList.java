package extraQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

// NLOG(N) complexity
// look for better complexity
public class DiscrepanciesInVotersList {
	// https://www.codechef.com/problems/VOTERS

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int[] arr = new int[3];

		arr[0] = scn.nextInt();
		arr[1] = scn.nextInt();
		arr[2] = scn.nextInt();

		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < 3; i++) {
			int n = arr[i];
			fun(n, map, scn);
		}
		ArrayList<Integer> rv = new ArrayList<>();
		Set<Integer> ids = map.keySet();
		for (Integer id : ids) {
			if (map.get(id) >= 2) {
				rv.add(id);
			}
		}
		Collections.sort(rv);
		System.out.println(rv.size());
		for (int i = 0; i < rv.size(); i++) {
			System.out.println(rv.get(i));
		}

	}

	public static void fun(int n, HashMap<Integer, Integer> map, Scanner scn) {
		for (int i = 0; i < n; i++) {
			int temp = scn.nextInt();
			if (!map.containsKey(temp)) {
				map.put(temp, 1);
			} else {
				int ov = map.get(temp);
				map.put(temp, ov + 1);

			}
		}
	}

}
