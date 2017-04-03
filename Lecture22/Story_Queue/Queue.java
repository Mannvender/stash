package Lecture22.Story_Queue;

public class Queue {
	protected int front;
	private int size;
	protected int[] data;
	public static final int DEFAULT_CAPACITY = 10;

	public Queue(int capacity) {
		this.front = 0;
		this.data = new int[capacity];
	}

	public Queue() {
		this(DEFAULT_CAPACITY);
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public void enqueue(int item) throws Exception {
		if (size() == this.data.length) {
			throw new Exception("Queue is full");
		}
		this.data[(this.front + this.size) % this.data.length] = item;
		this.size++;
	}

	public int front() throws Exception {
		if (isEmpty()) {
			throw new Exception("Queue is empty");
		}
		return this.data[this.front];
	}

	public int dequeue() throws Exception {
		if (isEmpty()) {
			throw new Exception("Queue is empty");
		}
		int rv = this.data[this.front];
		this.size--;
		this.front = (this.front + 1) % this.data.length;
		return rv;
	}

	public void display() {
		for (int i = 0; i < this.size; i++) {
			int ai = (this.front + i) % this.data.length;
			System.out.print(this.data[ai] + ", ");
		}
		System.out.println("END");
		System.out.println("**************************");
	}
}
