package Lecture17;

public class polyTimeSpace {

	public static void main(String[] args) {
		// System.out.println(poly(3, 4));
		// **********
		// String s = "abbcbabc";
		// System.out.println(countPalindromeicSS(s));
		// **********
		 printPrimesSoE(50);
		// ***********
		// int n = 46;
		// System.out.println(fiboBetter(n, new int[n + 1]));
		// ***********
		//int n = 10;
		//System.out.println(countBoardPathsBetter(n, 0, new int[n + 1]));

	}

	// complexity O(n)
	public static int poly(int x, int n) {
		int retVal = 0;

		int xpow = x;
		while (n > 0) {
			retVal = retVal + xpow * n;
			n--;
			xpow = xpow * x;
		}
		return retVal;
	}

	// complexity O(n^2)
	public static int countPalindromeicSS(String s) {

		int retVal = 0;
		// for odd substrings;
		for (int axis = 0; axis < s.length(); axis++) {
			for (int orbit = 0; axis + orbit < s.length() && axis - orbit > -1; orbit++) {
				if (s.charAt(axis - orbit) == s.charAt(axis + orbit)) {
					retVal++;
				} else {
					break;
				}

			}
		}
		// for even substrings
		for (int axis = 1; axis < s.length(); axis++) {
			for (int orbit = 1; axis + orbit - 1 < s.length() && axis - orbit > -1; orbit++) {
				if (s.charAt(axis - orbit) == s.charAt(axis + orbit - 1)) {
					retVal++;
				} else {
					break;
				}

			}
		}

		return retVal;

	}

	// complexity O(nlog(n))or can say O(nlog(log(n)))
	public static void printPrimesSoE(int n) {
		boolean[] nums = new boolean[n + 1];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = true;
		}

		for (int divisor = 2; divisor * divisor <= n; divisor++) {
			// another solution >add a new "if(nums[div]" HERE
			for (int multiple = 2; divisor * multiple <= n; multiple++) {
				nums[divisor * multiple] = false;
			}
		}
		for (int i = 2; i < nums.length; i++) {
			if (nums[i]) {
				System.out.println(i);
			}
		}
	}

	// complexity nearly equal to 2n-1 ie O(n)
	public static int fiboBetter(int n, int[] storage) {
		if (n == 1 || n == 0) {
			return n;
		}
		if (storage[n] != 0) {
			return storage[n];
		}
		int fibnm1 = fiboBetter(n - 1, storage);
		int fibnm2 = fiboBetter(n - 2, storage);
		int fibo = fibnm1 + fibnm2;
		storage[n] = fibo;
		return fibo;
	}

	public static int countBoardPathsBetter(int size, int current, int[] storage) {
		if (current == size) {
			return 1;
		}
		if (current > size) {
			return 0;
		}
		if (storage[current] != 0) {
			return storage[current];
		}
		int recResult = 0, myResult = 0;

		for (int i = 1; i <= 6; i++) {
			recResult = countBoardPathsBetter(size, current + i, storage);
			myResult = myResult + recResult;
		}
		storage[current] = myResult;
		return myResult;
	}
}
