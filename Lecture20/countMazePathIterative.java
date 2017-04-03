package Lecture20;

public class countMazePathIterative {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fun(3, 3)[0][0]);
	}

	public static int[][] fun(int endRow, int endCol) {
		int[][] arr = new int[endRow + 1][endCol + 1];
		arr[endRow][endCol] = 1;

		for (int i = endRow; i >= 0; i--) {
			for (int j = endCol; j >= 0; j--) {

				if (j + 1 <= endCol) {
					arr[i][j] = arr[i][j] + arr[i][j + 1];
				}
				if (i + 1 <= endRow) {
					arr[i][j] = arr[i][j] + arr[i + 1][j];
				}
			}
		}

		return arr;
	}

}
