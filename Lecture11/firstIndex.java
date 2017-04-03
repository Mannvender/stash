package Lecture11;

public class firstIndex {

	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 6, 7 };

		System.out.println(firstindex(arr, 5, 0));
	}

	public static int firstindex(int[] arr, int num, int si) {

		if (si == arr.length) {
			return -1;
		}
		if (arr[si] == num) {
			return si;
		}
		int retVal = firstindex(arr, num, si + 1);

		return retVal;
	}

}
