package extraQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DividingStamps {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		int sum = 0;
		for (Integer i = 0; i < t; i++) {
			int t1 = scn.nextInt();
			sum += t1;
		}
		int expctd = (t * (t + 1)) / 2;
		if (sum == expctd) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

}
