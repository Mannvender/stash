package extraQuestions;

import java.util.Scanner;
//https://www.codechef.com/problems/RIGHTRI
public class ChefandTheRightTriangles {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();

		int result = 0;
		for (int i = 0; i < t; i++) {
			result += fun(scn);
		}
		System.out.println(result);
	}

	private static int fun(Scanner scn) {
		int x1 = scn.nextInt();
		int y1 = scn.nextInt();
		int x2 = scn.nextInt();
		int y2 = scn.nextInt();
		int x3 = scn.nextInt();
		int y3 = scn.nextInt();

		int s1 = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
		int s2 = (x3 - x1) * (x3 - x1) + (y3 - y1) * (y3 - y1);
		int s3 = (x2 - x3) * (x2 - x3) + (y2 - y3) * (y2 - y3);
		if (s1 == s2 + s3 || s2 == s1 + s3 || s3 == s1 + s2) {
			return 1;
		} else {
			return 0;
		}
	}

}
