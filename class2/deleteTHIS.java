package class2;

public class deleteTHIS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// isPrime(17);
		// NthFibo(5);
		// reverseNumber(3274);
		// ptrnIncNum(4);
		ptrnStarDiamond(4);
	}

	public static void ptrnIncNum(int n) {
		// TODO Auto-generated method stub
		int value = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(value + "\t");
				value++;
			}
			System.out.println();
		}

	}

	public static void Prime(int n) {
		boolean[] arr = new boolean[n + 1];
		for (int i = 2; i < arr.length; i++) {
			arr[i] = true;
		}

		for (int divisor = 2; divisor * divisor <= n; divisor++) {
			for (int multiple = 2; multiple * divisor <= n; multiple++) {
				arr[divisor * multiple] = false;
			}
		}
		for (int i = 2; i <= n; i++) {
			if (arr[i]) {
				System.out.println(i);
			}

		}
	}

	public static void isPrime(int n) {

		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				System.out.println("number is not prime");
				return;
			}
		}
		System.out.println("prime");
	}

	public static void NthFibo(int n) {
		int oth = 0;
		int ist = 1;
		int retval = 1;
		for (int i = 1; i <= n; i++) {
			retval = oth + ist;
			oth = ist;
			ist = retval;
		}
		System.out.println(retval);
	}

	public static void reverseNumber(int n) {
		int retval = 0;
		for (int i = n, power = 10; i > 0; i = i / 10) {
			retval = retval * power + i % 10;

		}
		System.out.println(retval);
	}

	public static void ptrnScnd(int n) {
		// TODO Auto-generated method stub
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				if (j != 1 && j != i) {
					System.out.print("0\t");
				} else {
					System.out.print(i + "\t");
				}

			}
			System.out.println();
		}

	}

	public static void ptrnThird(int n) {
		// TODO Auto-generated method stub
		int first = 0;
		int second = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				int value = first + second;
				System.out.print(first + "\t");
				first = second;
				second = value;

			}
			System.out.println();
		}

	}
	public static void ptrnStarDiamond(int n) {
		// TODO Auto-generated method stub
		for (int i = 1; i <= n; i++) {
			for(int j=i/2;j>0;j--){
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j=j+2) {
			System.out.print("*\t");

			}
			System.out.println();
		}

	}
}
