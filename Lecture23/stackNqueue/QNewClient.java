package Lecture23.stackNqueue;

import java.util.Stack;

import Lecture22.Story_DynamicQueue.DynamicQueue;
import Lecture22.Story_DynamicStack.DynamicStack;

public class QNewClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		QUsingStacksEnqEff q = new QUsingStacksEnqEff();
		q.enqueue(5);
		q.enqueue(6);
		q.enqueue(7);
		q.enqueue(8);
		q.display();
		q.dequeue();
		q.display();
		System.out.println(q.size());
		q.dequeue();
		q.dequeue();
		q.dequeue();
		System.out.println(q.isEmpty());

		DynamicQueue s = new DynamicQueue();
		s.enqueue(5);
		s.enqueue(10);
		s.enqueue(15);
		s.enqueue(20);
		s.display();
		reverseQueue(s);
		s.dequeue();
		s.display();

		System.out.println(duplicateParenthesis("((a+b)+(c+d))"));

	}

	public static void reverseQueue(DynamicQueue q) throws Exception {
		if (q.isEmpty()) {
			return;
		}
		int temp = q.dequeue();
		reverseQueue(q);
		q.enqueue(temp);

	}

	// not working for duplicates but working fine for useless parenthesis
	public static boolean duplicateParenthesis(String input) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < input.length(); i++) {
			Character cc = input.charAt(i);
			if (cc.equals(')')) {
				Character pop = stack.pop();
				if (pop.equals('(')) {
					return true;
				}
				while (!pop.equals('(')) {
					pop = stack.pop();
				}
			} else {
				stack.push(cc);
			}

		}

		return false;

	}

}
