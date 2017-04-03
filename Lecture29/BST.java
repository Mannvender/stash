package Lecture29;

import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.text.AbstractDocument.LeafElement;

public class BST {
	private class Node {
		int data;
		Node left;
		Node right;

		public Node(int data, Node right, Node left) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	Node root;
	int size;

	public BST() {
		this.root = null;
		this.size = 0;
	}

	public void display() {
		this.display(this.root);
		System.out.println("********");
	}

	private void display(Node node) {
		if (node.left != null) {
			System.out.print(node.left.data + " => ");
		} else {
			System.out.print("END" + "=>");
		}
		System.out.print(node.data);
		if (node.right != null) {
			System.out.print(" <= " + node.right.data);
		} else {
			System.out.print("<=" + "END");
		}
		System.out.println();
		if (node.left != null) {
			this.display(node.left);
		}
		if (node.right != null) {
			this.display(node.right);
		}
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public int size2() {
		return this.size2(this.root);
	}

	private int size2(Node node) {
		if (node == null) {
			return 0;
		}
		int lsize = this.size2(node.left);
		int rsize = this.size2(node.right);
		return lsize + rsize + 1;

	}

	public int min() {
		return this.min(this.root);
	}

	private int min(Node node) {
		int rv = node.data;
		if (node.left != null) {
			rv = this.min(node.left);
		}

		return rv;

	}

	public int max() {
		return this.max(this.root);
	}

	private int max(Node node) {
		int rv = node.data;
		if (node.right != null) {
			rv = this.max(node.right);
		}

		return rv;
	}

	public int height() {
		return this.heigth(this.root);
	}

	private int heigth(Node node) {
		int rv = -1;
		if (node == null) {
			return -1;
		}
		int lheigth = this.heigth(node.left);
		int rheight = this.heigth(node.right);

		rv = Math.max(lheigth, rheight) + 1;
		return rv;
	}

	public boolean find(int data) {
		return this.find(data, this.root);
	}

	private boolean find(int data, Node node) {
		boolean rv = false;
		if (data < node.data) {
			if (node.left != null) {
				rv = this.find(data, node.left);
			}

		} else if (data > node.data) {
			if (node.right != null) {
				rv = this.find(data, node.right);
			}

		} else {
			return true;
		}
		return rv;
	}

	public void preorder() {
		this.preorder(this.root);
		System.out.println("END");
	}

	private void preorder(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + ",");
		this.preorder(node.left);
		this.preorder(node.right);
	}

	public void postorder() {
		this.postorder(this.root);
		System.out.println("END");
	}

	private void postorder(Node node) {
		if (node == null) {
			return;
		}

		this.postorder(node.left);
		this.postorder(node.right);
		System.out.print(node.data + ",");
	}

	public void inorder() {
		this.inorder(this.root);
		System.out.println("END");
	}

	private void inorder(Node node) {
		if (node == null) {
			return;
		}

		this.inorder(node.left);
		System.out.print(node.data + ",");
		this.inorder(node.right);

	}

	public void levelorder() {
		this.levelorder(this.root);
		System.out.println("END");
	}

	private void levelorder(Node node) {
		if (node == null) {
			return;
		}
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			Node temp = queue.removeFirst();
			System.out.print(temp.data + ",");
			if (temp.left != null) {
				queue.addLast(temp.left);
			}
			if (temp.right != null) {
				queue.addLast(temp.right);
			}

		}

	}

	public void preorderI() {
		this.preorderI(this.root);
		System.out.println("END");
	}

	private void preorderI(Node node) {
		if (node == null) {
			return;
		}
		LinkedList<Node> stack = new LinkedList<>();
		stack.addFirst(node);
		while (!stack.isEmpty()) {
			Node temp = stack.removeFirst();
			System.out.print(temp.data + ",");
			if (temp.right != null) {
				stack.addFirst(temp.right);
			}
			if (temp.left != null) {
				stack.addFirst(temp.left);
			}
		}
	}

	public int diameterBtr() {
		diaPair d = dia(this.root);
		return d.dia;
	}

	private class diaPair {
		int ht;
		int dia;
	}

	private diaPair dia(Node node) {
		if (node == null) {
			diaPair base = new diaPair();
			base.dia = 0;
			base.ht = -1;
			return base;
		}
		diaPair lpair = this.dia(node.left);
		diaPair rpair = this.dia(node.right);
		diaPair rv = new diaPair();
		rv.ht = Math.max(lpair.ht, rpair.ht) + 1;
		int f1 = lpair.dia;
		int f2 = rpair.dia;
		int f3 = lpair.ht + rpair.ht + 2;
		rv.dia = Math.max(f1, Math.max(f2, f3));

		return rv;
	}

