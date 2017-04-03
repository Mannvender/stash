package class4;

import java.util.Scanner;

public class count5inNUMBER {

	public static void main(String[] args) {
//		input
	Scanner scn= new Scanner(System.in);
	System.out.println("enter a number");
	int N=scn.nextInt();
	System.out.println("enter a number/digit");
	int n=scn.nextInt();
	int count=0;
	while(N!=0){
		int rem=N%10;
		if(rem==n){
			count=count+1;
		}
		
		N=N/10;
	}
	System.out.println("there are "+count+" five's in your number");
	}

}
