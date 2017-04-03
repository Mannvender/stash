package Lecture20;

public class countbordPathBtr {

	public static void main(String[] args) {
		// System.out.println(fiboBtr2(43, new int[2]));
		System.out.println(cBPathBtr2(0, 10)[0]);
		//System.out.println(countBoardpathIterative(0, 10));
	}

	public static int fiboBtr2(int n, int[] storage) {
		if (n == 1) {
			storage[0] = 1;
			storage[1] = 0;
			return 1;
		}
		int fiboN1 = fiboBtr2(n - 1, storage);
		int fiboN2 = storage[1];
		int fibN = fiboN1 + fiboN2;
		storage[0] = fibN;
		storage[1] = fiboN1;
		return fibN;
	}
//O(n)
	public static int[] cBPathBtr2(int current, int size) {
		if (current == size) {
			int[] base = new int[6];
			base[0] = 1;
			return base;
		}

		int[] RecResult = cBPathBtr2(current + 1, size);
		int sum = 0;
		for (int i = 0; i < RecResult.length; i++) {
			sum = sum + RecResult[i];
		}
		int[] MyResult = new int[6];
		MyResult[0] = sum;
		for (int j = 1; j < RecResult.length; j++) {
			MyResult[j] = RecResult[j - 1];
		}

		return MyResult;
	}

	public static int countBoardpathIterative(int current, int size) {

		int[] arr = new int[6];
		arr[0] = 1;
		for (int i = size; i > 0; i--) {
			int sum = 0;
			for (int j = 5; j >= 0; j--) {
				sum = sum + arr[j];
				if (j != 0) {
					arr[j] = arr[j - 1]; //shifting five elements
				} else {
					arr[0] = sum;//adding new element i.e. sum of all elements of last arr
				}
			}
		}

		return arr[0];
	}
}
