package Lecture12A;

import java.util.ArrayList;

public class MazePath {

	public static void main(String[] args) {
		// System.out.println(countMazepath(3, 3, 0, 0));
		// System.out.println(countMazepathWithDiag(2, 2, 0, 0));
		// System.out.println(countMazepathWithDiagSpecific(3, 3, 0, 0));
		// System.out.println(returnMazePath(2, 2, 0, 0));
		// PrintMazePaths(2, 2, 0, 0, "");
		System.out.println(returnMazePathWithDiag(2, 2, 0, 0));
		System.out.println("***");
		PrintMazePathsWithDiag(2, 2, 0, 0, "");
	}

	public static int countMazepath(int endrow, int endcol, int currentrow, int currentcol) {
		if (currentcol == endcol && currentrow == endrow) {
			return 1;
		}
		if (currentcol > endcol || currentrow > endrow) {
			return 0;
		}

		int myResult = 0, recResult = 0;
		int HResult = countMazepath(endrow, endcol, currentrow + 1, currentcol);
		int VResult = countMazepath(endrow, endcol, currentrow, currentcol + 1);
		myResult = HResult + VResult;

		return myResult;

	}

	public static int countMazepathWithDiag(int endrow, int endcol, int currentrow, int currentcol) {
		if (currentcol == endcol && currentrow == endrow) {
			return 1;
		}
		if (currentcol > endcol || currentrow > endrow) {
			return 0;
		}

		int myResult = 0, recResult = 0;
		int HResult = countMazepathWithDiag(endrow, endcol, currentrow + 1, currentcol);
		int VResult = countMazepathWithDiag(endrow, endcol, currentrow, currentcol + 1);
		int DResult = countMazepathWithDiag(endrow, endcol, currentrow + 1, currentcol + 1);
		myResult = HResult + VResult + DResult;

		return myResult;

	}

	public static int countMazepathWithDiagSpecific(int endrow, int endcol, int currentrow, int currentcol) {
		if (currentcol == endcol && currentrow == endrow) {
			return 1;
		}
		if (currentcol > endcol || currentrow > endrow) {
			return 0;
		}

		int myResult = 0;
		int DResult = 0;
		int HResult = countMazepathWithDiagSpecific(endrow, endcol, currentrow + 1, currentcol);
		int VResult = countMazepathWithDiagSpecific(endrow, endcol, currentrow, currentcol + 1);
		if (currentcol == currentrow || currentcol + currentrow == endcol) {
			DResult = countMazepathWithDiagSpecific(endrow, endcol, currentrow + 1, currentcol + 1);
		}
		myResult = HResult + VResult + DResult;

		return myResult;

	}

	public static ArrayList<String> returnMazePath(int endrow, int endcol, int currentrow, int currentcol) {
		if (currentcol == endcol && currentrow == endrow) {
			ArrayList<String> base = new ArrayList<>();
			base.add("");
			return base;
		}
		if (currentcol > endcol || currentrow > endrow) {
			ArrayList<String> base = new ArrayList<>();
			return base;
		}

		ArrayList<String> myResult = new ArrayList<>();
		ArrayList<String> HResult, VResult = null;
		HResult = returnMazePath(endrow, endcol, currentrow + 1, currentcol);
		for (int i = 0; i < HResult.size(); i++) {
			String my = HResult.get(i);
			myResult.add("H" + my);
		}
		VResult = returnMazePath(endrow, endcol, currentrow, currentcol + 1);
		for (int i = 0; i < VResult.size(); i++) {
			String my = VResult.get(i);
			myResult.add("V" + my);
		}

		return myResult;

	}

	public static void PrintMazePaths(int endrow, int endcol, int currentrow, int currentcol, String osf) {
		if (currentcol == endcol && currentrow == endrow) {
			System.out.println(osf);
			return;
		}
		if (currentcol > endcol || currentrow > endrow) {
			return;
		}
		PrintMazePaths(endrow, endcol, currentrow + 1, currentcol, "H" + osf);
		PrintMazePaths(endrow, endcol, currentrow, currentcol + 1, "V" + osf);

	}

	public static ArrayList<String> returnMazePathWithDiag(int endrow, int endcol, int currentrow, int currentcol) {
		if (currentcol == endcol && currentrow == endrow) {
			ArrayList<String> base = new ArrayList<>();
			base.add("");
			return base;
		}
		if (currentcol > endcol || currentrow > endrow) {
			ArrayList<String> base = new ArrayList<>();
			return base;
		}

		ArrayList<String> myResult = new ArrayList<>();
		ArrayList<String> HResult, VResult, DResult = null;
		HResult = returnMazePathWithDiag(endrow, endcol, currentrow + 1, currentcol);
		for (int i = 0; i < HResult.size(); i++) {
			String my = HResult.get(i);
			myResult.add("H" + my);
		}
		VResult = returnMazePathWithDiag(endrow, endcol, currentrow, currentcol + 1);
		for (int i = 0; i < VResult.size(); i++) {
			String my = VResult.get(i);
			myResult.add("V" + my);
		}
		DResult = returnMazePathWithDiag(endrow, endcol, currentrow + 1, currentcol + 1);
		for (int i = 0; i < DResult.size(); i++) {
			String my = DResult.get(i);
			myResult.add("D" + my);
		}
		return myResult;

	}

	public static void PrintMazePathsWithDiag(int endrow, int endcol, int currentrow, int currentcol, String osf) {
		if (currentcol == endcol && currentrow == endrow) {
			System.out.println(osf);
			return;
		}
		if (currentcol > endcol || currentrow > endrow) {
			return;
		}
		PrintMazePathsWithDiag(endrow, endcol, currentrow + 1, currentcol, "H" + osf);
		PrintMazePathsWithDiag(endrow, endcol, currentrow, currentcol + 1, "V" + osf);
		PrintMazePathsWithDiag(endrow, endcol, currentrow + 1, currentcol + 1, "D" + osf);

	}
}
