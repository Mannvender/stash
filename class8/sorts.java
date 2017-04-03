package class8;

public class sorts {

	public static void main(String[] args) {
		// int[] arr = { 5, 12, 3, 8, 19 };
		int[] arr = { 1, 2, 3, 1, 2, 4, 1 };

		// bubbleSort(arr);
		 selectionSort(arr);
		//insertionSort(arr);
		class6.arr1D.display(arr);
		System.out.println("**********");
		System.out.println(binarySearch(arr, 5));
		System.out.println(binarySearch(arr, 19));
		System.out.println(binarySearch(arr, 0));
		System.out.println(binarySearch(arr, 20));
		System.out.println(binarySearch(arr, 10));
	}

	public static int binarySearch(int[] arr, int data) {
		// works on sorted array
		int left = 0, right = arr.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (data > arr[mid]) {
				left = mid + 1;
			}

			else if (data < arr[mid]) {
				right = mid - 1;
			} else {
				return mid;
			}

		}
		return -1;
	}

	public static void insertionSort(int[] arr) {
		int counter = 1;
		while (counter <= arr.length - 1) {
			for (int i = counter; i > 0; i--) {
				if (arr[i] < arr[i - 1]) {
					swap(arr, i, i - 1);
				} else {
					break;
				}
			}
			counter++;
		}
	}

	public static void bubbleSort(int[] arr) {
		int counter = 1;
		while (counter < arr.length - 1) {
			for (int i = 0; i < arr.length - counter; i++) {
				if (arr[i] > arr[i + 1]) {
					swap(arr, i, i + 1);

				}

			}
			counter++;
		}

	}

	public static void selectionSort(int[] arr) {
		int counter = 1;
		while (counter <= arr.length - 1) {
			for (int i = counter; i < arr.length; i++) {
				if (arr[i] < arr[counter - 1]) {
					swap(arr, i, counter - 1);

				}

			}
			counter++;
		}

	}

	public static void swap(int arr[], int i, int j) {

		int temp = 0;
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
