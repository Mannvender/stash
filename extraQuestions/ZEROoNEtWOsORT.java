package extraQuestions;

public class ZEROoNEtWOsORT {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 1, 2, 0, 1, 0, 1, 2 };

		fun(arr);
		class6.arr1D.display(arr);
	}

	public static void fun(int[] arr) {
		int lo = 0;
		int hi = arr.length - 1;
		int mid = 0;
		while (mid <= hi) {

			switch (arr[mid]) {
			case 0:
				int temp = arr[mid];
				arr[mid] = arr[lo];
				arr[lo] = temp;
				lo++;
				mid++;
				break;
			case 1:
				mid++;

				break;

			case 2:
				int temp2 = arr[mid];
				arr[mid] = arr[hi];
				arr[hi] = temp2;
				hi--;
				break;

			default:
				break;
			}
		}

	}

}
