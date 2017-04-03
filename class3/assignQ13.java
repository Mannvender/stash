package class3;

import java.util.Scanner;

public class assignQ13 {

	public static void main(String[] args) {
//		input
	Scanner scn= new Scanner(System.in);
	System.out.println("enter number of rows");
	int N=scn.nextInt();
//	code
	int value=1;
	int row=1;
	
	while(row<=N){
		int col=1;
		while(col<=row){
				System.out.print(+value);
				col=col+1;
		}
		value=value+1;
		row=row+1;
		System.out.print("\n");
	}
	}

}
