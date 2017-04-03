package Lecture16;

import java.util.ArrayList;

import Lecture11.string2Number;

public class assgn8Arecur {

	public static void main(String[] args) {
		// System.out.println(CountTowerHanoi(3, 'a', 'b', 'c'));
		// printTowerHanoi(3, 'a', 'b', 'c');
		// ***************
		// int[] arr = { 1, 3, 5, 7, 0 };
		// System.out.println(CountEqualSumArrays(arr, arr.length - 1));
		// ***************
		// int[] arr = { 2, 4, 8, 0 };
		// System.out.println(CountEqualSum2Arrays(arr, 0));
		// ****************
		// int[] arr = { 1, 9, 2, 7, 3, 4 };
		// equalSumArrayParts(arr, 0, 0, 0, "", "");
		// **************
		// String s = "bcad";
		// lexicoSmallerWords(s, "", false);
		// System.out.println("***********");
		// lexicoGreatorWords(s, "", false);
		// ****************
		int[] arr = { 1, 2, 3, 4, 5 };
		TargetSumArraySubsets(arr, 0, "", 5);
	}

	public static int CountTowerHanoi(int n, char from, char using, char to) {
		if (n == 1) {
			return 1;
		}
		int steps = 0;
		int recurA2B = CountTowerHanoi(n - 1, from, to, using);
		steps = steps + 1;

		int recurB2C = CountTowerHanoi(n - 1, using, from, to);

		return recurA2B + steps + recurB2C;

	}

	public static void printTowerHanoi(int n, char from, char using, char to) {
		if (n == 0) {
			return;
		}
		// it moves n-1 disks to using/helping tower
		printTowerHanoi(n - 1, from, to, using);
		// real work i.e. last disk we move
		System.out.println("move " + n + "th plate from " + from + " to " + to);
		// now it move all disks from helping tower to destination tower
		printTowerHanoi(n - 1, using, from, to);

		return;
	}

	// without recursion codes
	public static int CountEqualSum2Arrays(int[] arr, int si) {
		int count = 0;
		int sum = 0;
		for (int i : arr) {
			sum = sum + i;
		}
		if (sum % 2 == 1) {
			return 0;
		} else {
			String s = new String();
			for (int i = 0; i < arr.length; i++) {
				s = s + arr[i];
			}
			ArrayList<String> subarrays = Lecture12.subString.getSS(s);
			int funcResult = isSubsetSum(subarrays, sum / 2);
			count = funcResult;
		}

		return count;
	}

	// helping code for above
	public static int isSubsetSum(ArrayList<String> subarrays, int sum4subArrays) {
		int countHowManySubAray = 0;
		for (int i = 1; i < subarrays.size(); i++) {
			String get = subarrays.get(i);
			int sum = 0;
			for (int j = 0; j < get.length(); j++) {
				sum = sum + (get.charAt(j) - '0');
			}
			if (sum == sum4subArrays) {
				countHowManySubAray++;
			}
		}
		return countHowManySubAray / 2;

	}

	public static int sumOfAry(int[] arr) {
		int sum = 0;
		for (int i : arr) {
			sum = sum + i;
		}
		return sum;
	}

	// complete it
	public static void lexicoSmallerWords(String s, String osf, boolean flag) {
		if (s.length() == 0) {
			System.out.println(osf);
		}

		if (flag) {
			for (int i = 0; i < s.length(); i++) {
				String ros = s.substring(0, i) + s.substring(i + 1);
				char cc = s.charAt(i);
				lexicoSmallerWords(ros, osf + cc, true);
			}
		} else {
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(0) >= s.charAt(i)) {
					String ros = s.substring(0, i) + s.substring(i + 1);
					char cc = s.charAt(i);
					lexicoSmallerWords(ros, osf + cc, flag || s.charAt(0) > s.charAt(i));
				} else {
					// nothing
				}
			}

		}

	}

	public static void lexicoGreatorWords(String s, String osf, boolean flag) {
		if (s.length() == 0) {
			System.out.println(osf);
		}
		// if flag is true ie if next char is greator than very first char then
		// all permutations are counted
		// and once flag is true it will always be true;
		if (flag) {
			for (int i = 0; i < s.length(); i++) {
				String ros = s.substring(0, i) + s.substring(i + 1);
				char cc = s.charAt(i);
				lexicoGreatorWords(ros, osf + cc, true);
			}
		} else {
			for (int i = 0; i < s.length(); i++) {
				// here it will check if the next char is greator or equal to
				// very first char
				if (s.charAt(0) <= s.charAt(i)) {
					String ros = s.substring(0, i) + s.substring(i + 1);
					char cc = s.charAt(i);
					// flag is passed in such a way that if next char is greator
					// than it will put TRUE IN FLAG
					lexicoGreatorWords(ros, osf + cc, flag || s.charAt(0) < s.charAt(i));
				} else {
					// nothing
					// skipping if next char is smaller than the very first char
				}
			}

		}

	}

	public static void equalSumArrayParts(int[] arr, int si, int sum1, int sum2, String osf1, String osf2) {
		if (si == arr.length) {
			if (sum1 == sum2) {
				System.out.println(osf1 + "and" + osf2);

			}
			return;
		}
		equalSumArrayParts(arr, si + 1, sum1 + arr[si], sum2, osf1 + arr[si] + ",", osf2);
		equalSumArrayParts(arr, si + 1, sum1, sum2 + arr[si], osf1, osf2 + arr[si] + ",");
	}

	public static void TargetSumArraySubsets(int[] arr, int si, String osf, int target) {
		if (target == 0) {
			System.out.println(osf);
			return;
		}
		if (si == arr.length) {
			return;
		}
		TargetSumArraySubsets(arr, si + 1, osf, target);
		TargetSumArraySubsets(arr, si + 1, osf + arr[si] + ",", target - arr[si]);

	}
}
