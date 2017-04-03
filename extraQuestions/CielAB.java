package extraQuestions;

import java.util.Scanner;

public class CielAB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn =new Scanner(System.in);
		int a=scn.nextInt();
		int b=scn.nextInt();
		int rv=Math.abs(a-b);
		int c=rv%10;
		rv=rv/10;
		if(c!=1){
			rv=rv*10+1;	
		}else{
			rv=rv*10+2;	
		}
		System.out.println(rv);
		

	}

}
