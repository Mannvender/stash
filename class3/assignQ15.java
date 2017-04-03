package class3;

import java.util.Scanner;

public class assignQ15 {

	public static void main(String[] args) {
//		input
	Scanner scn= new Scanner(System.in);
	System.out.println("enter number of rows");
	int N=scn.nextInt();
//	code
	int value=1;
	int row=1;
	int numzero=-1;
	while(row<=N){
		int col=1;
//		numbers
		while(col<=1){
			System.out.print(+value+"\t");
			col=col+1;
			
		}
//		zeroes
		col=1;
		while(col<=numzero){
			System.out.print("0\t");
			col=col+1;
			
		}
//		again nums
		col=1;
		while(col<=1){
			if(row==1){
				break;
			}
			System.out.print(+value+"\t");
			col=col+1;
			
		}
		value=value+1;
		row=row+1;
		numzero=numzero+1;
		System.out.print("\n");
		
		
	}
	}

}
