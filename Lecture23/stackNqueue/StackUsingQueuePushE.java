package Lecture23.stackNqueue;

import Lecture22.Story_DynamicQueue.DynamicQueue;

public class StackUsingQueuePushE {

	private DynamicQueue primaryQueue;
	private DynamicQueue secondaryQueue;

	public StackUsingQueuePushE() {
		this.primaryQueue = new DynamicQueue();
		this.secondaryQueue = new DynamicQueue();

	}

	public void push(int data) throws Exception {
		this.primaryQueue.enqueue(data);
	}

	public int pop() throws Exception {

		int rv = 0;
		while (this.primaryQueue.size() != 1) {
			int temp = this.primaryQueue.dequeue();
			this.secondaryQueue.enqueue(temp);
		}
		rv = this.primaryQueue.dequeue();
		DynamicQueue temp = this.secondaryQueue;
		this.secondaryQueue = this.primaryQueue;
		this.primaryQueue = temp;

		return rv;

	}

	public int top() throws Exception {

		int rv = 0;
		while (this.primaryQueue.size() != 1) {
			int temp = this.primaryQueue.dequeue();
			this.secondaryQueue.enqueue(temp);
		}
		rv = this.primaryQueue.dequeue();
		this.secondaryQueue.enqueue(rv);
		DynamicQueue temp = this.secondaryQueue;
		this.secondaryQueue = this.primaryQueue;
		this.primaryQueue = temp;

		return rv;

	}

	public int size() {
		return this.primaryQueue.size();
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void display() throws Exception {
		this.displayHelp();
		System.out.println("END");
		System.out.println("********");
		DynamicQueue temp = this.secondaryQueue;
		this.secondaryQueue = this.primaryQueue;
		this.primaryQueue = temp;
	}

	private void displayHelp() throws Exception {
		if (this.primaryQueue.isEmpty()) {
			return;
		}
		int temp = this.primaryQueue.dequeue();
		this.secondaryQueue.enqueue(temp);

		this.displayHelp();

		System.out.print(temp + "=>");
	}

}
