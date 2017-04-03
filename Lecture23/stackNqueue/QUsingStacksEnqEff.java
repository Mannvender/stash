package Lecture23.stackNqueue;

import Lecture22.Story_DynamicStack.DynamicStack;

// enqueue efficient
public class QUsingStacksEnqEff {
	private DynamicStack primary;
	private DynamicStack secondary;

	public QUsingStacksEnqEff() {
		this.primary = new DynamicStack();
		this.secondary = new DynamicStack();
	}

	public int size() {
		return this.primary.size();
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void enqueue(int item) throws Exception {
		this.primary.push(item);
	}

	public int front() throws Exception {
		while (this.primary.size() != 1) {
			int temp = this.primary.pop();
			this.secondary.push(temp);
		}
		int rv = this.primary.pop();
		this.secondary.push(rv);
		while (!this.secondary.isEmpty()) {
			int temp = this.secondary.pop();
			this.primary.push(temp);
		}
		return rv;
	}

	public int dequeue() throws Exception {
		while (this.primary.size() != 1) {
			int temp = this.primary.pop();
			this.secondary.push(temp);
		}
		int rv = this.primary.pop();
		while (!this.secondary.isEmpty()) {
			int temp = this.secondary.pop();
			this.primary.push(temp);
		}
		return rv;
	}

	// display is not so right ,maybe fix it
	public void display() {
		this.primary.display();
		System.out.println("END");
		System.out.println("**************************");
	}
}
