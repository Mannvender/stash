package Lecture31;

public class Generics {

	public static void main(String[] args) {
		Cars[] carr = new Cars[5];
		carr[0] = new Cars(100, 1000);
		carr[1] = new Cars(200, 2000);
		carr[2] = new Cars(300, 3000);
		carr[3] = new Cars(250, 3100);
		carr[4] = new Cars(50, 1200);
		bubbleSort(carr);
		for (Cars cars : carr) {
			System.out.println(cars);
		}

	}

	public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
		int counter = 1;
		while (counter < arr.length - 1) {
			for (int i = 0; i < arr.length - counter; i++) {
				if (arr[i].compareTo(arr[i + 1]) < 0) {
					T temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;

				}

			}
			counter++;
		}

	}

}
