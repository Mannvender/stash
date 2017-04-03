package Lecture12;

import class3.starDiamond;

public class assgn6Recur {

	public static void main(String[] args) {

		// pascaltri(5,0,0,1);
		// **************
		// int[] arr = { 1, 2, 6, 4, 2, 1 };
		// System.out.println(palindromeArray(arr, 0, arr.length - 1));
		// ***************
		// int[] arr = { 2, 3, 4, 5, 6 };
		// class6.arr1D.display(reverseArray(arr, 0));
		// *****************
		// int[] arr = { 3, 2, 0, 1 };
		// class6.arr1D.display(inverseArray(arr, 0));
		// ******************
		// System.out.println(NthTriangle(3));
		///// fix it
		int[] arr = { 3, 5, 0, 2, 1, 4 };
		class6.arr1D.display(arr);
		InverseArray(arr, 0);
		////// below is already fixed
		// inverseArrayClass(arr, 0);
		// class6.arr1D.display(arr);
	}

	public static void pascaltri(int n, int row, int col, int val) {
		if (row == n) {
			return;
		}
		if (col > row) {
			System.out.println();
			pascaltri(n, row + 1, 0, 1);
			return;
		}

		System.out.print(val + "\t");
		pascaltri(n, row, col + 1, val = (val * (row - col)) / (col + 1));
	}

	public static boolean palindromeArray(int[] arr, int si, int li) {
		if (si > li) {
			return true;
		}

		if (arr[si] != arr[li]) {
			return false;
		} else {
			boolean retVal = palindromeArray(arr, si + 1, li - 1);
			return retVal;
		}

	}

	public static int[] reverseArray(int[] arr, int si) {
		if (si == arr.length) {
			int[] base = new int[arr.length];
			return base;
		}

		int[] recResult = reverseArray(arr, si + 1);
		int cc = arr[si];
		recResult[arr.length - si - 1] = cc;

		return recResult;

	}

	public static int[] inverseArray(int[] arr, int si) {
		if (si == arr.length) {
			return new int[arr.length];
		}

		int[] myResult = inverseArray(arr, si + 1);
		int cc = arr[si];
		myResult[cc] = si;
		return myResult;
	}

	public static int NthTriangle(int n) {
		if (n == 1) {
			return 1;
		}
		int recResult = NthTriangle(n - 1);
		int myResult = recResult + n;
		return myResult;
	}

	// fix it
	public static void InverseArray(int[] arr, int si) {
		if (si == arr.length) {
			return;
		}
		int cc = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == arr.length - 1 - si) {
				cc = i;
				break;
			}

		}
		InverseArray(arr, si + 1);
		System.out.print(cc+", ");

	}

	public static void inverseArrayClass(int[] arr, int si) {
		if (si == arr.length) {
			return;
		}
		int cc = arr[si];
		inverseArrayClass(arr, si + 1);
		arr[cc] = si;
	}
}
