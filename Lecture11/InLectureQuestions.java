package Lecture11;

public class InLectureQuestions {

	public static void main(String[] args) {
		// DI(5);
		// diSkip(5);
		// System.out.println(factorial(5));
		// System.out.println(fibo(50));
		// System.out.println(power(2,10));
		// System.out.println(isSorted(new int[] { 1, 2, 5, 3, 8 }));
		// *************************
		int[] arr = { 2, 4, 6, 3, 8 };
		// System.out.println(isPresent(arr, 3));

		System.out.println(isSortedSmarter(arr, 0));

	}

	public static boolean isSortedSmarter(int[] arr, int si) {
		if (si == arr.length - 1) {
			return true;
		}

		if (arr[si] > arr[si + 1]) {
			return false;
		} else {
			boolean isSAsorted = isSortedSmarter(arr, si + 1);
			return isSAsorted;
		}

	}

	public static boolean isPresentSmarter(int[] arr, int num) {
		if (arr.length == 0) {
			return false;
		}

		if (arr[0] == num) {
			return true;
		} else {
			int[] sa = new int[arr.length - 1];
			for (int i = 1; i < arr.length; i++) {
				sa[i - 1] = arr[i];
			}
			boolean isfoundSA = isPresent(sa, num);
			return isfoundSA;
		}

	}
	public static boolean isPresent(int[] arr, int num) {
		if (arr.length == 0) {
			return false;
		}

		if (arr[0] == num) {
			return true;
		} else {
			int[] sa = new int[arr.length - 1];
			for (int i = 1; i < arr.length; i++) {
				sa[i - 1] = arr[i];
			}
			boolean isfoundSA = isPresent(sa, num);
			return isfoundSA;
		}

	}

	public static boolean isSorted(int[] arr) {
		if (arr.length == 1) {
			return true;
		}

		if (arr[0] > arr[1]) {
			return false;
		} else {
			int[] sa = new int[arr.length - 1];
			for (int i = 1; i < arr.length; i++) {
				sa[i - 1] = arr[i];
			}

			boolean isSAsorted = isSorted(sa);
			return isSAsorted;
		}

	}

	public static int power(int x, int n) {
		if (n == 0) {
			return 1;
		}

		int lstpower = power(x, n - 1);
		int retVal = lstpower * x;
		return retVal;

	}

	// printing nth fibo
	public static int fibo(int num) {
		if (num == 1 || num == 0) {
			return num;
		}
		int last = fibo(num - 1);
		int last2nd = fibo(num - 2);
		int result = last + last2nd;
		return result;
	}

	public static int factorial(int num) {
		if (num == 0) {
			return 1;
		}

		int fsmall = factorial(num - 1);
		int fac = num * fsmall;
		return fac;
	}

	// printing inc and dec numbers
	public static void DI(int num) {
		if (num <= 0) {
			return;
		}
		System.out.println(num);
		DI(num - 1);
		System.out.println(num);

	}

	// printing odd while decreasing and even when increasing
	public static void diSkip(int num) {
		if (num <= 0) {
			return;
		}
		if (num % 2 == 1) {
			System.out.println(num);
		}
		diSkip(num - 1);
		if (num % 2 == 0) {
			System.out.println(num);
		}

	}

}
