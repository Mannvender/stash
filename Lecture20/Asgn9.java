package Lecture20;

import java.util.ArrayList;

import Lecture11.recursicePattern;
import Lecture11.returnALLindeices;

public class Asgn9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[] arr={1,6,4,9,5,3};
		// class6.arr1D.display(MaxMinArr(arr));
		// **************
		// int[] arr = { 1, 5, 3, 6 };
		// System.out.println(DuplicateInArr(arr));
		// *************
		// if duplicates in bigger array then program won't work fine;
		// int[] arr1 = { 5, 6, 7, 8 };
		// int[] arr2 = { 0, 3, 5, 4, 7, 8 };
		// System.out.println(intersctnArr(arr1, arr2));
		// *************
		// int[] arr1 = { 5, 6, 8 };
		// int[] arr2 = { 0, 3, 5, 4, 8, 7 };
		// int[] arr3 = { 2, 5, 46, 8, 7 };
		// System.out.println(intersctnArrOf3(arr1, arr2, arr3));
		// **************
		// System.out.println(StairsProblem(4, 0)[0]);
		System.out.println(BoardPathBetter(10, 0)[0]);
		String str = "aaaBBbb";
		System.out.println(PalindromicSubStrings(str));
		System.out.println(MaxFrequencyChar(str));
		// System.out.println(str.charAt(0) - 'a');
		int[] arr = { 0, 3, 2, 1, 4, 6, 5, 7 };
		PairSumtoTarget(arr, 7);
		TripletSumtoTarget(arr, 15);
		int[] arr2 = { 1, 2, 3, 0, 6, 8, 0 };
		class6.arr1D.display(ZeroesAtEnd(arr2));
		int[] ZeroOne = { 1, 0, 1, 0, 0, 0, 0, 1 };
		class6.arr1D.display(ZeroOne);
		ZeroOne = SortZeroOneArray(ZeroOne);
		class6.arr1D.display(ZeroOne);
		int[] array = { 5, 1, 2, 3, 4 };
		System.out.println(ForwardRotation(array));

	}

	public static int[] MaxMinArr(int[] arr) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		int[] rv = new int[2];
		rv[0] = min;
		rv[1] = max;
		return rv;
	}

	public static boolean DuplicateInArr(int[] arr) {

		arr = Lecture15.MergeSort.MergeSort(arr, 0, arr.length - 1);
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == arr[i - 1]) {
				return true;
			}
		}
		return false;
	}

	public static ArrayList<Integer> intersctnArr(int[] arr1, int[] arr2) {
		ArrayList<Integer> list = new ArrayList<>();
		if (arr1.length < arr2.length) {
			arr1 = Lecture15.MergeSort.MergeSort(arr1, 0, arr1.length - 1);
			for (int i = 0; i < arr2.length; i++) {
				if (BinarySearch(arr2[i], arr1, 0, arr1.length - 1) != -1) {
					list.add(arr2[i]);
				}
			}
			return list;
		} else {
			arr2 = Lecture15.MergeSort.MergeSort(arr2, 0, arr2.length - 1);
			for (int i = 0; i < arr1.length; i++) {
				if (BinarySearch(arr1[i], arr2, 0, arr2.length - 1) != -1) {
					list.add(arr1[i]);
				}
			}
			return list;
		}
	}

	public static ArrayList<Integer> intersctnArrOf3(int[] arr1, int[] arr2, int[] arr3) {
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
		ArrayList<Integer> listFinal = new ArrayList<>();
		// for first two
		if (arr1.length < arr2.length) {
			arr1 = Lecture15.MergeSort.MergeSort(arr1, 0, arr1.length - 1);
			for (int i = 0; i < arr2.length; i++) {
				if (BinarySearch(arr2[i], arr1, 0, arr1.length - 1) != -1) {
					list1.add(arr2[i]);
				}
			}

		} else {
			arr2 = Lecture15.MergeSort.MergeSort(arr2, 0, arr2.length - 1);
			for (int i = 0; i < arr1.length; i++) {
				if (BinarySearch(arr1[i], arr2, 0, arr2.length - 1) != -1) {
					list1.add(arr1[i]);
				}
			}

		}
		System.out.println(list1);
		int[] InterFirstTwo = new int[list1.size()];
		// converting to array
		for (int i = 0; i < InterFirstTwo.length; i++) {
			InterFirstTwo[i] = list1.get(i);
		}
		// for next two ie 2nd and 3rd
		if (arr2.length < arr3.length) {
			arr2 = Lecture15.MergeSort.MergeSort(arr2, 0, arr2.length - 1);
			for (int i = 0; i < arr3.length; i++) {
				if (BinarySearch(arr3[i], arr2, 0, arr2.length - 1) != -1) {
					list2.add(arr3[i]);
				}
			}

		} else {
			arr3 = Lecture15.MergeSort.MergeSort(arr3, 0, arr3.length - 1);
			for (int i = 0; i < arr2.length; i++) {
				if (BinarySearch(arr2[i], arr3, 0, arr3.length - 1) != -1) {
					list2.add(arr2[i]);
				}
			}

		}
		System.out.println(list2);
		// converting to array
		int[] InterLastTwo = new int[list2.size()];
		for (int i = 0; i < InterLastTwo.length; i++) {
			InterLastTwo[i] = list2.get(i);
		}

		// now two intersections
		if (InterFirstTwo.length < InterLastTwo.length) {
			InterFirstTwo = Lecture15.MergeSort.MergeSort(InterFirstTwo, 0, InterFirstTwo.length - 1);
			for (int i = 0; i < InterLastTwo.length; i++) {
				if (BinarySearch(InterLastTwo[i], InterFirstTwo, 0, InterFirstTwo.length - 1) != -1) {
					listFinal.add(InterLastTwo[i]);
				}
			}

		} else {
			InterLastTwo = Lecture15.MergeSort.MergeSort(InterLastTwo, 0, InterLastTwo.length - 1);
			for (int i = 0; i < InterFirstTwo.length; i++) {
				if (BinarySearch(InterFirstTwo[i], InterLastTwo, 0, InterLastTwo.length - 1) != -1) {
					listFinal.add(InterFirstTwo[i]);
				}
			}

		}
		return listFinal;
	}

	public static int BinarySearch(int item, int[] arr, int si, int li) {
		int ri = -1;
		int mid = (si + li) / 2;

		while (si <= li) {
			if (arr[mid] < item)
				si = mid + 1;
			else if (arr[mid] == item) {
				return mid;
			} else
				li = mid - 1;

			mid = (si + li) / 2;
		}
		if (si > li)
			return -1;
		return ri;
	}

	public static int[] StairsProblem(int size, int current) {
		if (current == size) {
			int[] base = new int[3];
			base[0] = 1;
			return base;
		}
		if (current > size) {
			int[] base = new int[3];
			base[0] = 0;
			return base;
		}
		int[] rv = new int[3];
		int[] RecurResult = StairsProblem(size, current + 1);
		int answer = RecurResult[0] + RecurResult[1] + RecurResult[2];
		rv[0] = answer;
		rv[1] = RecurResult[0];
		rv[2] = RecurResult[1];
		return rv;
	}

	public static int[] BoardPathBetter(int size, int current) {
		if (current == size) {
			int[] base = new int[6];
			base[0] = 1;
			return base;
		}
		int[] recResult = BoardPathBetter(size, current + 1);
		int i = 0;
		int[] MyResult = new int[6];
		while (i < recResult.length - 1) {
			MyResult[i + 1] = recResult[i];
			i++;
		}
		int j = 0, sum = 0;

		while (j < recResult.length) {
			sum = sum + recResult[j];
			j++;
		}
		MyResult[0] = sum;

		return MyResult;

	}

	public static int PalindromicSubStrings(String str) {
		int rv = 0;
		for (int i = 0; i < str.length(); i++) {
			// char cc = str.charAt(i);
			for (int j = 0; j < str.length(); j++) {
				if (i - j < 0 || i + j >= str.length()) {
					break;
				}
				if (str.charAt(i - j) == str.charAt(i + j)) {
					rv++;
				}
			}
		}

		return rv;
	}

	public static char MaxFrequencyChar(String str) {

		int[] Storage = new int[26];
		int i = 0;
		int Max = Integer.MIN_VALUE;
		while (i < str.length()) {
			if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
				Storage[str.charAt(i) - 'a'] = Storage[str.charAt(i) - 'a'] + 1;
			}
			if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
				Storage[str.charAt(i) - 'A'] = Storage[str.charAt(i) - 'A'] + 1;
			}
			i++;

		}
		for (int j = 0; j < Storage.length; j++) {
			if (Storage[j] > Max) {
				Max = j;
			}
		}
		char rv = (char) (Max + 'a');

		return rv;
	}

	// O(nlogn)
	public static void PairSumtoTarget(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;
		// sorting array
		arr = Lecture15.MergeSort.MergeSort(arr, 0, arr.length - 1);
		while (left < right) {
			int currSum = arr[left] + arr[right];
			if (currSum < target) {
				left++;
			} else if (currSum == target) {
				System.out.println(arr[left] + "," + arr[right]);
				left++;
			} else {
				right--;
			}

		}

	}

	// O(n^2)
	public static void TripletSumtoTarget(int[] arr, int target) {
		arr = Lecture15.MergeSort.MergeSort(arr, 0, arr.length - 1);
		for (int fix = 0; fix < arr.length; fix++) {
			int left = fix + 1;

			int right = arr.length - 1;

			while (left < right) {
				int currSum = arr[left] + arr[fix] + arr[right];
				if (currSum < target) {
					left++;

				} else if (currSum == target) {
					System.out.println(arr[left] + "," + arr[fix] + "," + arr[right]);
					left++;

				} else {
					right--;

				}

			}

		}

	}

	public static int[] ZeroesAtEnd(int[] arr) {
		int[] newarr = new int[arr.length];
		int i = 0;
		int j = 0;
		while (i != arr.length) {
			if (arr[i] != 0) {
				newarr[j] = arr[i];
				i++;
				j++;
			} else {
				i++;
			}

		}
		return newarr;

	}

	public static int[] SortZeroOneArray(int[] arr) {
		int size = arr.length, i = 0;
		int[] newarr = new int[size];
		int j = size - 1;
		while (i < size) {
			if (arr[i] == 1) {
				newarr[j] = 1;
				j--;
			}
			i++;

		}
		return newarr;
	}

	public static int ForwardRotation(int[] arr) {
		int rv = 0;
		int check = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (check > arr[i]) {
				if (rv == 0) {
					rv = i;
					break;
				}

			}
		}
		if (rv == 1 && arr[0] > arr[1] && arr[1] > arr[2]) {
			return arr.length;
		}
		return rv;
	}
}
