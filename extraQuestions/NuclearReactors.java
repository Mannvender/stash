package extraQuestions;

import java.util.Scanner;

public class NuclearReactors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int Bombartments = scn.nextInt();
		int limit = scn.nextInt();
		int Numchambers = scn.nextInt();
		int[] chamber = new int[Numchambers];
		for (int i = 0; i < Bombartments; i++) {
			for (int j = 0; j < Numchambers; j++) {
				if (chamber[j] < limit) {
					chamber[j] = chamber[j] + 1;
					break;
				} else {
					chamber[j] = 0;
				}

			}

		}
		for (int i = 0; i < chamber.length; i++) {
			System.out.print(chamber[i] + " ");
		}
		System.out.println();
	}

}
// another solution
/*
int main()
{
 int n,k,i,r;
 long int a;
 scanf("%ld%d%d",&a,&n,&k);
 n=n+1;
 for(i=0;i<k;i++)
 {
  r=a%n;
  a=a/n;
  printf("%d ",r);
 }
 return 0;
}
*/
