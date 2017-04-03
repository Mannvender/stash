package class5;

import java.util.Scanner;

public class Q14 {

	public static void main(String[] args) {
		// input
		Scanner scn = new Scanner(System.in);
		System.out.println("enter a character");
		char ch = scn.next().charAt(0);
		if (ch <= 'Z' && ch >= 'A') {
			System.out.println("U");
		} else if (ch <= 'z' && ch >= 'a') {
			System.out.println("L");
		} else {
			System.out.println("I");
		}
		System.out.println(ch);
		System.out.println(+ch);
		
		
		System.out.println("***********");
		ch=657;
		System.out.println(ch);
		System.out.println(+ch);
	}
}