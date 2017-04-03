package extraQuestions;

import java.util.Scanner;
//https://www.codechef.com/problems/NUMGAME2

// solution
// https://discuss.codechef.com/questions/4162/numgame2-editorial

public class NumberGameRevisited {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for (int i = 0; i < t; i++) {
			fun(scn);
		}
	}

	private static void fun(Scanner scn) {
		int n=scn.nextInt();
		if(n%4==1){
			System.out.println("ALICE");
		}else{
			System.out.println("BOB");
		}
	}


	
}
