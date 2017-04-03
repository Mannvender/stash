package extraQuestions;

import java.util.*;
//https://www.codechef.com/problems/J7
class TheBestBox {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int p = 0, s = 0;
		double l = 0.0, b = 0.0;
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			p = sc.nextInt();
			s = sc.nextInt();
			double a = Math.pow(p, 2);
			l = (p - (Math.sqrt((a - 24 * s)))) / 12;
			b = (-2) * l + p / 4.0;
			double valume = l * l * b;
			String s1 = String.format("%.2f", valume);
			System.out.println(s1);
		}
	}
}
