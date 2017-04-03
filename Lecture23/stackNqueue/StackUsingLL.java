package Lecture23.stackNqueue;

import Lecture25.LinkedList;

public class StackUsingLL {
	LinkedList list;

	public StackUsingLL() {
		this.list = new LinkedList();
	}

	public void push(int item) throws Exception {
		try {
			list.addFirst(item);
		} catch (Exception ex) {
			throw new Exception("stack is full");
		}

	}

	public int pop() throws Exception {
		try {
			int rv = this.list.removeFirst();
			return rv;
		} catch (Exception ex) {
			throw new Exception("list is empty");

		}

	}

	public int top() throws Exception {
		return this.list.getfirst();
	}

	public void display() throws Exception {
		this.list.display();

	}

	public int size() {
		return this.list.size();
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}
}
