package extraQuestions;

import java.util.HashMap;
import java.util.Scanner;

public class CleaningUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();
		for (int i = 0; i < num; i++) {
			HashMap<Integer, Boolean> map = new HashMap<>();
			int N = scn.nextInt();
			for (int j = 1; j <= N; j++) {
				map.put(j, true);
			}
			int M = scn.nextInt();
			for (int k = 0; k < M; k++) {
				int job = scn.nextInt();
				map.put(job, false);
			}
			int index = 1;
			// for chef index should be odd
			for (int l = 1; l <= N; l++) {
				if (map.get(l) && index % 2 == 1) {
					System.out.print(l + " ");
					map.put(l, false);
					index++;
				} else {
					if (index % 2 == 0 && map.get(l)) {
						index++;
					}
				}
			}
			System.out.println();
			for (int l = 1; l <= N; l++) {
				if (map.get(l)) {
					System.out.print(l + " ");
				}
			}

		}
	}

}
