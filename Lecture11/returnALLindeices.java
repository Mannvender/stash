package Lecture11;

public class returnALLindeices {
	public static int count = 0;
	public static int i = 0;

	public static void main(String[] args) {
		int[] arr = { 1, 5, 7, 5, 6, 7, 8, 5, 5, 6, 5 };
		// class6.arr1D.display(returnAllIndex(arr, 5, 0));
		class6.arr1D.display(smartMethod(arr, 5, 0, 0));
	}

	public static int[] smartMethod(int[] arr, int num, int si, int counter) {
		if (si == arr.length) {
			int[] retVal = new int[counter];
			return retVal;
		}

		if (arr[si] == num) {
			counter++;
		}
		int[] retVal = smartMethod(arr, num, si + 1, counter);

		if (arr[si] == num) {
			retVal[counter - 1] = si;

		}
		return retVal;
	}

	public static int[] returnAllIndex(int[] arr, int num, int si) {
		if (si == arr.length) {
			int[] retVal = new int[count];
			return retVal;
		}

		if (arr[si] == num) {
			count++;
		}
		int[] retVal = returnAllIndex(arr, num, si + 1);

		if (arr[si] != num) {
			return retVal;
		} else {
			retVal[i] = si;
			i++;
			return retVal;

		}

	}

}
