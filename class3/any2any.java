package class3;

import java.util.Scanner;

public class any2any {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("enter source base");

		int sb = scn.nextInt();
		System.out.println("enter destination base");
		int db = scn.nextInt();
		System.out.println("enter source number");
		int sn = scn.nextInt();
		int i = 1;
		int dn = sn;
//		trying
		int savedb=db;
			db = 10;
			i = 0;
		
		while (i <= 1) {

			sn = dn;
			dn = 0;
			int power = 1;
			while (sn != 0) {
				int rem = sn % db;

				dn = dn + rem * power;
				power = sb * power;
				sn = sn / db;

			}
			db=savedb;
			sb = 10;
			i++;
		}
		System.out.println("destination number is" + dn);

	}

}
