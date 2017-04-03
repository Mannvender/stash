package Lecture19;

import java.util.Random;

public class knapSack {

	public static void main(String[] args) {
		int n=30;
		int[] rndmVals=new int[n];
		int[] rndmWhts=new int[n];
		Random rndm=new Random();
		for(int i=0;i<n;i++){
			rndmVals[i]=rndm.nextInt(100);
			rndmWhts[i]=rndm.nextInt(15);
		}
		int[] vals = { 6, 20, 22, 3, 8, 1, 5, 3, 4, 5, 6, 7, 8, 7, 6, 6, 5, };
		int[] weights = { 2, 6, 21, 4, 9, 8, 4, 2, 1, 3, 2, 4, 7, 5, 8, 9, 3 };
		int tw = 300;
		Lecture18.CountMazePathBetter.init();
		System.out.println(ks(rndmVals, rndmWhts, tw, 0));
		System.out.println("ks took -- " + Lecture18.CountMazePathBetter.duration());
		// *************
		Lecture18.CountMazePathBetter.init();
		System.out.println(ksBetter(rndmVals, rndmWhts, tw, 0, new int[tw + 1][rndmVals.length + 1]));
		System.out.println("ksBetter took -- " + Lecture18.CountMazePathBetter.duration());
	}

	public static int ks(int[] vals, int[] weights, int trgtwt, int si) {
		if (si == vals.length) {
			return 0;
		}
		int rv = 0;

		if (weights[si] <= trgtwt) {
			int f1 = vals[si] + ks(vals, weights, trgtwt - weights[si], si + 1);
			int f2 = ks(vals, weights, trgtwt, si + 1);
			rv = Math.max(f2, f1);
		} else {
			rv = ks(vals, weights, trgtwt, si + 1);
		}

		return rv;
	}

	public static int ksBetter(int[] vals, int[] weights, int trgtwt, int si, int[][] storage) {
		if (si == vals.length) {
			return 0;
		}
		if (storage[trgtwt][si] != 0) {
			return storage[trgtwt][si];
		}
		int rv = 0;

		if (weights[si] <= trgtwt) {
			int f1 = vals[si] + ksBetter(vals, weights, trgtwt - weights[si], si + 1, storage);
			int f2 = ksBetter(vals, weights, trgtwt, si + 1, storage);
			rv = Math.max(f2, f1);
		} else {
			rv = ksBetter(vals, weights, trgtwt, si + 1, storage);
		}
		storage[trgtwt][si] = rv;
		return rv;
	}

}
