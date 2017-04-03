package Lecture22.Story_DynamicStack;

import Lecture22.Stack_Story.Stack;

public class DynamicStack extends Stack {
	public DynamicStack(int capacity) {
		super(capacity);
	}

	public DynamicStack() {
		this(DEFAULT_CAPACITY);
	}

	public void push(int item) {
		if (this.size() == super.data.length) {
			int[] temp = super.data;
			data = new int[super.data.length * 2];
			for (int i = 0; i < temp.length; i++) {
				super.data[i] = temp[i];
			}
		}
		try {
			super.push(item);
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

	public int pop() {

		try {
			if (this.size() == (super.data.length) / 4) {
				int[] temp = super.data;
				super.data = new int[(super.data.length) / 2];
				for (int i = 0; i < super.data.length; i++) {
					super.data[i] = temp[i];
				}
			}
			int rv = super.pop();
			return rv;
		} catch (Exception ex) {
			System.out.println(ex);
			return 1;
		}

	}

}
