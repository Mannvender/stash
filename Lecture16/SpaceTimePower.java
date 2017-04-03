package Lecture16;

public class SpaceTimePower {

	public static void main(String[] args) {
		System.out.println(power(3, 2));
	}

	public static int power(int x, int n) {
		if (n == 1) {
			return x;
		}
		int retVal = 0;
		int xrecur = power(x, n / 2);
		if (n % 2 == 1) {
			retVal = xrecur * xrecur * x;
		} else {
			retVal = xrecur * xrecur;
		}
		return retVal;

	}

}
