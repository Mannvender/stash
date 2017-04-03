package class3;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class patternStarInverse {

	public static void main(String[] args) {
//		input
	Scanner scn= new Scanner(System.in);
	System.out.println("enter number of rows");
	int N=scn.nextInt();
	
//	code
	int numstar=N/2+1;
	int numspace=1;
	int row=1;
	while(row<=N){
		int col=1;
//		stars 
		while(col<=numstar){
		System.out.print("*\t");
		col=col+1;
			
		}
//		spaces
		col=1;
		while(col<=numspace){
			System.out.print(" \t");
			col=col+1;
			
		}
//		star again
		col=1;
		while(col<=numstar){
			System.out.print("*\t");
			col=col+1;
		}
		if(row<N/2+1){
			numspace=numspace+2;
			numstar=numstar-1;
		}
		else{
			numspace=numspace-2;
			numstar=numstar+1;
		}
		row=row+1;
		System.out.print("\n");
	}
	}

}
