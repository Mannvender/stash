package Lecture25;

import Lecture25.LinkedList.Node;

public class AsgnLL {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		LinkedList list = new LinkedList();

		list.addLast(0);
		list.addLast(2);
		list.addLast(4);
		// list.display();
		System.out.println("*********");
		// SwapElementsLL(list, 4, 0);
		// RmvDupliSortedLL(list);
		// list.display();

		LinkedList list2 = new LinkedList();
		list2.addFirst(2);
		list2.addLast(3);
		list2.addLast(4);
		list2.addLast(5);
		list2.addLast(13);
		list2.display();
		System.out.println("*********");
		// LinkedList dis = MergeSortedLL(list, list2);
		// dis.display();

		// BubbleSortLLrec(list2, list2.size - 1);
		// SelectionSortLLrec(list2, list2.size - 1, list2.head);

		// InsertionSortLLrec(list2, 0);
		// System.out.println(LListPalindrome(list2));
		// list2.reverseDR(list2.head, list2.tail, 0);
		EvenAfterOddLL(list2);
		list2.display();
		AppendLastN(list2, 3);
		list2.display();

	}

	// do it by swapping pointers too
	public static void SwapElementsLL(LinkedList a, int idx1, int idx2) throws Exception {
		if (idx1 < 0 || idx1 >= a.size()) {
			throw new Exception("index out of bound.");
		}
		if (idx2 < 0 || idx2 >= a.size()) {
			throw new Exception("index out of bound.");
		}
		Node temp1 = a.getNodeAt(idx1);
		Node temp2 = a.getNodeAt(idx2);
		int temp = temp1.data;
		temp1.data = temp2.data;
		temp2.data = temp;

	}

	public static void RmvDupliSortedLL(LinkedList a) {
		Node prev = a.head;
		Node curr = prev.next;
		while (curr.next != null) {
			if (prev.data == curr.data) {
				while (prev.data == curr.data) {
					if (curr.next == null) {
						prev.next = null;
						return;
					}
					curr = curr.next;
				}
				prev.next = curr;
			}
			prev = curr;
			curr = curr.next;
		}
	}

	public static LinkedList MergeSortedLL(LinkedList a, LinkedList b) {
		LinkedList rv = new LinkedList();
		Node aNode = a.head;
		Node bNode = b.head;
		while (aNode != null || bNode != null) {
			if (aNode == null || bNode == null) {
				break;
			}
			if (aNode.data < bNode.data) {
				rv.addLast(aNode.data);
				aNode = aNode.next;
			} else {
				rv.addLast(bNode.data);
				bNode = bNode.next;
			}
		}
		if (aNode == null) {
			while (bNode != null) {
				rv.addLast(bNode.data);
				bNode = bNode.next;
			}
		}
		if (bNode == null) {
			while (aNode != null) {
				rv.addLast(aNode.data);
				aNode = aNode.next;
			}
		}
		return rv;
	}

	public static void BubbleSortLLrec(LinkedList a, int counter) {
		if (counter == 0) {
			return;
		}
		Node curr = a.head;
		Node nxt = curr.next;
		for (int i = 0; i < counter; i++) {
			if (curr.data > nxt.data) {
				int temp = curr.data;
				curr.data = nxt.data;
				nxt.data = temp;
			}
			curr = nxt;
			nxt = nxt.next;

		}
		BubbleSortLLrec(a, counter - 1);
	}

	public static void SelectionSortLLrec(LinkedList a, int counter, Node curr) {
		if (counter == 0) {
			return;
		}
		Node nxt = curr.next;
		for (int i = 0; i < counter; i++) {
			if (curr.data > nxt.data) {
				int temp = curr.data;
				curr.data = nxt.data;
				nxt.data = temp;
			}
			nxt = nxt.next;
		}
		SelectionSortLLrec(a, counter - 1, curr.next);
	}

	// not working

	public static void InsertionSortLLrec(LinkedList a, int counter) throws Exception {
		if (counter == a.size - 1) {
			return;
		}
		Node curr = a.getNodeAt(counter);
		Node nxt = curr.next;
		for (int i = 0; i <= counter; i++) {
			if (curr.data > nxt.data) {
				int temp = curr.data;
				curr.data = nxt.data;
				nxt.data = temp;
			}
			if (counter != 0) {
				curr = a.getNodeAt(counter - i - 1);
				nxt = curr.next;
			}

		}
		InsertionSortLLrec(a, counter + 1);

	}

	public static boolean LListPalindrome(LinkedList a) throws Exception {
		int counter = a.size / 2;
		Node left = a.head;
		Node right = a.tail;
		int i = 2;
		while (counter != 0) {
			if (right.data != left.data) {
				return false;
			}
			left = left.next;
			right = a.getNodeAt(a.size - i);
			counter--;
		}

		return true;
	}

	// do it in O(n)
	public static void EvenAfterOddLL(LinkedList a) {
		int counter = a.size - 1;

		while (counter > 0) {
			int i = counter;
			Node curr = a.head;
			Node nxt = curr.next;

			while (i > 0) {
				if (curr.data % 2 == 0 && nxt.data % 2 == 1) {
					int temp = curr.data;
					curr.data = nxt.data;
					nxt.data = temp;
				}
				curr = nxt;
				nxt = nxt.next;
				i--;
			}
			counter--;

		}
	}

	public static void AppendLastN(LinkedList a, int n) throws Exception {
		if (n < 0 || n >= a.size) {
			throw new Exception("index out of bound.");
		}
		Node prev = a.getNodeAt(a.size - (n + 1));
		Node NewHead = prev.next;
		Node nxt = NewHead.next;
		prev.next = null;
		nxt.next = a.head;
		a.head = NewHead;
		a.tail = prev;
	}

	// hint for last question and remaining - remove and add
}
