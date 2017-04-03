package Lecture18;

public class CountMazePathBetter {
	public static long startTime = 0;
	public static long endTime = 0;

	public static void main(String[] args) {
		int n = 20;
		init();
		System.out.println(Lecture12A.MazePath.countMazepath(n, n, 0, 0));
		// System.out.println(countMazepathbtr(n, n, 0, 0, new int[n + 1][n +
		// 1]));
		System.out.println(duration());
	}

	public static int countMazepathbtr(int endrow, int endcol, int currentrow, int currentcol, int[][] storage) {
		if (currentcol == endcol && currentrow == endrow) {
			return 1;
		}
		if (currentcol > endcol || currentrow > endrow) {
			return 0;
		}
		if (storage[currentrow][currentcol] != 0) {
			return storage[currentrow][currentcol];
		}

		int myResult = 0;
		int HResult = countMazepathbtr(endrow, endcol, currentrow + 1, currentcol, storage);
		int VResult = countMazepathbtr(endrow, endcol, currentrow, currentcol + 1, storage);
		myResult = HResult + VResult;
		storage[currentrow][currentcol] = myResult;

		return myResult;

	}

	public static long duration() {
		endTime = System.currentTimeMillis();
		return endTime - startTime;
	}

	public static void init() {
		startTime = System.currentTimeMillis();
	}

}
