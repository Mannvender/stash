package class8;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class asgn4 {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// Q11();
		
		 //Q12();
		//Q12try();
		// Q13();
		// Q14();
		int[] arr = { 1, 2, 3, 4 };
		//Q15bitwise();
		Q15(arr);
	}

	public static void Q11() {
		// int[] arr1 = class6.arr1D.takeinput();
		// int[] arr2 = class6.arr1D.takeinput();
		int[] arr1 = { 1, 2, 3, 1, 2, 4, 1 };
		int[] arr2 = { 2, 1, 3, 1, 5, 2, 2 };
		// int[] arr1 = { 6,7,8};
		// int[] arr2 = { 5,6,10};
		// int[] arr2 = { 1, 4, 4, 4, 7, 10 };
		// int[] arr1 = { 3, 3, 4, 4, 7, 8, };
		int jsave, isave;

		ArrayList<Integer> list;
		list = new ArrayList<>();
		if (arr1.length != arr2.length) {
			System.out.println("both arrays are not of same size");
			return;
		}
		class8.sorts.insertionSort(arr1);
		class8.sorts.insertionSort(arr2);
		int i = 0;
		// i compares elements from arr2
		// we take one elment from arr2 and compare with arr1 elements
		while (i < arr1.length) {
			for (int j = 0; j < arr1.length; j++) {
				if (arr1[j] > arr2[i]) {
					break;
				} else if (arr1[j] == arr2[i]) {
					// new
					int rad1 = 1, rad2 = 1;
					jsave = j;
					isave = i;
					for (j = jsave; j < arr1.length - 1; j++) {
						if (arr1[j] == arr1[j + 1]) {
							rad1++;
						} else {
							break;
						}
					}
					for (i = isave; i < arr1.length - 1; i++) {
						if (arr2[i] == arr2[i + 1]) {
							rad2++;
						} else {
							break;
						}
					}
					// taking everything back to normal values
					i = isave;
					j = jsave;
					if (rad2 > rad1) {
						for (int k = 1; k <= rad1; k++) {
							list.add(arr2[i]);

						}
						i = i + rad2 - 1;
						break;
					}
					list.add(arr1[j]);
					break;
				}
			}
			i++;
		}
		class6.arr1D.display(arr1);
		class6.arr1D.display(arr2);
		System.out.println(list);
	}

	public static void Q12() {
		int[] arr = class6.arr1D.takeinput();
		class8.sorts.insertionSort(arr);
		class6.arr1D.display(arr);
		System.out.println("enter target number");
		int N = scn.nextInt();
		for (int j = 0; j < arr.length / 2; j++) {
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] + arr[j] == N && i != j) {
					System.out.println(+arr[i] + "," + arr[j]);
					System.out.println("*******");

				}
			}
		}
	}

	public static void Q12try() {
		int[] arr = class6.arr1D.takeinput();
		class6.arr1D.display(arr);
		System.out.println("enter target number");
		int N = scn.nextInt();
		int counter = 0;
		for (int j = counter; j < arr.length; j++) {
			for (int i = counter + 1; i < arr.length; i++) {
				if (arr[i] + arr[j] == N && i != j) {
					System.out.println(+arr[i] + "," + arr[j]);
					System.out.println("*******");
					break;
				}
			}
			counter++;
		}
	}

	public static void Q13() {
		int[] arr = class6.arr1D.takeinput();
		class6.arr1D.display(arr);
		System.out.println("enter target number");
		int N = scn.nextInt();
		int counter = 0;
		for (int j = counter; j < arr.length; j++) {
			for (int i = counter + 1; i < arr.length; i++) {
				for (int k = counter + 2; k < arr.length; k++) {
					if (arr[i] + arr[j] + arr[k] == N && i != j && j != k && k != i) {
						System.out.println(+arr[i] + "," + arr[j] + "," + arr[k]);
						System.out.println("*******");
						break;
					}
				}

			}
			counter++;
		}
	}

	public static void Q15(int[] arr) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		
		int counter = (int) Math.pow(2, arr.length) - 1;
		int count = 0;
		while (count <= counter) {
			int timesdiv = 0;
			ArrayList<Integer> inner = new ArrayList<>();
			int inC = count;
			while (timesdiv <= arr.length - 1) {

				int rem = inC % 2;
				if (rem == 1) {
					inner.add(arr[timesdiv]);
				}
				inC = inC / 2;

				timesdiv++;
			}
			list.add(inner);
			count++;
		}
		System.out.println(list);
	}

	public static void Q15bitwise() {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		int[] arr = { 1, 2, 3, 4 };
		int counter = (int) Math.pow(2, arr.length) - 1;
		int count = 0;
		while (count <= counter) {
			ArrayList<Integer> inner = new ArrayList<>();
			int times = 0;
			int shift = 7;

			while (times <= arr.length - 1) {
				byte b = (byte)count;
				b = (byte) (b << shift);
				b = (byte) (b >>> 7);
				if (b == 1) {
					inner.add(arr[times]);
				}
				shift--;
				times++;
			}

			list.add(inner);
			count++;
		}
		System.out.println(list);
	}

	public static void Q14() {

		// int []arr1={3,4,5,6,7};
		// int []arr2={1,0,2,9};
		int[] arr1 = { 9, 9, 9, 9 };
		int[] arr2 = { 1, 0, 0, 0, 0, 0 };
		int[] newarr = new int[arr1.length];
		int j = arr1.length - 1, k = arr2.length - 1, sum;
		int carry = 0;
		if (arr1.length >= arr2.length) {
			for (int i = arr1.length - 1; i >= 0; i--) {
				if (k >= 0) {
					sum = arr1[j] + arr2[k] + carry;
					k--;
				} else {
					sum = arr1[j] + carry;
				}
				newarr[i] = sum % 10;
				carry = sum / 10;
				j--;
			}
			if (carry != 0) {
				System.out.print(carry + ", ");
				class6.arr1D.display(newarr);
			} else {
				class6.arr1D.display(newarr);
			}
		} else {
			System.out.println("plz make sure first array is greater than or equal to 2nd one");
		}
	}

//	public static ArrayList<ArrayList<Integer>> getPermutations(int[] arr){
//		ArrayList<ArrayList<Integer>> retVal=new ArrayList<>();
//		ArrayList<ArrayList[]> solver=new ArrayList<>();
//		ArrayList<Integer>[] seed =new ArrayList[2];
//		seed[0]=new ArrayList<>();
//		seed[1]=new ArrayList<>();
//		for(int i=0;i<arr.length;i++){
//			seed[0].add(arr[i]);
//		}
//		while(){
//			
//		}
//		
//		
//		
//		
//		
//		return retVal;
//	}
}