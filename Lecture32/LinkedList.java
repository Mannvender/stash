package Lecture32;

public class LinkedList<T> {
	// should be private
	public class Node {
		T data;
		Node next;

		public Node(T data, Node n) {
			this.data = data;
			this.next = n;
		}
	}

	Node head;
	Node tail;
	int size;

	public LinkedList() {
		head = null;
		tail = null;
		size = 0;

	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public void display() {
		Node temp = this.head;
		while (temp != null) {
			System.out.print(temp.data + ",");
			temp = temp.next;
		}
		System.out.println("END");
		System.out.println("****");
	}

	public void addFirst(T data) {
		Node node = new Node(data, this.head);
		if (this.size == 0) {
			this.head = node;
			this.tail = node;
		} else {
			this.head = node;
		}
		this.size++;
	}

	public void addLast(T data) {
		Node node = new Node(data, null);
		if (this.size == 0) {
			this.head = node;
			this.tail = node;
		} else {
			this.tail.next = node;
			this.tail = node;
		}
		this.size++;
	}

	public void addAt(T data, int idx) throws Exception {
		if (idx < 0 || idx >= this.size) {
			throw new Exception("index out of bound.");
		}

		if (idx == 0) {
			this.addFirst(data);
		} else if (idx == this.size) {
			this.addLast(data);
		} else {
			Node Nm1 = getNodeAt(idx - 1);
			Node Np1 = Nm1.next;
			Node node = new Node(data, Np1);
			Nm1.next = node;
			this.size++;
		}

	}

	public T getfirst() throws Exception {
		if (size == 0) {
			throw new Exception("empty");
		}
		return this.head.data;
	}

	public T getLast() throws Exception {
		if (size == 0) {
			throw new Exception("empty");
		}
		return this.tail.data;
	}

	// should be private
	public Node getNodeAt(int idx) throws Exception {
		if (idx < 0 || idx >= this.size) {
			throw new Exception("index out of bound.");
		}
		int rv = 0;
		Node temp = this.head;
		if (temp == null) {
			throw new Exception("empty");
		}
		while (rv != idx) {
			temp = temp.next;
			rv++;
		}

		return temp;

	}

	public T getAt(int idx) throws Exception {
		Node node = getNodeAt(idx);
		return node.data;
	}

	public T removeFirst() throws Exception {
		T rv = null;
		if (size == 0) {
			throw new Exception("empty");
		} else if (this.size == 1) {
			rv = this.head.data;
			this.head = null;
			this.tail = null;

			this.size--;
			return rv;
		}
		rv = this.head.data;
		head = this.head.next;

		this.size--;
		return rv;
	}

	public T removeLast() throws Exception {

		if (size == 0) {
			throw new Exception("empty");
		} else if (this.size == 1) {
			T rv = this.head.data;
			this.head = null;
			this.tail = null;
			return rv;
		} else {
			Node temp = getNodeAt(this.size - 2);
			T rv = temp.next.data;
			this.tail = temp;
			temp.next = null;

			this.size--;
			return rv;
		}

	}

	public T removeAt(int idx) throws Exception {
		T rv = null;
		if (idx < 0 || idx >= this.size) {
			throw new Exception("index out of bound.");
		} else if (idx == 0) {
			rv = this.removeFirst();
		} else if (idx == this.size - 1) {
			rv = this.removeLast();
		} else {
			Node Nm1 = getNodeAt(idx - 1);
			rv = Nm1.next.data;
			Node Np1 = Nm1.next.next;
			Nm1.next = Np1;
			this.size--;
		}

		return rv;
	}

	public void reverseDI() throws Exception {
		if (size == 0) {
			throw new Exception("empty");
		}
		Node left = this.head;
		Node right = this.tail;
		int counter = this.size / 2;
		int i = 2;
		while (counter != 0) {
			T temp = left.data;
			left.data = right.data;
			right.data = temp;
			left = left.next;
			right = getNodeAt(size - i);
			i++;
			counter--;
		}
	}

	public void reversePI() throws Exception {
		if (size == 0) {
			throw new Exception("empty");
		}
		if (this.size == 1) {
			return;
		} else if (this.size == 2) {
			this.tail.next = head;
			this.head.next = null;
			Node temp = this.head;
			this.head = this.tail;
			this.tail = temp;
		} else {
			Node pre = this.head;
			Node cur = pre.next;
			Node suc = cur.next;
			pre.next = null;
			int counter = this.size - 1;
			while (counter != 0) {
				cur.next = pre;
				pre = cur;
				cur = suc;
				if (suc == null) {
					break;
				}
				suc = suc.next;
				counter--;
			}
			Node temp = this.head;
			this.head = this.tail;
			this.tail = temp;

		}
	}

	// not working //my try
	public void reversePR(Node curr, Node prev, Node succ) {
		if (succ == null) {
			curr.next = prev;
			Node temp = this.head;
			this.head = this.tail;
			this.tail = temp;
		}
		if (this.size == 0) {
			return;
		}
		if (this.size == 1) {
			return;
		}
		if (this.size == 2) {
			this.tail.next = head;
			this.head.next = null;
			Node temp = this.head;
			this.head = this.tail;
			this.tail = temp;
		}
		curr.next = prev;
		prev = curr;
		curr = succ;
		succ = succ.next;
		reversePR(curr, prev, succ);

	}

	public void reversePR() {
		reversePR(head);
		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;
		tail.next = null;

	}

	private void reversePR(Node right) {
		if (right == tail) {
			return;
		}
		reversePR(right.next);
		right.next.next = right;
	}

	private class HeapMover {
		Node node;

		public HeapMover(Node node) {
			this.node = node;
		}
	}

	public void reverseDR() {
		HeapMover Hnode = new HeapMover(this.head);

		reverseDR(Hnode, this.head, 0);
	}

	private void reverseDR(HeapMover left, Node right, int floor) {
		if (right == null) {
			return;
		}
		reverseDR(left, right.next, floor + 1);
		if (floor >= this.size / 2) {

			T temp = left.node.data;
			left.node.data = right.data;
			right.data = temp;
			// imp
			left.node = left.node.next;
		}
	}

	public void Fold() {
		HeapMover left = new HeapMover(this.head);
		Fold(left, this.head, 0);
	}

	private void Fold(HeapMover left, Node right, int floor) {
		if (right == tail) {
			return;
		}
		Fold(left, right.next, floor + 1);
		// work while coming back
		if (floor >= this.size / 2) {

			Node rightnext = right.next;
			Node leftnext = left.node.next;
			// removal
			right.next = null;
			// addition
			left.node.next = rightnext;
			rightnext.next = leftnext;

			// imp
			left.node = leftnext;

		}
		if (floor == this.size / 2) {
			this.tail = right;
		}
	}

	public void LastNth(int n) {
		HeapMoverz num = new HeapMoverz(n);
		this.LastNth(this.head, num);
		System.out.println(num.data);

	}

	public class HeapMoverz {
		T data;
		int pos;

		public HeapMoverz(int pos) {
			this.pos = pos;
		}
	}

	private void LastNth(Node right, HeapMoverz n) {
		if (right == null) {
			return;
		}
		LastNth(right.next, n);
		n.pos--;
		if (n.pos == 0) {
			n.data = right.data;
		}
	}

	public void KthNodeLast(int k) {
		KthNodeLastz(k);
	}

	private void KthNodeLastz(int k) {
		int counter = 0;
		Node fast = this.head;
		Node slow = this.head;
		while (counter < k) {
			fast = fast.next;
			counter++;
		}
		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		System.out.println(slow.data);
	}

	public void mid() {
		Node rv = midz();
		System.out.println(rv.data);
	}

	private Node midz() {
		Node fast = this.head, slow = this.head;

		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

	public int find(T data) {
		int rv = 0;
		Node temp = this.head;
		while (temp != null) {
			if (temp.data.equals(data)) {
				return rv;
			}
			temp = temp.next;
			rv++;
		}
		return -1;
	}

}
