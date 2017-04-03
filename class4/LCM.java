package class4;

import java.util.Scanner;

public class LCM {

	public static void main(String[] args) {
//		input
	Scanner scn= new Scanner(System.in);
	System.out.println("enter first number");
	int N1=scn.nextInt();
	System.out.println("enter second number");
	int N2=scn.nextInt();
//	code
	int count;
	int lcm=1;
	if(N1>N2){
		count =N2;
	}
	else{
		count=N1;
	}
	while(count>=2){
		if(N1%count==0&&N2%count==0){
			lcm=lcm*count;
			N1=N1/count;
			N2=N2/count;
		}
		count=count-1;
	}
	lcm=lcm*N1*N2;
	System.out.println("LCM is "+lcm);
	}

}
