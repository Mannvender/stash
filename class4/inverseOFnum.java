package class4;

import java.util.Scanner;

public class inverseOFnum {

	public static void main(String[] args) {
		// input
		Scanner scn = new Scanner(System.in);
		System.out.println("enter number");
		int num = scn.nextInt();
		int N = 0;
		int tenpower = 1;
		int count = 1;
		int inverse=0;
		int reset = num;

		// term count
		while (num != 0) {
			N = N + 1;
			num = num / 10;

		}
		// CODE
	
		while (count<=N){
			
			num = reset;
			int termcount = 1;
			while (num != 0) {
				int rem = num % 10;
				if (rem == count) {
					inverse=inverse+termcount*tenpower;
					tenpower=tenpower*10;
				}
				termcount = termcount+ 1;
				num = num / 10;
			}

			count = count +1;
		}
		System.out.println(+inverse);
		if(inverse==reset){
			System.out.println("yes number is mirror inverse");
			
		}
		else{
			System.out.println("no number is not mirror inverse");
		}

	}
}

