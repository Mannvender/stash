package class6;

import java.util.Scanner;

import class4.inverseOFnum;

public class arr1D {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// this is current arr, and it will be changing
		int[] arr = { 3, 1, 0, 2 };
		int N = 4;
		// int[] arr = takeinput();
		display(arr);
		System.out.println("***************");
		System.out.println("max number in arr is : " + max(arr));
		System.out.println("**************");
		/*
		 * System.out.println("enter element to search"); int data =
		 * scn.nextInt(); System.out.println(data + "is found at " +
		 * linearsearch(arr, data)); System.out.println("**************");
		 */
		/*
		 * reverse(arr); System.out.println("reversed array is: ");
		 * display(arr); System.out.println("***************");
		 */
		int newarr[] = inverse(arr);
		System.out.println("inversed array of the present arr is:");
		display(newarr);
		// System.out.println("*******************");
		// System.out.println("enter array to check if it is inverse of the
		// current arr");
		// int[] arr1 = takeinput();
		// if (arr1.length != arr.length) {
		// System.out.println("invalid input");
		// } else {
		// System.out.println(inverseCheck(arr1, arr));
		// }
		System.out.println("************");
		System.out.println("enter a array to check if it is mirror inverse");
		int[] arr2 = takeinput();

		System.out.println(mirrorInverse(arr2));
	}

	public static void display(int[] arr) {
		for (int val : arr) {
			System.out.print(val + ", ");
		}
		System.out.println("END");
	}

	public static int[] takeinput() {
		int[] retval = null;
		System.out.println("enter the size");
		int N = scn.nextInt();
		retval = new int[N];
		for (int i = 0; i < retval.length; i++) {
			System.out.println("enter" + i + "th element:");
			int data = scn.nextInt();
			retval[i] = data;
		}
		return retval;
	}

	public static int max(int[] arr) {
		int i = 0;
		int max = arr[i];
		for (i = 0; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
		}

		return max;

	}

	public static int linearsearch(int[] arr, int data) {
		for (int i = 0; i < arr.length; i++) {
			if (data == arr[i]) {
				return i;
			}
		}

		return -1;

	}

	public static void reverse(int[] arr) {
		int left = 0, right = arr.length - 1;
		while (left <= right) {
			swap(arr, left, right);
			left++;
			right--;
		}
	}

	public static void swap(int arr[], int i, int j) {

		int temp = 0;
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static int[] inverse(int[] arr) {
		int j;
		int newarr[] = new int[arr.length];
		for (j = 0; j < arr.length; j++) {
			for (int i = 0; i < arr.length; i++) {

				if (arr[i] == j) {
					newarr[j] = i;
					break;
				}

			}

		}
		return newarr;
	}

	public static boolean inverseCheck(int[] arr1, int[] arr2) {
		int[] arrinverse = inverse(arr2);
		boolean bo = true;
		int check = 0;
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arrinverse[i]) {
				check++;
				bo = false;
			}
		}
		// if (bo) {
		// System.out.println("yes given array is inverse of the previous
		// array");
		// } else {
		// System.out.println(" not inverse");
		// }
		return bo;

	}

	public static boolean mirrorInverse(int[] arr) {
		int[] inverse = inverse(arr);
		boolean bo = true;
		int check = 0;
		for (int i = 0; i < arr.length; i++) {

			if (arr[i] != inverse[i]) {
				check++;
				bo = false;
			}

		}
		// if (bo) {
		// System.out.println("yes input is mirror inverse");
		// } else {
		// System.out.println("no not a mirror inverse");
		// }
		return bo;
	}
}
