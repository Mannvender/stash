package Lecture12;

public class selectionSortRecurr {

	public static void main(String[] args) {
		int[] arr = { 2, 5, 6, 7, -4, 98, 0 };

		selecSort(arr, 0, 1);
		class6.arr1D.display(arr);

	}

	public static void selecSort(int[] arr, int si, int li) {
		if (si == arr.length) {
			return;
		}
		if (li == arr.length) {
			selecSort(arr, si + 1, si + 1 + 1);
			return;
		}

		if (arr[si] > arr[li]) {
			int temp = arr[si];
			arr[si] = arr[li];
			arr[li] = temp;
		}
		selecSort(arr, si, li + 1);

	}

}
