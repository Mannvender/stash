package extraQuestions;

import java.util.Scanner;

public class ZEroWithFive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();
		int answer = 0;
		int tenPowers = 0;
		while (num != 0) {
			int rem = num % 10;
			if (rem == 0) {
				rem = 5;

			}
			answer = (int) (answer + rem * Math.pow(10, tenPowers));
			tenPowers++;
			num = num / 10;

		}
		System.out.println(answer);
	}

}
