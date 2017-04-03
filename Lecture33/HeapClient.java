package Lecture33;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class HeapClient {

	public static void main(String[] args) {
		students[] arr = new students[8];

		arr[0] = new students(300, 30, "a");
		arr[1] = new students(900, 90, "h");
		arr[2] = new students(500, 50, "c");
		arr[3] = new students(400, 40, "b");
		arr[4] = new students(800, 80, "e");
		arr[5] = new students(600, 60, "f");
		arr[6] = new students(700, 70, "d");
		arr[7] = new students(200, 20, "k");
		Heap<students> markheap = new Heap<>(arr, false);

		// markheap.add(new students(300, 30, "a"));
		// markheap.add(new students(900, 90, "h"));
		//
		// markheap.add(new students(500, 50, "c"));
		//
		// markheap.add(new students(400, 40, "b"));
		// markheap.add(new students(800, 80, "e"));
		// markheap.add(new students(600, 60, "f"));
		//
		// markheap.add(new students(700, 70, "d"));
		// markheap.add(new students(200, 20, "k"));
		while (!markheap.isEmpty()) {
			System.out.println(markheap.remove());
		}
		System.out.println("*****************");
		// markheap.display();

		Integer[] arr1 = { 10, 20, 80, 30, 14, 19, 22 };
		heapSort(arr1);
		for (Integer i : arr1) {
			System.out.println(i);
		}

	}

	// HEAPSORT
	public static void heapSort(Integer[] arr) {

		for (int i = arr.length / 2 - 1; i >= 0; i--) {
			downHeapify(arr, i, arr.length);
		}
		for (int i = 0; i < arr.length; i++) {
			Integer temp = arr[0];
			arr[0] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = temp;
			downHeapify(arr, 0, arr.length - 1 - i);

		}

	}

	private static void downHeapify(Integer[] arr, int pi, int lp) {
		// mi= max index
		int mi = pi;
		int rci = 2 * pi + 2;
		int lci = 2 * pi + 1;
		// isLarge here tells if rci is greater than mi or not
		if (rci < lp && arr[mi] < arr[rci]) {
			mi = rci;
		}
		if (lci < lp && arr[mi] < arr[lci]) {
			mi = lci;
		}
		if (mi != pi) {
			int temp = arr[mi];
			arr[mi] = arr[pi];
			arr[pi] = temp;
			downHeapify(arr, mi, lp);
		}

	}

	public static class students implements Comparable<students> {
		int marks;
		int rank;
		String name;

		public students(int marks, int rank, String name) {
			this.rank = rank;
			this.marks = marks;
			this.name = name;
		}

		@Override
		public int compareTo(students o) {
			// TODO Auto-generated method stub
			return this.marks - o.marks;
		}

		@Override
		public String toString() {
			return this.name + " M = " + this.marks + ",R = " + this.rank;
		}

	}

	public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists, int k) {
		Heap<Integer> heap = new Heap<>();
		for (int i = 0; i < k; i++) {

		}
		return null;

	}

	// try later
	public static int Median(Integer[] arr) {
		Heap<Integer> max = new Heap<>(arr, false);
		Heap<Integer> min = new Heap<>(arr, true);
		for (int i = 0; i < min.size(); i++) {

		}
		Integer maxval = max.remove();
		Integer minval = min.remove();
		return 0;

	}
}
