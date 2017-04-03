package extraQuestions;

import java.util.Scanner;

public class ok {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int numQueries = scn.nextInt();
		int[] queryStore = takeinput(numQueries * 2, scn);
		// first store n then m;
		for(int n=0, m=1;m<queryStore.length;m=m+2,n=n+2){
			TotalOut(queryStore[n], queryStore[m]);
		}

	}

	public static int[] takeinput(int size, Scanner scn) {
		int[] retval = null;
		int N = size;
		retval = new int[N];
		for (int i = 0; i < retval.length; i++) {
			int data = scn.nextInt();
			retval[i] = data;
		}
		return retval;
	}
	public static int TotalOut(int n,int m){
		
		return 0;
	}

}
