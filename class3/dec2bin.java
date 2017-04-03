package class3;

import java.util.Scanner;

public class dec2bin {

	public static void main(String[] args) {
		// input
		Scanner scn = new Scanner(System.in);

		System.out.println("enter in decimal");
		
		int dec = scn.nextInt();
		int bin=0;
		int tenpower=1;
		
		while(dec!=0){
			int rem=dec%2;
			bin=bin+rem*tenpower;
			tenpower=tenpower*10;
		dec=dec/2;	
		}
		System.out.println("number in decimal is"+bin);
	}

}
