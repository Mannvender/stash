package Lecture23.stackNqueue;

import java.util.Scanner;

import Lecture22.Story_DynamicQueue.DynamicQueue;
import Lecture22.Story_DynamicStack.DynamicStack;

public class StackNewClient {

	public static void main(String[] args) throws Exception {
		// // TODO Auto-generated method stub
		// // StackUsingQueuePushE stack = new StackUsingQueuePushE();
		// StackUsingLL stack = new StackUsingLL();
		// Scanner scn = new Scanner(System.in);
		//
		// char choice = '\0';
		// do {
		// try {
		// System.out.println("*****M3NU********");
		// System.out.println(" 1 for push");
		// System.out.println(" 2 for pop");
		// System.out.println(" 3 for isEmpty");
		// System.out.println(" 4 for size");
		// System.out.println(" 5 for top");
		// System.out.println(" 6 for display");
		// System.out.println(" x to stop");
		//
		// choice = scn.next().charAt(0);
		// switch (choice) {
		// case '1':
		// System.out.println("Enter data");
		// stack.push(scn.nextInt());
		//
		// break;
		// case '2':
		// System.out.println(stack.pop());
		//
		// break;
		// case '4':
		// System.out.println(stack.size());
		//
		// break;
		// case '3':
		// System.out.println(stack.isEmpty());
		//
		// break;
		// case '5':
		// System.out.println(stack.top());
		//
		// break;
		// case '6':
		// stack.display();
		//
		// break;
		// case 'x':
		//
		// break;
		//
		// default:
		// break;
		// }
		// } catch (Exception ex) {
		// System.out.println(ex.getMessage());
		// }
		//
		// } while (choice != 'x');

		// StackUsingQueuePopE stack = new StackUsingQueuePopE();
		// stack.push(4);
		// stack.push(10);
		// stack.push(15);
		// stack.push(16);
		// stack.push(22);
		// stack.display();
		// System.out.println(stack.pop());
		// stack.display();
		// System.out.println(stack.top());
		DynamicQueue queue = new DynamicQueue();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		queue.display();
		reverseAQueue(queue);
		queue.display();

		StackUsingLL s = new StackUsingLL();
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		s.push(50);
		s.display();
		reverseAStack(s, new StackUsingLL(), 0);
		s.display();
	}

	public static void reverseAQueue(DynamicQueue q) throws Exception {
		if (q.isEmpty()) {
			return;
		}
		int temp = q.dequeue();
		reverseAQueue(q);
		q.enqueue(temp);

	}

	// if you try swapping both stack in the end it wont't change the stacks as
	// we are passing just references
	public static void reverseAStack(StackUsingLL s, StackUsingLL h, int floor) throws Exception {
		if (s.isEmpty()) {
			return;
		}
		int data = s.pop();

		reverseAStack(s, h, floor + 1);
		h.push(data);

		if (floor == 0) {
			while (!h.isEmpty()) {
				s.push(h.pop());
			}
		}

	}
}