	public void add(int data) {
		if (this.isEmpty()) {
			this.root = new Node(data, null, null);
			this.size++;
		} else {
			this.addnode(data, this.root);
		}
	}

	private void addnode(int data, Node node) {
		if (data < node.data) {
			if (node.left != null) {
				this.addnode(data, node.left);
			} else {
				node.left = new Node(data, null, null);
				this.size++;
			}

		} else if (data > node.data) {
			if (node.right != null) {
				this.addnode(data, node.right);
			} else {
				node.right = new Node(data, null, null);
				this.size++;
			}
		} else {
			// wont do anything
		}

	}

	public BST(int... sa) {
		this.root = this.construct(sa, 0, sa.length - 1);
	}

	private Node construct(int[] sa, int lo, int hi) {
		if (lo > hi) {
			return null;
		}
		int mid = (lo + hi) / 2;
		Node rv = new Node(sa[mid], null, null);
		this.size++;
		rv.left = this.construct(sa, lo, mid - 1);
		rv.right = this.construct(sa, mid + 1, hi);
		return rv;
	}

	public boolean isBalanced() {
		helper rv = this.isBalanced(this.root);
		return rv.isB;
	}

	private class helper {
		boolean isB;
		int ht;
	}

	private helper isBalanced(Node node) {
		if (node == null) {
			helper base = new helper();
			base.ht = -1;
			base.isB = true;
			return base;
		}
		helper leftH = this.isBalanced(node.left);
		helper rightH = this.isBalanced(node.right);
		helper my = new helper();
		my.isB = leftH.isB && rightH.isB;
		if (leftH.ht - rightH.ht == 0 || leftH.ht - rightH.ht == 1 || leftH.ht - rightH.ht == -1) {
			my.isB = true && my.isB;
		} else {
			my.isB = false;
		}
		my.ht = Math.max(leftH.ht, rightH.ht) + 1;

		return my;

	}

	public void linearize() {
		hedTail rv = this.linearize(this.root);
		this.root = rv.head;
	}

	private class hedTail {
		Node head;
		Node tail;
	}

	private hedTail linearize(Node node) {
		if (node == null) {
			return null;
		}

		hedTail lft = this.linearize(node.left);
		hedTail rgt = this.linearize(node.right);
		node.left = null;
		if (lft != null) {
			lft.tail.right = node;
		}
		if (rgt != null) {
			node.right = rgt.head;
		}

		hedTail my = new hedTail();
		if (lft == null) {
			my.head = node;
		} else {
			my.head = lft.head;
		}
		if (rgt == null) {
			my.tail = node;
		} else {
			my.tail = rgt.tail;
		}

		return my;

	}

	public void printBw(int lower, int upper) {
		this.printBw(lower, upper, this.root);
		System.out.println("END");
	}

	private void printBw(int lower, int upper, Node node) {
		if (node == null) {
			return;
		}
		if (node.data < lower) {
			this.printBw(lower, upper, node.right);
		} else if (node.data > upper) {
			this.printBw(lower, upper, node.left);
		} else {
			this.printBw(lower, upper, node.left);
			System.out.print(node.data + ", ");
			this.printBw(lower, upper, node.right);

		}
	}

	public void remove(int data) {
		this.remove(this.root, null, true, data);
	}

	private void remove(Node node, Node parent, boolean ilc, int data) {
		if (node == null) {
			return;
		}
		if (node.data < data) {
			this.remove(node.right, node, false, data);
		} else if (node.data > data) {
			this.remove(node.left, node, true, data);
		} else {
			if (node.right != null && node.left != null) {
				int lmax = this.max(node.left);
				node.data = lmax;
				this.remove(node.left, node, true, lmax);

			} else if (node.left != null) {
				if (ilc) {
					parent.left = node.left;
				} else {
					parent.right = node.left;
				}
				this.size--;
			} else if (node.right != null) {
				if (ilc) {
					parent.left = node.right;
				} else {
					parent.right = node.right;
				}
				this.size--;
			} else {
				if (ilc) {
					parent.left = null;
				} else {
					parent.right = null;
				}
				this.size--;
			}
		}

	}
}
