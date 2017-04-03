package extraQuestions;

import java.util.Scanner;

public class TwelveHourTO24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		// input in form of hh:mm:ss(AM/PM)
		// don't use any bracket in input
		String s = scn.nextLine();
		int hour = s.charAt(0) - '0';
		hour = hour * 10 + s.charAt(1) - '0';
		// System.out.println(hour);
		String rv = new String();
		if (s.charAt(s.length() - 2) == 'A') {
			if (hour == 12) {
				rv = s.substring(0, s.length() - 2);
				rv = rv.substring(2, rv.length());
				int newh = 0;
				rv = newh + rv;
				rv = 0 + rv;

			} else {
				rv = s.substring(0, s.length() - 2);
			}

		} else {
			if (hour == 12) {
				rv = s.substring(0, s.length() - 2);
			} else {
				rv = s.substring(0, s.length() - 2);
				rv = rv.substring(2, rv.length());
				int newhour = hour + 12;
				rv = newhour + rv;

			}
		}
		System.out.println(rv);

	}

}
