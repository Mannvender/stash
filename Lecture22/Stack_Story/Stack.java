package Lecture22.Stack_Story;

public class Stack {
	protected int[] data;
	private int tos;
	public static final int DEFAULT_CAPACITY = 10;

	public Stack(int capacity) {
		this.data = new int[capacity];
		this.tos = -1;
	}

	public Stack() {
		this(DEFAULT_CAPACITY);
	}

	public int size() {
		int rv = this.tos + 1;
		return rv;

	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public void push(int item) throws Exception {
		if (this.size() == this.data.length) {
			throw new Exception("Stack is full");
		}
		tos++;
		this.data[tos] = item;
		

	}

	public int pop() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("Stack is empty");
		}
		int rv = this.data[tos];
		tos--;
		return rv;
	}

	public int top() {
		if (this.size() == 0) {
			new Exception("Stack is empty");
		}
		int rv = this.data[tos];
		return rv;
	}

	public void display() {
		for (int i = this.tos; i >= 0; i--) {
			System.out.print(this.data[i] + ",");
		}
		System.out.println();
		System.out.println("**********************");
	}

}
