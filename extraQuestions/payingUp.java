package extraQuestions;

import java.util.Scanner;

public class payingUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();
		for (int i = 0; i < num; i++) {
			int numN = scn.nextInt();
			int[] Nvalue = new int[numN];
			int demand = scn.nextInt();
			if (demand == 0) {
				System.out.println("Yes");
			}
			for (int j = 0; j < numN; j++) {
				Nvalue[j] = scn.nextInt();
			}
			// fun(Nvalue, demand, 0);
			solutionCodeChef(Nvalue, demand);

		}

	}

	public static void solutionCodeChef(int[] value, int demand) {
		for (int i = 1; i <= Math.pow(2, value.length); i++) {

			String binary = Integer.toBinaryString(i);
			int sumTillNow = 0;
			for (int j = 0; j < binary.length(); j++) {
				if (binary.charAt(j) == '1') {
					sumTillNow = sumTillNow + value[j];
				}
			}
			if (sumTillNow == demand) {
				System.out.println("Yes");
				return;
			}

		}
		System.out.println("No");

	}

}
