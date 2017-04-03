package Lecture11;

public class deletethis {

	public static void main(String[] args) {
		// Part 1
		 PrintDecreasing(5);
		 System.out.println("*********************");

	}
	public static void PrintDecreasing(int num) {
		if (num <= 0) {
			return;
		}

		System.out.println(num);
		PrintDecreasing(num - 1);
	}
}
