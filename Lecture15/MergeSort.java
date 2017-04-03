package Lecture15;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = { 15, 2, 6, 1, 18 };
		int[] arr1 = MergeSort(arr, 0, arr.length - 1);
		class6.arr1D.display(arr1);
		//int[] try1={2,15};
		//int[] try2={1,6,18};
		//class6.arr1D.display(Merge(try1, try2));
	}

	public static int[] Merge(int[] one, int[] two) {
		int[] retVal = new int[one.length + two.length];
		int i = 0, j = 0, k = 0;
		while (i < one.length && j < two.length) {
			if (one[i] < two[j]) {
				retVal[k] = one[i];
				i++;
				k++;
			}
			else{
				retVal[k] = two[j];
				j++;
				k++;
			}

		}
		while (i < one.length) {
			retVal[k] = one[i];
			k++;
			i++;
		}
		while (j < two.length) {
			retVal[k] = two[j];
			k++;
			j++;
		}

		return retVal;
	}

	public static int[] MergeSort(int[] arr, int lo, int hi) {

		if (lo == hi) {
			int[] base = new int[1];
			base[0] = arr[lo];
			return base;
		}

		int mid = (hi + lo) / 2;
		int[] fhalf = MergeSort(arr, lo, mid);
		int[] shalf = MergeSort(arr, mid + 1, hi);
		int[] complete = Merge(fhalf, shalf);

		return complete;

	}
}
