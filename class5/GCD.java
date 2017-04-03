package class5;

import java.util.Scanner;

public class GCD {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("enter num1");
		int num1 = scn.nextInt();
		System.out.println("enter num2");
		int num2 = scn.nextInt();
		int gcd=1;
		
		if(num1>=num2){
			int counter=num2;
			while(counter>=1){
				if(num1%counter==0&&num2%counter==0){
					gcd=gcd*counter;
					System.out.println(gcd);
					break;
				}
				counter--;
			}
		}
		else{
			int counter=num1;
			while(counter>=1){
				if(num1%counter==0&&num2%counter==0){
					gcd=gcd*counter;
					System.out.println(gcd);
					break;
				}
				counter--;
			}
		}
		
	}

}
