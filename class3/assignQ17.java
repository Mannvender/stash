package class3;

import java.util.Scanner;

public class assignQ17 {

	public static void main(String[] args) {
		// input
		Scanner scn = new Scanner(System.in);
		System.out.println("enter number of rows");
		int N = scn.nextInt();
		// code
		int row=1;
		int value=1;
		int lstvalue=0;
		while(row<=N){
			int col=1;
			while(col<=row){
				System.out.print(+lstvalue+"\t");
				value=value+lstvalue;
				lstvalue=value-lstvalue;
				col=col+1;
			}
			System.out.print("\n");
			row=row+1;
		}
	}

}
