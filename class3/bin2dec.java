package class3;

import java.util.Scanner;

public class bin2dec {

	public static void main(String[] args) {
		// input
		Scanner scn = new Scanner(System.in);

		System.out.println("enter in binary");
		
		int bin = scn.nextInt();
		int dec=0;
		int twopower=1;
		while(bin!=0){
			int rem=bin%10;
			dec=dec+rem*twopower;
			bin=bin/10;
			twopower=twopower*2;
			
		}
		System.out.println("number in decimal is"+dec);
	}

}
