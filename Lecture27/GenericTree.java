package Lecture27;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class GenericTree {
	// contains data and ArrayList of its children;
	private class Node {
		int data;
		ArrayList<Node> children;

		// constructor sets the data and new the arraylist for its children
		public Node(int data) {
			this.data = data;
			this.children = new ArrayList<>();
		}
	}

	// Gt contains a Node property Named ROOT and a integer SIZE
	private Node root;
	private int size;

	/*
	 * Gt constructor calls the TAKEINPUT func. because we don't have any ADD
	 * func here in GT;
	 */
	public GenericTree() {
		// Passing a Scanner to take input so we can pass all inputs Together
		Scanner scn = new Scanner(System.in);
		this.root = takeInput(scn, null, -1);
	}

	private Node takeInput(Scanner scn, Node parent, int ith) {
		if (parent == null) {
			System.out.println("Enter data for ROOT node.");
		} else {
			System.out.println("Enter data for " + ith + " child of " + parent.data);
		}
		int data = scn.nextInt();
		Node child = new Node(data);
		this.size++;

		System.out.println("Enter number of children for " + child.data);
		int nc = scn.nextInt();
		for (int i = 0; i < nc; i++) {
			Node grandchild = takeInput(scn, child, i);
			child.children.add(grandchild);
		}

		return child;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void display() {
		this.display(root);
	}

	private void display(Node node) {
		// no need for Base Case in all Recursive functions here because if a
		// NOde is leaf node then it will have children.size()=0 and it will
		// skip the "for" loop
		System.out.print(node.data + "=>");
		for (int i = 0; i < node.children.size(); i++) {
			Node temp = node.children.get(i);
			System.out.print(temp.data + ",");
		}
		System.out.println("END");
		for (int i = 0; i < node.children.size(); i++) {
			Node temp = node.children.get(i);
			display(temp);
		}
	}

	public int size2() {
		return this.size2(this.root);
	}

	// it takes Node as input and return size of tree below it including the
	// passed node
	private int size2(Node node) {
		int rv = 0;
		for (int i = 0; i < node.children.size(); i++) {
			int recResult = size2(node.children.get(i));
			rv = rv + recResult;
		}
		// to add the root node itself
		return rv + 1;

	}

	public int heigth() {
		return this.height(this.root);
	}

	private int height(Node node) {
		// to prevent height of single node from becoming 1
		int MaxChildHeight = -1;
		for (Node nodes : node.children) {
			int RecResult = height(nodes);
			if (RecResult > MaxChildHeight) {
				MaxChildHeight = RecResult;
			}
		}
		return MaxChildHeight + 1;
	}

	public int max() {
		return this.max(this.root);
	}

	private int max(Node node) {
		// so as to compare with itself
		int max = node.data;

		for (Node nodes : node.children) {
			int temp = max(nodes);
			if (temp > max) {
				max = temp;
			}
		}

		return max;

	}

	public boolean find(int data) {
		return this.find(data, this.root);
	}

	private boolean find(int data, Node node) {
		// first check with root
		if (node.data == data) {
			return true;
		}
		for (Node child : node.children) {
			boolean IsItWithChild = this.find(data, child);
			if (IsItWithChild) {
				return true;
			}
		}

		return false;
	}

	public void mirror() {
		this.mirror(this.root);
	}

	private void mirror(Node node) {
		// first ask each child to mirror itself
		for (Node child : node.children) {
			mirror(child);
		}
		// now mirror the root's children arrayList
		int left = 0, right = node.children.size() - 1;
		while (left <= right) {
			Node temp = node.children.get(left);
			node.children.set(left, node.children.get(right));
			node.children.set(right, temp);
			left++;
			right--;
		}

	}

	public void Linearize() {
		this.Linearize(this.root);
	}

	// bad code
	// Complexity O(n^2)
	private void Linearize(Node node) {
		for (Node child : node.children) {
			Linearize(child);
		}
		// to get idea about how many times we need to remove Nodes
		int TimesRemove = node.children.size() - 1;
		// i is always 1 because after we remove one Node the Next become 1st
		// Node
		for (int i = 1; TimesRemove > 0; TimesRemove--) {
			Node Leftmost = node.children.get(0);
			while (Leftmost.children.size() != 0) {
				Leftmost = Leftmost.children.get(0);
			}
			Node toAdd = node.children.get(i);
			node.children.remove(i);
			Leftmost.children.add(toAdd);

		}
	}

	public void preorder() {
		this.preorder(this.root);
	}

	private void preorder(Node node) {
		System.out.println(node.data);
		for (Node child : node.children) {
			preorder(child);
		}
	}

	public void postorder() {
		this.postorder(this.root);
	}

	private void postorder(Node node) {

		for (Node child : node.children) {
			postorder(child);
		}
		System.out.println(node.data);
	}

	public void levelorder() {
		LinkedList<Node> Queue = new LinkedList<>();
		Queue.addLast(this.root);
		while (!Queue.isEmpty()) {
			Node temp = Queue.removeFirst();
			System.out.println(temp.data);
			for (Node child : temp.children) {
				Queue.addLast(child);
			}
		}

	}

	public void preorderIterative() {
		LinkedList<Node> Stack = new LinkedList<>();
		Stack.add(this.root);
		while (!Stack.isEmpty()) {
			Node temp = Stack.removeFirst();
			System.out.println(temp.data);
			for (int i = temp.children.size() - 1; i >= 0; i--) {
				Stack.addFirst(temp.children.get(i));
			}

		}

	}

	public int maxSONC() {
		return this.maxSONC(this.root).data;
	}

	// bad code
	private Node maxSONC(Node node) {
		Node max = node;

		for (Node child : node.children) {
			Node C = maxSONC(child);
			// due to these two lines it is calculating SONC score again and
			// again for a single Node
			int cMax = getSONCScore(C);
			int rv = getSONCScore(max);

			if (cMax > rv) {
				max = child;
			}

		}

		return max;
	}

	// just a SONC calculator
	private int getSONCScore(Node node) {
		int rv = node.data;
		for (Node child : node.children) {
			rv = rv + child.data;
		}
		return rv;
	}

	public int maxSONC2() {
		return this.maxSONC2(this.root).node.data;
	}

	// returns HeapMover but takes Node
	private HeapMover maxSONC2(Node node) {
		HeapMover mover = new HeapMover(node);
		for (Node child : node.children) {
			HeapMover recResult = maxSONC2(child);
			if (recResult.SONCscore > mover.SONCscore) {
				mover = recResult;
			}

		}
		return mover;

	}

	private class HeapMover {
		Node node;
		int SONCscore;

		public HeapMover(Node node) {
			this.node = node;
			this.SONCscore = getSONCScore(node);
		}
	}

	public int justMax(int data) {
		HMoverJustLarger mover = new HMoverJustLarger(data);
		this.justMax(mover, this.root);
		if (mover.justLarger == Integer.MIN_VALUE) {
			System.out.println("the given value is greator than all values in the tree");
		}
		return mover.justLarger;

	}

	// use traversal method
	private void justMax(HMoverJustLarger mover, Node node) {
		if (mover.justLarger == Integer.MIN_VALUE && node.data > mover.data) {
			mover.justLarger = node.data;
		}
		if (node.data < mover.justLarger && node.data > mover.data) {
			mover.justLarger = node.data;
		}
		for (Node child : node.children) {
			justMax(mover, child);
		}

	}

	private Node getTail(Node node) {
		Node rv = node;
		while (rv.children.size() != 0) {
			rv = rv.children.get(0);
		}
		return rv;
	}

	private class heapMoverL {
		Node head;
		Node tail;

		public heapMoverL(Node node, Node node2) {
			this.head = node;
			this.tail = node2;
		}
	}

	public void Linearize2() {
		this.Linearize2(this.root);
	}

	private heapMoverL Linearize2(Node node) {
		if (node.children.size() == 0) {
			heapMoverL base = new heapMoverL(node, node);
			return base;
		}
		heapMoverL prev = Linearize2(node.children.get(0));
		while (node.children.size() > 1) {
			// removed first child and linearized
			heapMoverL curr = Linearize2(node.children.remove(1));
			// adding to first child's tail
			prev.tail.children.add(curr.head);
			prev.tail = curr.tail;

		}
		// as the function returns HeapMover,it's head must be at head of the
		// tree
		prev.head = node;

		return prev;
	}

	// can be done using HeapMover technique(see maxSONC2)
	public int getRange() {
		int[] rvv = this.getRange(this.root);
		int rv = rvv[1] - rvv[0];
		return rv;
	}

	private int[] getRange(Node node) {
		if (node.children.size() == 0) {
			int[] base = new int[2];
			base[0] = node.data;
			base[1] = node.data;
			return base;
		}
		int[] prev = getRange(node.children.get(0));
		for (int i = 1; i < node.children.size(); i++) {
			int[] curr = getRange(node.children.get(i));
			if (curr[0] < prev[0]) {
				prev[0] = curr[0];
			}
			if (curr[1] > prev[1]) {
				prev[1] = curr[1];
			}
		}
		if (node.data < prev[0]) {
			prev[0] = node.data;
		}
		if (node.data > prev[1]) {
			prev[1] = node.data;
		}

		return prev;
	}

	// using traversal technique
	public int getRange2() {

		HeapMoverRange mover = new HeapMoverRange(Integer.MIN_VALUE, Integer.MAX_VALUE);
		this.getRange2(this.root, mover);
		int rvint = mover.max - mover.min;
		return rvint;
	}

	private void getRange2(Node node, HeapMoverRange mover) {
		// work
		if (node.data > mover.max) {
			mover.max = node.data;
		}
		if (node.data < mover.min) {
			mover.min = node.data;
		}
		for (Node child : node.children) {
			getRange2(child, mover);
		}

	}

	private class HeapMoverRange {
		int max;
		int min;

		HeapMoverRange(int max, int min) {
			this.max = max;
			this.min = min;
		}

	}

	private class HMoverJustLarger {
		int data;
		int justLarger;
		int justSmaller;

		HMoverJustLarger(int data) {
			this.data = data;
			this.justLarger = Integer.MIN_VALUE;
			this.justSmaller = Integer.MAX_VALUE;
		}

	}

	// not working
	public void LinearizeTraversal() {
		HeapMoverLinarizeTraversal mover = new HeapMoverLinarizeTraversal(this.root);
		this.LinearizeTraversal(this.root, mover, null);
	}

	private void LinearizeTraversal(Node node, HeapMoverLinarizeTraversal mover, Node parentNOde) {
		if (node == null) {
			return;
		}
		if (node == this.root) {

		} else {
			if (node != mover.tail.children.get(0)) {
				parentNOde.children.remove(node);
				mover.tail.children.add(node);
			} else {
				return;
			}
		}

		if (node == mover.tail.children.get(0)) {
			mover.tail = node;
		}
		for (Node child : node.children) {
			LinearizeTraversal(child, mover, node);
		}

	}

	private class HeapMoverLinarizeTraversal {
		Node tail;
		int leafcount;

		public HeapMoverLinarizeTraversal(Node node) {
			this.tail = node;
		}
	}

	public int justMin(int data) {
		HMoverJustLarger mover = new HMoverJustLarger(data);
		this.justMin(mover, this.root);
		return mover.justSmaller;
	}

	private void justMin(HMoverJustLarger mover, Node node) {
		if (mover.justSmaller == Integer.MAX_VALUE && node.data < mover.data) {
			mover.justSmaller = node.data;
		}
		if (node.data > mover.justSmaller && node.data < mover.data) {
			mover.justSmaller = node.data;
		}
		for (Node child : node.children) {
			this.justMin(mover, child);
		}
	}

	public int SecondLargest() {
		int max = this.justMin(Integer.MAX_VALUE);
		int rv = this.justMin(max);
		return rv;
	}

	public int LeafCount() {
		HeapMoverLinarizeTraversal mover = new HeapMoverLinarizeTraversal(this.root);
		this.LeafCount(this.root, mover);
		return mover.leafcount;
	}

	private void LeafCount(Node node, HeapMoverLinarizeTraversal mover) {
		if (node.children.isEmpty()) {
			mover.leafcount++;
		}
		for (Node child : node.children) {
			this.LeafCount(child, mover);
		}
	}

	public void ReplaceNodeWithDeapth() {
		this.ReplaceNodeWithDeapth(this.root, 0);
	}

	private void ReplaceNodeWithDeapth(Node node, int level) {
		node.data = level;
		for (Node child : node.children) {
			this.ReplaceNodeWithDeapth(child, level + 1);
		}
	}

	public boolean AreTheyIdentical(GenericTree other) {
		boolean rv = this.AreTheyIdentical(other.root, this.root);
		return rv;
	}

	private boolean AreTheyIdentical(Node other, Node prime) {
		if (prime.children.size() != other.children.size()) {
			return false;
		}
		for (int i = 0; i < prime.children.size(); i++) {
			boolean Now = this.AreTheyIdentical(other.children.get(i), prime.children.get(i));
			if (!Now) {
				return false;
			}
		}
		return true;
	}
}
