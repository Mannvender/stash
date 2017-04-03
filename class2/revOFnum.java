package class2;

import java.util.Scanner;

public class revOFnum {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
//		taking input
		System.out.println("enter number");
		int N = scn.nextInt();
//		main code
		int rev=0;
		while(N>0){
			rev=rev*10+(N%10);
			N=N/10;
		}
		System.out.println("reverse of"+N+ "is"+rev);
	}

}
