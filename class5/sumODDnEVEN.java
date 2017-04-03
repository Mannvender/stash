package class5;

import java.util.Scanner;

public class sumODDnEVEN {

	public static void main(String[] args) {
		// input
		Scanner scn = new Scanner(System.in);

		System.out.println("enter num");

		int N = scn.nextInt();
		int count=1;
		int sumodd=0;
		int sumeven=0;
		while(N!=0){
			int rem=N%10;
			if(count%2==0){
				sumeven=sumeven+rem;
			}
			else{
				sumodd=sumodd+rem;
			}
			count++;
			N=N/10;
		}
		System.out.println(+sumodd);
		System.out.println(+sumeven);
	}

}
