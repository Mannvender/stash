package Lecture12A;

import java.util.ArrayList;

public class DiceBoard {

	public static void main(String[] args) {
		System.out.println(getBoardPath(4, 0));
		System.out.println(countBoardPaths(4, 0));
	}

	public static ArrayList<String> getBoardPath(int size, int current) {
		// positive base case
		if (current == size) {
			ArrayList<String> base = new ArrayList<>();
			base.add("");
			return base;
		}
		// negative base case
		if (current > size) {
			ArrayList<String> base = new ArrayList<>();
			return base;
		}

		ArrayList<String> recResult = null, myResult = new ArrayList<>();
		for (int dice = 1; dice <= 6; dice++) {
			recResult = getBoardPath(size, current + dice);
			for (int j = 0; j < recResult.size(); j++) {
				myResult.add(dice + recResult.get(j));
			}
		}
		return myResult;

	}

	public static int countBoardPaths(int size, int current) {
		if (current == size) {
			return 1;
		}
		if (current > size) {
			return 0;
		}
		int recResult = 0, myResult = 0;

		for (int i = 1; i <= 6; i++) {
			recResult = countBoardPaths(size, current + i);
			myResult = myResult + recResult;
		}

		return myResult;
	}
}
