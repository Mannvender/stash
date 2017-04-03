package extraQuestions;

import java.util.Scanner;

public class ZeroOneSort {

	public static void main(String[] args) {
		// Scanner scn = new Scanner(System.in);
		// System.out.println("enter size");
		// int size = scn.nextInt();
		// int[] arr = new int[size];
		// for (int i = 0; i < arr.length; i++) {
		// System.out.println("enter " + i + " th element");
		// int temp = scn.nextInt();
		// arr[i] = temp;
		// }
//		int[] arr2 = class6.arr1D.takeinput();
//		int[] arr = { 1, 0, 0, 0, 1, 0 };
//		int[] answer=fun(arr2);
//		for (int i = 0; i < answer.length; i++) {
//			System.out.println(answer[i] + ",");
//		}
		sum(2, 5);
		System.out.println();

	}

	public static int[] fun(int[] arr) {
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			if (arr[left] == 0) {
				left++;
			}

			if (arr[right] == 1) {
				right--;
			}
			if (left <= right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}

		}
		return arr;
	}

	public static void sum(int a,int b){
		 System.out.println(a+b);
	}
}
