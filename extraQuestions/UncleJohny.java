package extraQuestions;

import java.util.Scanner;

public class UncleJohny {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();
		for (int i = 0; i < num; i++) {
			int numH = scn.nextInt();
			int[] songs = new int[numH];
			for (int j = 0; j < songs.length; j++) {
				songs[j] = scn.nextInt();
			}
			int K = scn.nextInt();
			int KValue = songs[K-1];
			songs = MergeSort(songs, 0, songs.length - 1);

			for (int k = 0; k < songs.length; k++) {
				if (songs[k] == KValue) {
					System.out.println(k+1);
					break;
				}
			}

		}
	}

	public static int[] Merge(int[] one, int[] two) {
		int[] retVal = new int[one.length + two.length];
		int i = 0, j = 0, k = 0;
		while (i < one.length && j < two.length) {
			if (one[i] < two[j]) {
				retVal[k] = one[i];
				i++;
				k++;
			} else {
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
