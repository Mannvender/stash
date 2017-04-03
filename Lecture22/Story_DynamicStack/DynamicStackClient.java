package Lecture22.Story_DynamicStack;

import Lecture22.Stack_Story.Stack;

public class DynamicStackClient {
	public static void main(String[] args) throws Exception {
		try {
			Stack st = new DynamicStack(5);
			for (int i = 0; i < 5; i++) {
				st.push(5 - i);
				displayStackInfo(st);
			}
			System.out.println("point 1");
			st.push(89);
			displayStackInfo(st);
			System.out.println("point 2");
			while (!st.isEmpty()) {
				System.out.println(st.top());
				System.out.println(st.pop());
				displayStackInfo(st);
			}
			System.out.println("point 3");
			st.pop();
			displayStackInfo(st);
			System.out.println("point 4");

		} catch (Exception ex) {
			System.out.println(ex);
			System.out.println("bye");
		}
	}

	public static void displayStackInfo(Stack st) {
		System.out.println("size = " + st.size());
		System.out.println("is it Empty ? " + st.isEmpty());
		st.display();
	}
}
