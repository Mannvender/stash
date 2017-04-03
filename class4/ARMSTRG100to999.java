package class4;

import java.util.Scanner;

public class ARMSTRG100to999 {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		System.out.println("enter lower limit");
		int lwr=scn.nextInt();
		System.out.println("enter upper limit");
		int upr=scn.nextInt();
		int N = 100;
		while (lwr <= upr) {
			int armnum;
			int save = 0;
			int reset=lwr;
			// code
			while (lwr != 0) {
				int rem = lwr % 10;
				int i = 1;
				armnum = 1;
				while (i <= 3) {
					armnum = armnum * rem;
					i = i + 1;
				}
				save = save + armnum;
				lwr = lwr / 10;
			}
			lwr=reset;
			if (save == lwr) {
				System.out.println(+lwr);
			}
			lwr = lwr + 1;
			
		}
	}

}
