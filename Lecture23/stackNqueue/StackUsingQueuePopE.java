package Lecture23.stackNqueue;

import Lecture22.Story_DynamicQueue.DynamicQueue;

public class StackUsingQueuePopE {
	DynamicQueue primaryQueue;
	DynamicQueue secondaryQueue;

	public StackUsingQueuePopE() {
		this.primaryQueue = new DynamicQueue();
		this.secondaryQueue = new DynamicQueue();
	}

	public void push(int item) throws Exception {
		this.secondaryQueue.enqueue(item);
		while (!this.primaryQueue.isEmpty()) {
			this.secondaryQueue.enqueue(this.primaryQueue.dequeue());
		}
		DynamicQueue temp = this.secondaryQueue;
		this.secondaryQueue = this.primaryQueue;
		this.primaryQueue = temp;

	}

	public int pop() throws Exception {
		return this.primaryQueue.dequeue();

	}

	public int top() throws Exception {
		return this.primaryQueue.front();
	}

	public void display() throws Exception {
		this.displayHelp();
		System.out.println("END");
		System.out.println("*********");

	}

	private void displayHelp() throws Exception {
		this.primaryQueue.display();
	}

	public int size() {
		return this.primaryQueue.size();
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}
}
