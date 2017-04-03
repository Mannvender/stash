package class4;

import java.util.Scanner;

public class powerXn {

	public static void main(String[] args) {
		// input
		Scanner scn = new Scanner(System.in);
		System.out.println("enter base");
		int base = scn.nextInt();
		// input
		System.out.println("enter power");
		int pow = scn.nextInt();
		int i=1;
		int answer=1;
		while(i<=pow){
			answer=answer*base;
			i=i+1;
		}
		System.out.println(+base+" raise to power "+pow+" is "+answer);
	}

}
