package Lecture14;

public class lexicoOrder {

	public static void main(String[] args) {
		lexico(1000, 1);
		System.out.println("*************");
		// lexicoClass(1000, 0);
	}

	public static void lexico(int n, int current) {
		if (current > n) {
			return;
		}

		System.out.println(current);

		lexico(n, current * 10);

		if (current % 10 != 9) {
			lexico(n, current + 1);
		}

	}

	public static void lexicoClass(int n, int current) {
		if (current == n) {
			System.out.println(current);
			return;

		}
		if (current > n) {
			return;
		}
		for (int i = (current == 0 ? 1 : 0); i <= 9; i++) {
			lexico(n, current * 10 + i);
		}
		System.out.println(current);
	}

}
