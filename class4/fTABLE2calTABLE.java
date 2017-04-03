package class4;

import java.util.Scanner;

public class fTABLE2calTABLE {

	public static void main(String[] args) {
		// input
		Scanner scn = new Scanner(System.in);
		System.out.println("enter minf");
		int minf = scn.nextInt();
	
//	input

System.out.println("enter maxf");
int maxf=scn.nextInt();

System.out.println("enter step");
int step=scn.nextInt();

while(minf<=maxf){
	double cal=(5*(minf-32))/9;
	System.out.print(+minf);
	System.out.print("\t");
	System.out.print(+cal);
	minf=minf+step;
	System.out.print("\n");
}
	}

}
