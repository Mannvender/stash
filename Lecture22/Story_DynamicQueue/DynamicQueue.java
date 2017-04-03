package Lecture22.Story_DynamicQueue;

import Lecture22.Story_Queue.Queue;

public class DynamicQueue extends Queue {

	public DynamicQueue(int capacity) {
		super.front = 0;
		this.data = new int[capacity];
	}

	public DynamicQueue() {
		this(DEFAULT_CAPACITY);
	}

	public void enqueue(int item) throws Exception {
		if (size() == this.data.length) {
			int temp[] = super.data;
			super.data = new int[2 * temp.length];
			for (int i = 0; i < this.size(); i++) {
				int ai = (super.front + i) % temp.length;
				super.data[i] = temp[ai];
			}
			super.front = 0;
		}
		super.enqueue(item);
	}

	public int dequeue() throws Exception {
		if (size() == this.data.length / 4) {
			int[] temp = super.data;
			super.data = new int[temp.length / 2];
			for (int i = 0; i < this.size(); i++) {
				int ai = (super.front + i) % temp.length;
				super.data[i] = temp[ai];
			}
			super.front = 0;
		}
		return super.dequeue();
	}
}
