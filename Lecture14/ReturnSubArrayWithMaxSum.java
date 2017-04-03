package Lecture14;

public class ReturnSubArrayWithMaxSum {

	public static void main(String[] args) {
		int[] arr = { -18, 1, 3, 5, -5, 6 };
		// class6.arr1D.display(fun(arr, 0));
		funIteration(arr);
	}

	// fix it
	public static int[] fun(int[] arr, int si) {
		if (si == arr.length) {
			int[] base = null;
			return base;
		}
		int[] rcurResult = null;
		rcurResult = fun(arr, si + 1);
		int value = 0;
		for (int i = 0; i < rcurResult.length; i++) {
			value = value + rcurResult[i];
		}
		int newvalue = 0;
		int k = 0;
		int saveli = 0;
		int savesi = 0;
		boolean change = false;
		for (int j = 0; j < arr.length; j++) {
			for (k = 0; k <= j; k++) {
				newvalue = newvalue + arr[k];

			}
			if (newvalue > value) {
				value = newvalue;
				saveli = k;
				savesi = j;
				change = true;
			}
		}
		if (change) {
			int[] indices = { savesi, saveli };
			return indices;
		} else {
			return rcurResult;
		}

	}
	//working code below
	public static void funIteration(int[] arr) {
		int maxsum = Integer.MIN_VALUE;
		int maxsi = 0;
		int maxli = 0;

		for (int si = 0; si < arr.length; si++) {
			int sum = 0;
			for (int li = si; li < arr.length; li++) {
				sum = sum + arr[li];
				if (sum > maxsum) {
					maxsum = sum;
					maxsi = si;
					maxli = li;
				}
			}
		}
		System.out.println(maxsi + "," + maxli);

	}
}
